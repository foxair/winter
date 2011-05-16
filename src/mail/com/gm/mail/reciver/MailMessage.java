/*
 *@# MailMessage.java 11:28:41 AM Jun 24, 2009

 */
package com.gm.mail.reciver;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gm.mail.reciver.util.JavaMailUtil;

/**
 * <p>邮件消息</p>

 * 11:28:41 AM Jun 24, 2009 
 */
public class MailMessage {

	private static final Log logger = LogFactory.getLog(MailMessage.class);

	//分隔符
	private static final String SEPARATOR = ":";
	//常见错误分隔符
	private static final String USUALLY_ERROR_SEPARATOR = "：";

	//邮件唯一ID号
	private String id;

	//发件人Email地址
	private String from;

	//收件人列表
	private List<String> to = new ArrayList<String>();

	//抄送人列表
	private List<String> cc = new ArrayList<String>();

	//密送人列表
	private List<String> bcc = new ArrayList<String>();

	//日期
	private Date date;

	//邮件标题
	private String subject;

	//邮件正文
	private String body;

	//附件列表
	private List<Attachment> attachments = new ArrayList<Attachment>();

	//邮件大小
	private int size;

	//邮件优先级，默认为3
	private int priority = 3;
	//答复人列表
	private List<String> replyList;

	/**
	 * 根据JavaMail的Message实例创建自定义MailMessage实例
	 * @param message JavaMail的Message实例
	 */
	public MailMessage(Message message) {
		try {
			this.id = JavaMailUtil.getMessageId(message);
			this.subject = message.getSubject();
			this.date = message.getSentDate();
			//邮件优先级
			if (message.getHeader("X-Priority") != null && message.getHeader("X-Priority").length >= 0) {
				this.priority = NumberUtils.toInt(
						(StringUtils.substring((String) (message.getHeader("X-Priority")[0]), 0, 1)), 3);
			}
			this.from = MailMessage.convertFirstOfAddressArrayToStr(message.getFrom());
			this.replyList = MailMessage.convertAddressToStrList(message.getReplyTo());
			this.to = MailMessage.convertAddressToStrList(message.getRecipients(RecipientType.TO));
			this.cc = MailMessage.convertAddressToStrList(message.getRecipients(RecipientType.CC));
			this.bcc = MailMessage.convertAddressToStrList(message.getRecipients(RecipientType.BCC));
			this.size = message.getSize();
			//解析正文
			this.body = extractBody(message);
			//解析附件
			try {
				this.attachments = AttachmentHandler.extractAttachments(message);
			} catch (Exception e) {
				logger.error("error when handle attachments " + e);
			}

		} catch (Exception e) {
			logger.error("error when paser javamail message to my message");
			logger.error(e);
		}
	}

	/**
	 * <p>解析邮件主体，返回无格式的内容</p>
	 * @param part 邮件主体
	 * @return
	 */
	private static String extractBody(Part part) {
		try {
			/*
			String charset = detectCharSet(part);
			if (part.isMimeType("text/plain"))
				return (String) part.getContent();
			if (part.isMimeType("text/html")) {
				part.getContent();
				String content = (String) part.getContent();
				return StringUtil.html2Text(content, charset);
			} else 
			*/
			if (part.isMimeType("multipart/*")) {
				Multipart mp = (Multipart) part.getContent();
				for (int i = 0, count = mp.getCount(); i < count; i++) {
					try {
						String body = extractBody(mp.getBodyPart(i));
						if (body != null)
							return body;
					} catch (Exception ee) {
						logger.error("Exception: ", ee);
					}
				}
			} else {
				return (String) part.getContent();
			}
		} catch (MessagingException e) {
			logger.error("Messaging error: ", e);
		} catch (IOException e) {
			logger.error("IO error: ", e);
		} catch (Throwable e) {
			logger.error("error: ", e);
		}
		return "";
	}

	/**
	 * <p>探测邮件字符集</p>
	 * @param part
	 * @return 字符集名称
	 */
	private static String detectCharSet(Part part) {
		try {
			if (part.getHeader("Content-Transfer-Encoding") != null
					&& part.getHeader("Content-Transfer-Encoding").length >= 0) {
				String encoding = part.getHeader("Content-Transfer-Encoding")[0];
				if (encoding != null && !encoding.matches("(?i)[78]bit|base64|binary|quoted-printable")) {
					logger.trace("unknown encoding: " + encoding);
					part.removeHeader("Content-Transfer-Encoding");
				}
			}
			if (part.getContentType() == null)
				return null;
			if (part.getContentType().matches("text/\\w+;\\s*[^=;\\s]+"))
				part.setHeader("Content-Type", part.getContentType().replaceFirst(";\\s*", "; charset="));
			ContentType contentType = new ContentType(part.getContentType());
			String origCharset = contentType.getParameter("charset");
			if (origCharset == null || origCharset.matches("[0-9a-zA-Z][-\\.:\\w]*")
					&& Charset.isSupported(origCharset))
				return origCharset;
			String newCharset = null;
			String normalized = StringUtils.strip(origCharset, "' ").replaceFirst("\\w+\\.", "");
			if (normalized.matches("[0-9a-zA-Z][-\\.:\\w]*") && Charset.isSupported(normalized))
				newCharset = normalized;
			if (newCharset == null)
				contentType.getParameterList().remove("charset");
			else
				contentType.setParameter("charset", newCharset);
			part.setHeader("Content-Type", contentType.toString());
			logger.trace("change charset " + origCharset + " to " + newCharset);
			return newCharset;
		} catch (MessagingException e) {
			logger.trace("error: " + e);
			return null;
		}
	}

	/**
	 * <p>获取发件人信息</p>
	 * @return the 发件人信息
	 */
	public String getForm() {
		return from;
	}

	/**
	 * <p>设置发件人信息</p>
	 * @param form 发件人信息
	 */
	public void setForm(String from) {
		this.from = from;
	}

	/**
	 * <p>获取收件人列表</p>
	 * @return 收件人列表
	 */
	public List<String> getTo() {
		return to;
	}

	/**
	 * <p>设置收件人列表</p>
	 * @param to 收件人列表
	 */
	public void setTo(List<String> to) {
		this.to = to;
	}

	/**
	 * <p>获取抄送人列表</p>
	 * @return 抄送人列表
	 */
	public List<String> getCc() {
		return cc;
	}

	/**
	 * <p>设置抄送人列表</p>
	 * @param cc 抄送人列表
	 */
	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	/**
	 * <p>获取密送人列表</p>
	 * @return 密送人列表
	 */
	public List<String> getBcc() {
		return bcc;
	}

	/**
	 * <p>设置密送人列表</p>
	 * @param bcc 密送人列表
	 */
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	/**
	 * </p>获取日期</p>
	 * @return 日期
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <p>设置日期</p>
	 * @param date 日期
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * <p>获取邮件主题</p>
	 * @return 邮件主题
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * <p>设置邮件主题</p>
	 * @param subject 邮件主题t
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * <p>获取邮件正文</p>
	 * @return 邮件正文
	 */
	public String getBody() {
		return body;
	}

	/**
	 * <p>设置邮件正文</p>
	 * @param body 邮件正文
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * <p>获取附件列表</p>
	 * @return 附件列表
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * <p>设置附件列表</p>
	 * @param attachments 附件列表
	 */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	/**
	 * <p>获取邮件大小</p>
	 * @return the 邮件大小
	 */
	public int getSize() {
		return size;
	}

	/**
	 * <p>设置邮件大小</p>
	 * @param size 邮件大小
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * <p>获取邮件优先级</p>
	 * @return 邮件优先级
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <p>设置邮件优先级</p>
	 * @param priority 邮件优先级
	 */
	public void setPriority(int priority) {
		this.priority = priority;

	}

	/**
	 * <p>获取邮件答复人列表</p>
	 * @return ArrayList
	 */
	public List<String> getReplyList() {
		return replyList;
	}

	/**
	 * <p>设置邮件优先级</p>
	 * @param list 答复人列表
	 */
	public void setReplyList(List<String> list) {
		this.replyList = list;

	}

	/**
	 * <p>将JavaMail的地址转换成自定义的字符串表示格式</p>
	 * @param address
	 * @return
	 */
	private static String convertAddressToStr(Address address) {
		if (address instanceof InternetAddress) {
			return ((InternetAddress) address).getPersonal() + MailMessage.SEPARATOR
					+ ((InternetAddress) address).getAddress();
		} else {
			return address.toString();
		}
	}

	/**
	 * <p>将JavaMail的地址数组(中的第一个地址)转换成自定义的字符串表示格式</p>
	 * @param address
	 * @return
	 */
	private static String convertFirstOfAddressArrayToStr(Address[] addresses) {
		Address address = addresses[0];
		if (address == null) {
			return null;
		}
		return convertAddressToStr(address);
	}

	/**
	 * <p>将JavaMail的地址数组转换成自定义的字符串列表表示格式</p>
	 * @param address
	 * @return
	 */
	private static List<String> convertAddressToStrList(Address[] addresses) {
		if (addresses == null) {
			return null;
		}
		//自定义地址列表
		List<String> addList = new ArrayList<String>();
		for (Address address : addresses) {
			addList.add(convertAddressToStr(address));
		}
		return addList;
	}

	public String toString() {
		return this.id + " , " + this.subject;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}

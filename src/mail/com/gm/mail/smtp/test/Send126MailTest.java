package com.gm.mail.smtp.test;

import com.gm.mail.smtp.MailMessage;
import com.gm.mail.smtp.MailSender;
import com.gm.mail.smtp.SMTPSetting;

/**
 * <p>网易126邮件发送测试</p>
 */
public class Send126MailTest {

	public static void main(String[] args) {

		//SMTP设置，包括登录用户名、密码、SMTP主机地址和端口等信息
		SMTPSetting setting = new SMTPSetting();
		setting.setSmtpHost("smtp.126.com");
		//setting.setSmtpHost("192.168.1.181");
		setting.setUserName("itworker");
		setting.setPwd("******");//换成你的密码

		//邮件内容
		MailMessage message = new MailMessage();
		message.setForm("fox:fox.hu@126.com");//发件人
		message.getTo().add("fox@corp.globalmarket.com");//收件人
		message.setSubject("this mail send by mysmtp");//主题
		message.setBody("<html>试发送中文邮件功能,测试</html>");//正文
		message.setPriority(1);//邮件优先级1为高,3为中,5为低
		message.getReplyList().add("fox.hu@163.com");//抄送列表

		//附件
		//Attachment att = new Attachment();
		//att.setFileName("xxx.java");//附件名
		//att.setFilePath("C:\\TestCase.java");//设置附件的路径

		//message.addAttachment(att);

		//发送邮件
		try {
			MailSender.sendMail(setting, message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

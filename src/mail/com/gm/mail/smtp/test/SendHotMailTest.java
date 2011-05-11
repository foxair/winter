package com.gm.mail.smtp.test;

import java.util.ArrayList;
import java.util.List;

import com.gm.mail.smtp.MailMessage;
import com.gm.mail.smtp.MailSender;
import com.gm.mail.smtp.SMTPSetting;
import com.gm.mail.smtp.SMTPSetting.SMTPEncrypt;

/**
 * <p>雅虎邮件发送测试</p>
 */
public class SendHotMailTest {

	public static void main(String[] args) {

		//SMTP设置，包括登录用户名、密码、SMTP主机地址和端口等信息
		SMTPSetting setting = new SMTPSetting();
		setting.setSmtpHost("smtp.live.com");
		setting.setUserName("azheng@hotmail.com");//注意用户名必须是全称
		setting.setPwd("******");//换成你的密码
		setting.setEnc(SMTPEncrypt.TLS);//需要TLS支持

		//邮件内容
		MailMessage message = new MailMessage();
		message.setForm("azheng@yahoo.com");//发件人，原来HotMail还可以伪造发件人
		List<String> toList = new ArrayList<String>();//收件人列表
		toList.add("fox@corp.globalmarket.com");
		message.setTo(toList);
		message.setSubject("this mail send by mysmtp");//主题
		message.setBody("hello world!");//正文
		message.setPriority(3);//邮件优先级1为高,3为中,5为低，默认为中

		//发送邮件
		try {
			MailSender.sendMail(setting, message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

package com.yijianwan;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class MyMailUtil {

	public static final String SMTPSERVER = "smtp.163.com";
	public static final String SMTPPORT = "465";
	public static final String ACCOUT = "as849167276@163.com";
	public static final String PWD = "Declared.";

	/**
	 * ���ʼ�
	 * 
	 * @param sender
	 * @param name
	 * @param title
	 * @param content
	 * @param acceptor
	 * @return 
	 * @throws Exception
	 */
	public String sendEmail(String sender,String possword, String name, String title,
			String content, String acceptor) throws Exception {
		//����У��
		if(!checkMail(sender)){
			return "�����������ʽ����";
		}
		if(!checkMail(acceptor)){
			return "�ռ��������ʽ����";
		}
		

		// �����ʼ�����
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp"); // ʹ�õ�Э�飨JavaMail�淶Ҫ��
		props.setProperty("mail.smtp.host", SMTPSERVER); // �����˵������ SMTP ��������ַ
		props.setProperty("mail.smtp.port", SMTPPORT);
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.auth", "true"); // ��Ҫ������֤
		props.setProperty("mail.smtp.ssl.enable", "true");// ����ssl

		// �����ʼ����ô����Ự��ע��session�𵼴��
		Session session = Session.getDefaultInstance(props);
		// ����debugģʽ�����Կ���������ϸ��������־
		session.setDebug(true);
		// �����ʼ�
		MimeMessage message = createEmail(session, sender, name, title,
				content, acceptor);
		// ��ȡ����ͨ��
		Transport transport = session.getTransport();
		transport.connect(SMTPSERVER, sender, possword);
		// ���ӣ��������ʼ�
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		return "���ͳɹ�";
	}

	public MimeMessage createEmail(Session session, String sender, String name,
			String title, String content, String acceptor) throws Exception {
		// ���ݻỰ�����ʼ�
		MimeMessage msg = new MimeMessage(session);
		// address�ʼ���ַ, personal�ʼ��ǳ�, charset���뷽ʽ
		InternetAddress fromAddress = new InternetAddress(sender, name, "utf-8");
		// ���÷����ʼ���
		msg.setFrom(fromAddress);
		InternetAddress receiveAddress = new InternetAddress(acceptor, "test",
				"utf-8");
		// �����ʼ����շ�
		msg.setRecipient(RecipientType.TO, receiveAddress);
		// �����ʼ�����
		msg.setSubject(title, "utf-8");
		msg.setText(content);
		// ������ʾ�ķ���ʱ��
		msg.setSentDate(new Date());
		// ��������
		msg.saveChanges();
		return msg;
	}

	public boolean checkMail(String email) {
		boolean tag = true;
		if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
			tag = false;
		}
		return tag;
	}
}
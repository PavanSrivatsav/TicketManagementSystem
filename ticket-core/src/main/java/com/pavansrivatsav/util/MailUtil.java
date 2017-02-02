package com.pavansrivatsav.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailUtil {

	private MailUtil() {
		}

	// public static void sendSimpleMail(Reply reply) throws EmailException {
	// Email email = new SimpleEmail();
	// email.setSmtpPort(465);
	// email.setAuthenticator(new DefaultAuthenticator("admin", "admin"));
	// email.setDebug(false);
	// email.setHostName("smtp.gmail.com");
	// email.setSSLOnConnect(true);
	// email.setFrom("ashpeekay23@gmail.com");// Admin email
	// email.setSubject("Comment on your article");
	// email.setMsg(reply.getCommentUserId().getUserDomainName() + "" +
	// reply.getCommentText());
	// email.addTo(reply.getCommentArticleId().getUserId().getEmailId());
	// email.setStartTLSEnabled(true);
	// email.send();
	//
	// }
}
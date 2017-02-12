package com.pavansrivatsav.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailUtil {

	private MailUtil() {
	}

	// User mail
	public static void sendAdminMail(String mail, String message, int issueId) throws EmailException {
		Email email = new SimpleEmail();

		email.setSmtpPort(587);

		email.setAuthenticator(new DefaultAuthenticator("ticketmanagement.tms@gmail.com", "ticket123"));
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("ticketmanagement.tms@gmail.com");
		email.setSubject("Ticket Management System");
		email.setMsg(message + issueId);
		email.addTo(mail);
		email.setStartTLSEnabled(true);
		email.send();

	}

	public static void sendUserMail(String mail, String message, String solution) throws EmailException {
		Email email = new SimpleEmail();

		email.setSmtpPort(587);

		email.setAuthenticator(new DefaultAuthenticator("ticketmanagement.tms@gmail.com", "ticket123"));
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("ticketmanagement.tms@gmail.com");
		email.setSubject("Ticket Management System");
		email.setMsg(message + solution);
		email.addTo(mail);
		email.setStartTLSEnabled(true);
		email.send();

	}
}
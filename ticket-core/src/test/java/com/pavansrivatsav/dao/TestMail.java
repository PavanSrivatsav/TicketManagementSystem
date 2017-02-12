package com.pavansrivatsav.dao;

import com.pavansrivatsav.util.MailUtil;

public class TestMail {
	public static void main(String[] args) {
		try {
			String emailId = "pavansrivatsav96@gmail.com";
			int ticketId = 1;
			String subject = "ID CARD";
			MailUtil.sendAdminMail(emailId, "Ticket Created Sucessfully on " + subject + ".Your Ticket id is:",
					ticketId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

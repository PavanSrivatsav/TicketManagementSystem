package com.pavansrivatsav.dao;

import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.modal.UserDetail;

public class TestUserModule {
	/* user modules validation */
	public static void main(String[] args) {
		UserModule mod = new UserModule();

		/* closed ticket */
		// System.out.println(mod.closeTicket("GOWTHAMGOW@GMAIL.COM",
		// "GOWPASSWORD", 1));

		/* Display ticket */

		// UserDetailDAO dao = new UserDetailDAO();
		// System.out.println(dao.getUserId("GOWTHAMGOW@GMAIL.COM"));
		// System.out.println(mod.displayTicket("GOWTHAMGOW@GMAIL.COM",
		// "GOWPASSWORD"));

		/* Login */

		// UserLoginDAO login = new UserLoginDAO();
		// System.out.println(login.logIn("GOWTHAMGOW@GMAIL.COM",
		// "GOWPASSWORD"));

		/* Ticket Generation */

		TicketDetail ticketDetail = new TicketDetail();
		Department dept = new Department();
		UserDetail user = new UserDetail();
		user.setId(1);
		dept.setId(1);
		ticketDetail.setTicketDept(dept);
		ticketDetail.setDescription("Laptop");
		ticketDetail.setUser(user);
		ticketDetail.setSubject("Wifi- Problem");
		System.out.println(mod.ticketGenerate(ticketDetail));
	}
}

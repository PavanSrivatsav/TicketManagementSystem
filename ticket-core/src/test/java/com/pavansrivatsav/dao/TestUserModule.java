package com.pavansrivatsav.dao;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.service.EmployeeModuleService;
import com.pavansrivatsav.service.UserModuleService;
import com.pavansrivatsav.validator.UserModuleValidator;

public class TestUserModule {
	/* user modules validation */
	public static void main(String[] args) throws PersistenceException, ServiceException, ValidationException {
		UserModule mod = new UserModule();
		UserDetailDAO udao = new UserDetailDAO();

		// /* closed ticket */
		//
		// // System.out.println(mod.closeTicket("GOWTHAMGOW@GMAIL.COM",
		// // "GOWPASSWORD", 1));
		//
		// /* Display ticket */
		//
		// // UserDetailDAO dao = new UserDetailDAO();
		// // System.out.println(dao.getUserId("GOWTHAMGOW@GMAIL.COM"));
		// // System.out.println(mod.displayTicket("GOWTHAMGOW@GMAIL.COM",
		// // "GOWPASSWORD"));
		//
		// /* Login */
		//
		// // LoginDAO login = new LoginDAO();
		// // System.out.println(login.logIn("GOWTHAMGOW@GMAIL.COM",
		// // "GOWPASSWORD"));
		//
		// /* Ticket Generation */
		//
		TicketDetail ticketDetail = new TicketDetail();
		// // Department dept = new Department();
		// // UserDetail user = new UserDetail();
		// // user.setId(1);
		// // dept.setId(1);
		// // ticketDetail.setTicketDept(dept);
		// // ticketDetail.setDescription("Laptop");
		// // ticketDetail.setUser(user);
		// // ticketDetail.setSubject("Wifi- Problem");
		// // ticketDetail.setPriority("high");
		// // System.out.println(mod.ticketGenerate(ticketDetail));
		//
		// // UserModuleService ums = new UserModuleService();
		// // // ums.logIn("GOWTHAMGOW@GMAIL.COM", "GOWPASSWORD");
		// // // ticketDetail.setPriority("high");
		// // // ums.ticketGeneration(ticketDetail, "GOWTHAMGOW@GMAIL.COM",
		// // // "GOWPASSWORD");
		// UserModuleValidator umv = new UserModuleValidator();
		//
		// UserModuleService ums = new UserModuleService();
		//
		// // // umv.priorityValidation("");
		//
		// // UserDetail user = new UserDetail();
		// // user.setId(1);
		//
		// // ticketDetail.setUser(user);
		UserDetail user = new UserDetail();
		// ud.setId(1);
		// ticketDetail.setUser(ud);
		Department dept = new Department();
		// dept.setId(1);
		// ticketDetail.setTicketDept(dept);
		// ticketDetail.setDescription("hii");
		// ticketDetail.setSubject("hii");
		// ticketDetail.setPriority("hii");
		// umv.ticketGenerate(ticketDetail);
		// ums.ticketGeneration(ticketDetail, "GOWTHAMGOW@GMAIL.COM",
		// "GOWPASSWORD");
		//
		// EmployeeModuleService login = new EmployeeModuleService();
		// login.logIn("gowtham@gmail.com", "gowtham14");

		UserModuleService logins = new UserModuleService();
		// // logins.logIn("gowthamgow@gmail.com", "gowpassord");
		// user.setId(1);
		// ticketDetail.setUser(user);
		// ticketDetail.setSubject("testing");
		// ticketDetail.setDescription("testing");
		// ticketDetail.setPriority("high");
		// dept.setId(1);
		// ticketDetail.setTicketDept(dept);
		//
		// // ums.ticketGeneration(ticketDetail, "gowtham@gmail.com",
		// // "gowtham1234");
		// // logins.ticketGeneration(ticketDetail, "gowtham@gmail.com",
		// // "gowtham1234");
		// mod.ticketGenerate(ticketDetail, "gowtham@gmail.com", "gowtham1234");

		System.out.println(udao.getUserId("GOWTHAMGOW@GMAIL.COM").getId());
		// logins.closeTicket("gowtham@gmail.com", "gowpassword", 7);//service
		//	mod.closeTicket("gowtham@gmail.com", "gowpassword", 7);

	}
}

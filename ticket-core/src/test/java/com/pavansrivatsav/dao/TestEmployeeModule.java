package com.pavansrivatsav.dao;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.service.EmployeeModuleService;
import com.pavansrivatsav.validator.EmployeeModuleValidator;

public class TestEmployeeModule {
	public static void main(String args[]) throws ServiceException, ValidationException, PersistenceException {
		EmployeeModule empmod = new EmployeeModule();
		EmployeeDetail emp = new EmployeeDetail();
		TicketDetail ticketDetail = new TicketDetail();
		IssueHistory ih = new IssueHistory();
		EmployeeModuleService ems = new EmployeeModuleService();
		EmployeeModuleValidator emv = new EmployeeModuleValidator();
		EmployeeDetailDAO empdao = new EmployeeDetailDAO();
		/* Assign ticket */

		// emp.setId(1);
		// ticketDetail.setEmp(emp);
		// ticketDetail.setId(2);
		// System.out.println(empmod.assignTicketToEmployee(ticketDetail));

		/* select tickets */

		// EmployeeDetailDAO dao = new EmployeeDetailDAO();
		// System.out.println(dao.getUserId("pavan@gmail.com").getId());
		//System.out.println(empmod.displayTicket("GOWTHAM@GMAIL.COM", "GOWPASSWORD"));

		/* Reply tickets */
		// ticketDetail.setId(1);
		// ih.setTicketId(ticketDetail);
		// ih.setSolution("my head!!");
		// System.out.println(empmod.employeeReply(ih));

		/* Resolve update */
		// System.out.println(empmod.employeeResolve(1));

		/* Reassign */

		// System.out.println(empmod.employeeReassign(1, 1));

		/* Delete Ticket */

		// ems.deleteTicket("pavan@gmail.com", "pavan1234", 1);
		// emv.deleteTicket("pavan@gmail.com", 1);
		// empmod.assignTicketToEmployee("GOWTHAM@GMAIL.COM", 2, 1);
		// ems.assignTicket("PAVAN@GMAIL.COM", 2, 1);
//		empdao.getEmpId("GOWTHAM@GMAIL.COM");
//		IssueHistory history = new IssueHistory();
//		TicketDetail td= new TicketDetail();
//		td.setId(2);
//		history.setTicketId(td);
//		history.setSolution("test");
//		empmod.employeeReply(history);
		empmod.reAssignTicketToEmployee(2,6);

	}
}

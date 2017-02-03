package com.pavansrivatsav.dao;

import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.modal.TicketDetail;

public class TestEmployeeModule {
	public static void main(String args[]) {
		EmployeeModule empmod = new EmployeeModule();
		EmployeeDetail emp = new EmployeeDetail();
		TicketDetail ticketDetail = new TicketDetail();
		IssueHistory ih = new IssueHistory();
		/* Assign ticket */

		// emp.setId(1);
		// ticketDetail.setEmp(emp);
		// ticketDetail.setId(2);
		// System.out.println(empmod.assignTicketToEmployee(ticketDetail));

		/* select tickets */

		// EmployeeDetailDAO dao = new EmployeeDetailDAO();
		// System.out.println(dao.getUserId("pavan@gmail.com").getId());
		// System.out.println(empmod.displayTicket("pavan@gmail.com", "pavan"));

		/* Reply tickets */
		// ticketDetail.setId(1);
		// ih.setTicketId(ticketDetail);
		// ih.setSolution("my head!!");
		// System.out.println(empmod.employeeReply(ih));

		/* Resolve update */
		// System.out.println(empmod.employeeResolve(1));

		/* Reassign */

		// System.out.println(empmod.employeeReassign(1, 1));
	}
}

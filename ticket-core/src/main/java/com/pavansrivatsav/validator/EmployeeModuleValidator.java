package com.pavansrivatsav.validator;

import com.pavansrivatsav.dao.EmployeeModule;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.ValidationUtil;

public class EmployeeModuleValidator {
	private TicketDetailValidator tdv = new TicketDetailValidator();
	private IssueHistoryValidator ihv = new IssueHistoryValidator();
	private EmployeeDetailValidation edv = new EmployeeDetailValidation();

	public void employeeModuleValidation(EmployeeModule empMod) throws ValidationException {

		ValidationUtil.isInvalidObject(empMod, "Invalid Operation");
	}

	public void assignTicket(TicketDetail ticketDetail) throws ValidationException {

		tdv.ticketValidation(ticketDetail);
		tdv.employeeAssignedValidation(ticketDetail.getEmp().getId());
		tdv.statusValidation(ticketDetail.getStatus());
		tdv.idvalidation(ticketDetail.getId());

	}

	public void employeeReply(IssueHistory issueHistory) throws ValidationException {
		ihv.solutionValidation(issueHistory.getSolution());
		ihv.idvalidation(issueHistory.getId());
	}

	public void employeeResolve(Integer ticketid) throws ValidationException {
		tdv.idvalidation(ticketid);
	}

	public void employeeReassign(Integer empId, Integer ticketId) throws ValidationException {
		tdv.idvalidation(empId);
		tdv.idvalidation(ticketId);
	}

	public void deleteTicket(String emailId, int ticketId) throws ValidationException {
		edv.emailValidation(emailId);
		tdv.idvalidation(ticketId);
	}

}

package com.pavansrivatsav.service;

import org.apache.commons.mail.EmailException;

import com.pavansrivatsav.dao.EmployeeModule;
import com.pavansrivatsav.dao.LoginDAO;
import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.MailUtil;
import com.pavansrivatsav.util.ValidationUtil;
import com.pavansrivatsav.validator.TicketDetailValidator;

public class EmployeeModuleService {
	private LoginDAO login = new LoginDAO();
	private EmployeeModule empmod = new EmployeeModule();
	private TicketDetailValidator tdv = new TicketDetailValidator();
	private String properInputs = "Please enter proper inputs";

	public void logIn(String emailId, String pwd) throws ServiceException {
		try {
			ValidationUtil.validateLogin(emailId, pwd);
			login.employeeLogIn(emailId, pwd);
		} catch (ValidationException e) {
			throw new ServiceException(properInputs, e);
		} catch (PersistenceException e) {
			throw new ServiceException("Please check your email id or password ", e);
		}
	}

	public void deleteTicket(String emailId, String pwd, TicketDetail ticketDetail) throws ServiceException {
		try {
			ValidationUtil.validateLogin(emailId, pwd);

			empmod.deleteTicket(ticketDetail);

		} catch (ValidationException e) {
			throw new ServiceException(properInputs, e);
		} catch (PersistenceException e) {
			throw new ServiceException("Try a diff email id or ticket id", e);
		}
	}

	public void assignTicket(String emailId, int toEmpId, int ticId) throws ServiceException {
		try {

			tdv.idvalidation(ticId);
			empmod.assignTicketToEmployee(emailId, toEmpId, ticId);

		} catch (ValidationException e) {
			throw new ServiceException(properInputs, e);
		} catch (PersistenceException e) {

			throw new ServiceException("Try a diff ticket Id or employee id", e);
		}
	}

	public void reassignTicket(String emailId, String pwd, int toEmpId, int ticId) throws ServiceException {
		try {
			ValidationUtil.validateLogin(emailId, pwd);
			if (login.employeeLogIn(emailId, pwd))

			{

				tdv.idvalidation(ticId);
				empmod.assignTicketToEmployee(emailId, toEmpId, ticId);
			}
		} catch (ValidationException e) {
			throw new ServiceException("Enter proper inputs", e);
		} catch (PersistenceException e) {

			throw new ServiceException("Try a diff email id or ticket id", e);
		}
	}

	public void replyToTicket(IssueHistory issue) throws ServiceException {
		try {

			Integer ticketId = issue.getTicketId().getId();
			String userEmailId = empmod.getemailIdByTicketId(ticketId);
			String solution = issue.getSolution();
			empmod.employeeReply(issue);
			MailUtil.sendUserMail(userEmailId, "Solution for your TicketId " + ticketId + " is: \n\n", solution);
		}

		catch (PersistenceException e) {
			throw new ServiceException("Try a diff ticket id", e);
		} catch (EmailException e) {
			throw new ServiceException("Try a different ticket id", e);
		}
	}
}

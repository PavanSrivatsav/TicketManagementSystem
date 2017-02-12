package com.pavansrivatsav.service;

import java.util.List;

import org.apache.commons.mail.EmailException;

import com.pavansrivatsav.dao.LoginDAO;
import com.pavansrivatsav.dao.UserModule;
import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.MailUtil;
import com.pavansrivatsav.util.ValidationUtil;
import com.pavansrivatsav.validator.UserModuleValidator;

public class UserModuleService {
	private LoginDAO login = new LoginDAO();
	private UserModule userModule = new UserModule();
	private UserModuleValidator userModuleValidator = new UserModuleValidator();
	private String properInputs = "Please enter proper inputs";

	public void logIn(String emailId, String password) throws ServiceException {
		try {
			ValidationUtil.validateLogin(emailId, password);
			login.userLogIn(emailId, password);
		} catch (ValidationException e) {
			throw new ServiceException(properInputs, e);
		} catch (PersistenceException e) {
			throw new ServiceException("Please check your email id and password", e);
		}
	}

	public void ticketGeneration(TicketDetail ticketDetail, String emailId) throws ServiceException {
		try {
			String subject = ticketDetail.getSubject();
			userModuleValidator.ticketGenerate(ticketDetail);
			userModule.ticketGenerate(ticketDetail, emailId);

			List<TicketDetail> id = userModule.findById(ticketDetail.getSubject(), ticketDetail.getDescription());
			TicketDetail a = id.get(0);

			MailUtil.sendAdminMail(emailId, "Ticket Created Sucessfully on " + subject + ".Your Ticket id is: ",
					a.getId());

		} catch (ValidationException e) {
			throw new ServiceException(properInputs, e);
		} catch (PersistenceException e) {
			throw new ServiceException("Try a diff email id", e);
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public void closeTicket(Integer ticketId) throws ServiceException {
		try {

			userModule.closeTicket(ticketId);
		} catch (PersistenceException e) {
			throw new ServiceException("Try a diff email id or ticket id", e);
		}
	}

	public void updateTicket(TicketDetail ticketDetail) throws ServiceException {
		try {

			userModuleValidator.updateTicket(ticketDetail);
			userModule.updateTicket(ticketDetail);
		} catch (PersistenceException e) {
			throw new ServiceException("Try a diff email id or ticket id", e);
		} catch (ValidationException e) {
			throw new ServiceException("Please enter proper inputs");
		}
	}

}

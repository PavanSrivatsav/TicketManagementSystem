package com.pavansrivatsav.service;

import java.util.List;

import org.apache.commons.mail.EmailException;

import com.pavansrivatsav.dao.EmployeeDetailDAO;
import com.pavansrivatsav.dao.TicketDetailDAO;
import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.MailUtil;
import com.pavansrivatsav.validator.TicketDetailValidator;

public class TicketDetailService {
	private TicketDetailValidator ticketDetailValidator = new TicketDetailValidator();
	private TicketDetailDAO ticketDetaildao = new TicketDetailDAO();
	private EmployeeDetailDAO empdetail = new EmployeeDetailDAO();

	public void insert(TicketDetail ticketDetail) throws ServiceException {

		try {
			ticketDetailValidator.validateInsert(ticketDetail);
			ticketDetaildao.insert(ticketDetail);
			String emailId = empdetail.getEmailId(1);
			String subject = ticketDetail.getSubject();
			Integer TicketId = ticketDetail.getId();
			MailUtil.sendAdminMail(emailId, "Ticket Created Sucessfully on " + subject + ".Your Ticket id is:",
					TicketId);
		} catch (ValidationException e) {
			throw new ServiceException("Could not insert items", e);
		} catch (EmailException e) {
			throw new ServiceException("Could not send mail", e);
		} catch (PersistenceException e) {
			throw new ServiceException("Could not get email id", e);
		}

	}

	public void update(TicketDetail ticketDetail) throws ServiceException {

		try {
			ticketDetailValidator.validateUpdate(ticketDetail);

			ticketDetaildao.update(ticketDetail);
		} catch (ValidationException e) {
			throw new ServiceException("Could not update items", e);
		}

	}

	public void delete(TicketDetail ticketDetail) throws ServiceException {

		try {
			ticketDetailValidator.validateDelete(ticketDetail);

			ticketDetaildao.delete(ticketDetail);
		} catch (ValidationException e) {
			throw new ServiceException("Could not delete items", e);
		} catch (PersistenceException e) {
			throw new ServiceException("Could not delete items", e);
		}

	}

	public void findAll() {
		ticketDetaildao.find();
	}

	public List<TicketDetail> findById(Integer id) {
		return ticketDetaildao.findById(id);
	}

}

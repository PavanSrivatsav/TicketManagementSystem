package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.TicketDetailDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.validator.TicketDetailValidator;

public class TicketDetailService {
	private TicketDetailValidator ticketDetailValidator = new TicketDetailValidator();
	private TicketDetailDAO ticketDetaildao = new TicketDetailDAO();

	public void insert(TicketDetail ticketDetail) throws ServiceException {

		try {
			ticketDetailValidator.validateInsert(ticketDetail);

			ticketDetaildao.insert(ticketDetail);
		} catch (ValidationException e) {
			throw new ServiceException("Could not insert items", e);
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
		}

	}

	public void findAll() {
		ticketDetaildao.find();
	}

}

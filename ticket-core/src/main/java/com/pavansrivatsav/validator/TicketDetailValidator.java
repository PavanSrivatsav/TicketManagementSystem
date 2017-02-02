package com.pavansrivatsav.validator;

import java.time.LocalDateTime;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.ValidationUtil;

public class TicketDetailValidator {

	public void ticketValidation(TicketDetail ticketDetail) throws ValidationException {

		ValidationUtil.isInvalidObject(ticketDetail, "Invalid Operation");
	}

	public void idvalidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void userIdValidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid department id");
	}

	public void deptValidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid department id");
	}

	public void subjectValidation(String name) throws ValidationException {

		ValidationUtil.isInvalidString(name, "Invalid subject");
	}

	public void descriptionValidation(String name) throws ValidationException {

		ValidationUtil.isInvalidString(name, "Invalid description");
	}

	public void employeeAssignedValidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid employee assigned");
	}

	public void createdTime(LocalDateTime time) throws ValidationException {
		ValidationUtil.isValidDateTime(time, "Invalid Time Stamp");
	}

	public void modifiedTime(LocalDateTime time) throws ValidationException {
		ValidationUtil.isValidDateTime(time, "Invalid Time Stamp");
	}

	public void statusValidation(String name) throws ValidationException {

		ValidationUtil.isInvalidString(name, "Invalid status");
	}

	public void validateInsert(TicketDetail ticketDetail) throws ValidationException {

		ticketValidation(ticketDetail);
		idvalidation(ticketDetail.getId());
		userIdValidation(ticketDetail.getUser().getId());
		deptValidation(ticketDetail.getTicketDept().getId());
		subjectValidation(ticketDetail.getSubject());
		descriptionValidation(ticketDetail.getDescription());
		employeeAssignedValidation(ticketDetail.getEmp().getId());
		createdTime(ticketDetail.getCreated());
		statusValidation(ticketDetail.getStatus());
		modifiedTime(ticketDetail.getModified());

	}

	public void validateUpdate(TicketDetail ticketDetail) throws ValidationException {

		ticketValidation(ticketDetail);
		idvalidation(ticketDetail.getId());
		statusValidation(ticketDetail.getStatus());
	}

	public void validateDelete(TicketDetail ticketDetail) throws ValidationException {
		ticketValidation(ticketDetail);
		idvalidation(ticketDetail.getId());
	}
}

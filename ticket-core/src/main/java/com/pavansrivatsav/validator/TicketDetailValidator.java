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

	public void deptValidation(Integer deptId) throws ValidationException {

		ValidationUtil.isInvalidNumber(deptId, "Invalid department id");
	}

	public void subjectValidation(String subject) throws ValidationException {

		ValidationUtil.isInvalidString(subject, "Invalid subject");
	}

	public void descriptionValidation(String description) throws ValidationException {

		ValidationUtil.isInvalidString(description, "Invalid description");
	}

	public void employeeAssignedValidation(Integer employeeId) throws ValidationException {

		ValidationUtil.isInvalidNumber(employeeId, "Invalid employee assigned");
	}

	public void createdTime(LocalDateTime createdTime) throws ValidationException {
		ValidationUtil.isValidDateTime(createdTime, "Invalid Time Stamp");
	}

	public void modifiedTime(LocalDateTime modifiedTime) throws ValidationException {
		ValidationUtil.isValidDateTime(modifiedTime, "Invalid Time Stamp");
	}

	public void statusValidation(String status) throws ValidationException {

		ValidationUtil.isInvalidString(status, "Invalid status");
	}

	public void priorityValidation(String priority) throws ValidationException {
		ValidationUtil.isInvalidString(priority, "Invalid priority");
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
		priorityValidation(ticketDetail.getPriority());
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

package com.pavansrivatsav.validator;

import com.pavansrivatsav.dao.UserModule;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.ValidationUtil;

public class UserModuleValidator {

	public void userModuleValidation(UserModule userModule) throws ValidationException {

		ValidationUtil.isInvalidObject(userModule, "Invalid opertion");
	}

	public void ticketValidation(TicketDetail ticketDetail) throws ValidationException {
		ValidationUtil.isInvalidObject(ticketDetail, "Invalid operation");
	}

	public void idValidatorr(Integer id) throws ValidationException {
		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void userIdValidator(Integer userId) throws ValidationException {

		ValidationUtil.isInvalidNumber(userId, "Invalid user id");
	}

	public void deptIdValidator(Integer deptId) throws ValidationException {

		ValidationUtil.isInvalidNumber(deptId, "Invalid department id");
	}

	public void subjectValidation(String subject) throws ValidationException {

		ValidationUtil.isInvalidString(subject, "Invalid subject");
	}

	public void descriptionValidation(String description) throws ValidationException {

		ValidationUtil.isInvalidString(description, "Invalid description");
	}

	public void statusValidator(String status) throws ValidationException {

		ValidationUtil.isInvalidString(status, "Invalid status");
	}

	public void ticketIdValidator(Integer ticketId) throws ValidationException {

		ValidationUtil.isInvalidNumber(ticketId, "Invalid ticket id");
	}

	public void passwordValidation(String password) throws ValidationException {

		ValidationUtil.isInvalidPassword(password, "Invalid password");
	}

	public void emailValidation(String email) throws ValidationException {

		ValidationUtil.isInvalidEmail(email, "Invalid emailId");
	}

	public void priorityValidation(String priority) throws ValidationException {
		ValidationUtil.isInvalidString(priority, "Invalid priority");
	}

	public void ticketGenerate(TicketDetail ticketDetail) throws ValidationException {

		userIdValidator(ticketDetail.getUser().getId());
		deptIdValidator(ticketDetail.getTicketDept().getId());
		subjectValidation(ticketDetail.getSubject());
		descriptionValidation(ticketDetail.getDescription());
		priorityValidation(ticketDetail.getPriority());
	}

	public void closeTicket(String email, String pass, Integer ticketId) throws ValidationException {
		emailValidation(email);
		passwordValidation(pass);
		ticketIdValidator(ticketId);

	}

	public void updateTicket(TicketDetail ticketDetail) throws ValidationException {

		ticketIdValidator(ticketDetail.getId());
		statusValidator(ticketDetail.getStatus());
		subjectValidation(ticketDetail.getSubject());
		descriptionValidation(ticketDetail.getDescription());
	}
}

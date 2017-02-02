package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.util.ValidationUtil;

public class UserDetailValidator {

	public void userValidation(UserDetail usrDetail) throws ValidationException {

		ValidationUtil.isInvalidObject(usrDetail, "Invalid Operation");
	}

	public void idvalidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void nameValidation(String name) throws ValidationException {

		ValidationUtil.isInvalidString(name, "Invalid name");
	}

	public void passwordValidation(String password) throws ValidationException {

		ValidationUtil.isValidPassword(password, "Invalid password");
	}

	public void emailValidation(String email) throws ValidationException {

		ValidationUtil.isValidEmail(email, "Invalid emailId");
	}

	public void statusValidation(Boolean status) throws ValidationException {
		ValidationUtil.isValidBoolean(status, "Invalid status");
	}

	public void validateInsert(UserDetail usrDetail) throws ValidationException {

		userValidation(usrDetail);
		idvalidation(usrDetail.getId());
		nameValidation(usrDetail.getName());
		emailValidation(usrDetail.getEmailId());
		passwordValidation(usrDetail.getPassword());
		statusValidation(usrDetail.getStatus());

	}

	public void validateUpdate(UserDetail usrDetail) throws ValidationException {

		userValidation(usrDetail);
		passwordValidation(usrDetail.getPassword());
		emailValidation(usrDetail.getEmailId());
	}

	public void validateDelete(UserDetail usrDetail) throws ValidationException {
		userValidation(usrDetail);
		idvalidation(usrDetail.getId());
	}
}

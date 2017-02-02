package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.util.ValidationUtil;

public class EmployeeDetailValidation {

	public void employeeValidation(EmployeeDetail empDetail) throws ValidationException {

		ValidationUtil.isInvalidObject(empDetail, "Invalid Operation");
	}

	public void idvalidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void deptIdValidation(Integer deptId) throws ValidationException {

		ValidationUtil.isInvalidNumber(deptId, "Invalid department id");
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

	public void validateInsert(EmployeeDetail empDetail) throws ValidationException {

		employeeValidation(empDetail);
		idvalidation(empDetail.getId());
		deptIdValidation(empDetail.getDept().getId());
		nameValidation(empDetail.getName());
		emailValidation(empDetail.getEmailId());
		passwordValidation(empDetail.getPassword());
		statusValidation(empDetail.getStatus());

	}

	public void validateUpdate(EmployeeDetail empDetail) throws ValidationException {

		employeeValidation(empDetail);
		passwordValidation(empDetail.getPassword());
		emailValidation(empDetail.getEmailId());
	}

	public void validateDelete(EmployeeDetail empDetail) throws ValidationException {
		employeeValidation(empDetail);
		idvalidation(empDetail.getId());
	}
}

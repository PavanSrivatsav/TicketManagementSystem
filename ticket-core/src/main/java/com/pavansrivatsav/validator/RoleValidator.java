package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.Role;
import com.pavansrivatsav.util.ValidationUtil;

public class RoleValidator {

	public void roleValidation(Role role) throws ValidationException {

		ValidationUtil.isInvalidObject(role, "Invalid Operation");
	}

	public void idvalidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void nameValidation(String name) throws ValidationException {

		ValidationUtil.isInvalidString(name, "Invalid name");
	}

	public void statusValidation(Boolean status) throws ValidationException {
		ValidationUtil.isInvalidBoolean(status, "Invalid status");
	}

	public void validateInsert(Role role) throws ValidationException {

		roleValidation(role);
		nameValidation(role.getRoleName());
	}

	public void validateUpdate(Role role) throws ValidationException {

		roleValidation(role);
		idvalidation(role.getId());
		nameValidation(role.getRoleName());
	}

	public void validateDelete(Role role) throws ValidationException {
		roleValidation(role);
		idvalidation(role.getId());
	}
}

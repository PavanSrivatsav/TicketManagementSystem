package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.util.ValidationUtil;

public class DepartmentValidation {

	public void deptValidation(Department dept) throws ValidationException {

		ValidationUtil.isInvalidObject(dept, "Invalid Operation");
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

	public void validateInsert(Department dept) throws ValidationException {

		deptValidation(dept);
		nameValidation(dept.getName());
		statusValidation(dept.getStatus());

	}

	public void validateUpdate(Department dept) throws ValidationException {

		deptValidation(dept);
		idvalidation(dept.getId());
		nameValidation(dept.getName());
		statusValidation(dept.getStatus());
	}

	public void validateDelete(Department dept) throws ValidationException {
		deptValidation(dept);
		idvalidation(dept.getId());
	}
}

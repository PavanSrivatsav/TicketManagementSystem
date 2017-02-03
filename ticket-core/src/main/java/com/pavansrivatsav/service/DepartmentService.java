package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.DepartmentDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.validator.DepartmentValidation;

public class DepartmentService {
	private DepartmentValidation departmentValidator = new DepartmentValidation();
	private DepartmentDAO deptDao = new DepartmentDAO();

	public void insert(Department dept) throws ServiceException {

		try {
			departmentValidator.validateInsert(dept);

			deptDao.insert(dept);
		} catch (ValidationException e) {
			throw new ServiceException("Could not insert items", e);
		}

	}

	public void update(Department dept) throws ServiceException {

		try {
			departmentValidator.validateUpdate(dept);

			deptDao.update(dept);
		} catch (ValidationException e) {
			throw new ServiceException("Could not update items", e);
		}

	}

	public void delete(Department dept) throws ServiceException {

		try {
			departmentValidator.validateDelete(dept);

			deptDao.delete(dept);
		} catch (ValidationException e) {
			throw new ServiceException("Could not delete items", e);
		}

	}

	public void findAll() {
		deptDao.find();
	}
}

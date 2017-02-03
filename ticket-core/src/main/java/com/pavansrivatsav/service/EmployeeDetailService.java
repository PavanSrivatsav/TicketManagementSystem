package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.EmployeeDetailDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.validator.EmployeeDetailValidation;

public class EmployeeDetailService {

	private EmployeeDetailValidation employeeDetailValidator = new EmployeeDetailValidation();
	private EmployeeDetailDAO empDao = new EmployeeDetailDAO();

	public void insert(EmployeeDetail employeeDetail) throws ServiceException {

		try {
			employeeDetailValidator.validateInsert(employeeDetail);

			empDao.insert(employeeDetail);
		} catch (ValidationException e) {
			throw new ServiceException("Could not insert items", e);
		}

	}

	public void update(EmployeeDetail employeeDetail) throws ServiceException {

		try {
			employeeDetailValidator.validateUpdate(employeeDetail);

			empDao.update(employeeDetail);
		} catch (ValidationException e) {
			throw new ServiceException("Could not update items", e);
		}

	}

	public void delete(EmployeeDetail employeeDetail) throws ServiceException {

		try {
			employeeDetailValidator.validateDelete(employeeDetail);

			empDao.delete(employeeDetail);
		} catch (ValidationException e) {
			throw new ServiceException("Could not delete items", e);
		}

	}

	public void findAll() {

		empDao.find();
	}
}

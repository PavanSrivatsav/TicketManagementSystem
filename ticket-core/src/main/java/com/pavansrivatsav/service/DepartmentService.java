package com.pavansrivatsav.service;

import java.util.List;

import com.pavansrivatsav.dao.DepartmentDAO;
import com.pavansrivatsav.exception.PersistenceException;
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

		} catch (PersistenceException e) {
			throw new ServiceException("Duplicate entry");
		} catch (ValidationException e) {
			throw new ServiceException("Could not insert items");
		}

	}

	public void update(Department dept) throws ServiceException {

		try {
			departmentValidator.validateUpdate(dept);

			deptDao.update(dept);
		} catch (PersistenceException e) {
			throw new ServiceException("Duplicate entry");
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
		} catch (PersistenceException e) {
			throw new ServiceException("cannot delete prim key", e);
		}

	}

	public List<Department> findAll() {
		return deptDao.findAll();
	}
}

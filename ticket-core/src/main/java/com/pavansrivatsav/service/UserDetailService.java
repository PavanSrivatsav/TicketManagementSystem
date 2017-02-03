package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.UserDetailDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.validator.UserDetailValidator;

public class UserDetailService {

	private UserDetailValidator userDetailValidator = new UserDetailValidator();
	private UserDetailDAO idao = new UserDetailDAO();

	public void insert(UserDetail userDetail) throws ServiceException {

		try {
			userDetailValidator.validateInsert(userDetail);

			idao.insert(userDetail);
		} catch (ValidationException e) {
			throw new ServiceException("Could not insert items", e);
		}

	}

	public void update(UserDetail userDetail) throws ServiceException {

		try {
			userDetailValidator.validateUpdate(userDetail);

			idao.update(userDetail);
		} catch (ValidationException e) {
			throw new ServiceException("Could not update items", e);
		}

	}

	public void delete(UserDetail userDetail) throws ServiceException {

		try {
			userDetailValidator.validateDelete(userDetail);

			idao.delete(userDetail);
		} catch (ValidationException e) {
			throw new ServiceException("Could not delete items", e);
		}

	}

	public void findAll() {

		idao.find();
	}

}

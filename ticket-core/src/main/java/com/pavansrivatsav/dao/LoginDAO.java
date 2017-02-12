package com.pavansrivatsav.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.util.ConnectionUtil;

public class LoginDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public Boolean userLogIn(String emailId, String password) throws PersistenceException {
		UserDetailDAO userdetailDAO = new UserDetailDAO();

		String user = userdetailDAO.getPassword(emailId);
		if (user.equals(password)) {
			return true;
		} else {
			throw new PersistenceException("Invalid Password");
		}
	}

	public Boolean employeeLogIn(String emailId, String password) throws PersistenceException {
		EmployeeDetailDAO employeedetailDAO = new EmployeeDetailDAO();

		String emp = employeedetailDAO.getPassword(emailId);
		if (emp.equals(password)) {
			return true;
		} else {
			throw new PersistenceException("Invalid Password");
		}

	}

	public Boolean adminLogIn(String emailId, String password) throws PersistenceException {
		EmployeeDetailDAO employeedetailDAO = new EmployeeDetailDAO();

		String admin = employeedetailDAO.getAdminPassword(emailId);
		if (admin.equals(password)) {
			return true;
		} else {
			throw new PersistenceException("Invalid Password");
		}

	}
}

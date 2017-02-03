package com.pavansrivatsav.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class LoginDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public Boolean userLogIn(String emailId, String password) {
		UserDetailDAO userdetailDAO = new UserDetailDAO();

		UserDetail user = userdetailDAO.getPassword(emailId);
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public Boolean employeeLogIn(String emailId, String password) {
		EmployeeDetailDAO employeedetailDAO = new EmployeeDetailDAO();

		EmployeeDetail emp = employeedetailDAO.getPassword(emailId);
		if (emp.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
}

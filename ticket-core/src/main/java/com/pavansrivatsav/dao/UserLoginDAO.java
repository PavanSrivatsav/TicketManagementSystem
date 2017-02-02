package com.pavansrivatsav.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class UserLoginDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public Boolean logIn(String emailId, String password) {
		UserDetailDAO userdetailDAO = new UserDetailDAO();

		UserDetail user = userdetailDAO.getPassword(emailId);
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
}

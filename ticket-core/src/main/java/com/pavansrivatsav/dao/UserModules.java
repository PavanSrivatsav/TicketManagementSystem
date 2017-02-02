package com.pavansrivatsav.dao;

import org.springframework.jdbc.core.JdbcTemplate;

//import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class UserModules {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String closeTicket(String emailId, String password, Integer ticketId) {
		final UserLoginDAO loginDao = new UserLoginDAO();
		// final TicketDetail ticketDetail = new TicketDetail();
		if (loginDao.logIn(emailId, password)) {
			final String sql = "update ticket_details set STATUS=? where ID=? ";
			final Object[] params = { "CLOSED", ticketId };
			jdbcTemplate.update(sql, params);
			return "Ticket Closed";
		}
		return "Enter proper username and password";
	}

	public String updateTicket(String emailId, String password, Integer ticketId, String ticketStatus) {
		final UserLoginDAO loginDao = new UserLoginDAO();
		if (loginDao.logIn(emailId, password)) {
			final String sql = "update ticket_details set STATUS=? where ID=?";
			final Object[] params = { ticketStatus, ticketId };
			jdbcTemplate.update(sql, params);
			return "Ticket status updated";
		}
		return "Enter proper username and password";
	}

	// public String displayTicket(String emailId, String password) {
	// final UserLoginDAO loginDao = new UserLoginDAO();
	// if (loginDao.logIn(emailId, password)) {
	// final String sql = "select SUBJECT,DESCRIPTION,STATUS from ticket_details
	// where USER_ID=?";
	// final String sqlUserId = "SELECT ID FROM user_details WHERE EMAILID=?";
	// final Object[] params = { sqlUserId };
	// return jdbcTemplate.queryForObject(sql, params, (rs, rownum) ->
	//
	// );
	// }
	// return "Enter proper username and password";
	// }

}

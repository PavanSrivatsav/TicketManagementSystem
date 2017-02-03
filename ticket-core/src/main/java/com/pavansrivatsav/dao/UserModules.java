package com.pavansrivatsav.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class UserModules {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * Ticket generation
	 * 
	 * @param ticketDetail
	 * @return
	 */
	public String ticketGenerate(TicketDetail ticketDetail) {
		final String sql = "insert into ticket_details(USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION)values(?,?,?,?)";
		final Object[] params = { ticketDetail.getUser().getId(), ticketDetail.getTicketDept().getId(),
				ticketDetail.getSubject(), ticketDetail.getDescription() };
		jdbcTemplate.update(sql, params);
		return "Ticket generated successfully";
	}

	/**
	 * Close Ticket
	 * 
	 * @param emailId
	 * @param password
	 * @param ticketId
	 * @return
	 */
	public String closeTicket(String emailId, String password, Integer ticketId) {
		final UserDetailDAO userDetaildao = new UserDetailDAO();
		final UserLoginDAO loginDao = new UserLoginDAO();
		if (loginDao.logIn(emailId, password)) {
			final String sql = "update ticket_details set STATUS=? where ID=? AND USER_ID=? ";
			final Object[] params = { "CLOSED", ticketId, userDetaildao.getUserId(emailId).getId() };
			jdbcTemplate.update(sql, params);
			return "Ticket Closed";
		}
		return "Enter proper username and password";
	}

	/**
	 * Update Ticket
	 * 
	 * @param emailId
	 * @param password
	 * @param ticketId
	 * @param ticketStatus
	 * @return
	 */
	public String updateTicket(String emailId, String password, Integer ticketId, String ticketStatus) {
		final UserDetailDAO userDetaildao = new UserDetailDAO();
		final UserLoginDAO loginDao = new UserLoginDAO();
		if (loginDao.logIn(emailId, password)) {
			final String sql = "update ticket_details set STATUS=? where ID=? AND USER_ID=?";
			final Object[] params = { ticketStatus, ticketId, userDetaildao.getUserId(emailId).getId() };
			jdbcTemplate.update(sql, params);
			return "Ticket status updated";
		}
		return "Enter proper username and password";
	}

	/**
	 * Display Ticket
	 * 
	 * @param emailId
	 * @param password
	 * @return
	 */
	public List<TicketDetail> displayTicket(String emailId, String password) {
		final UserLoginDAO loginDao = new UserLoginDAO();
		final UserDetailDAO userDetaildao = new UserDetailDAO();
		if (loginDao.logIn(emailId, password)) {
			final String sql = "select SUBJECT,DESCRIPTION,STATUS from ticket_details where USER_ID=?";
			final Object[] params = { userDetaildao.getUserId(emailId).getId() };
			return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
				final TicketDetail ticketDetail = new TicketDetail();
				ticketDetail.setSubject(rs.getString("SUBJECT"));
				ticketDetail.setDescription(rs.getString("DESCRIPTION"));
				ticketDetail.setStatus(rs.getString("STATUS"));
				return ticketDetail;
			});
		}
		return Collections.emptyList();
	}
}

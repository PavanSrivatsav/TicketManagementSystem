package com.pavansrivatsav.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class UserModule {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	private TicketDetail ticketDetail = new TicketDetail();
	private TicketDetailDAO ticketDetailDAO = new TicketDetailDAO();

	/**
	 * Ticket generation
	 * 
	 * @param ticketDetail
	 * @return
	 * @throws PersistenceException
	 * @throws DataAccessException
	 */
	public Integer ticketGenerate(TicketDetail ticketDetail, String emailId) throws PersistenceException {

		final String sql = "insert into ticket_details(USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY)values(?,?,?,?,?)";
		final Object[] params = { ticketDetail.getUser().getId(), ticketDetail.getTicketDept().getId(),
				ticketDetail.getSubject(), ticketDetail.getDescription(), ticketDetail.getPriority() };
		return jdbcTemplate.update(sql, params);

	}

	/**
	 * Close Ticket
	 * 
	 * @param emailId
	 * @param password
	 * @param ticketId
	 * @return @throws PersistenceException @throws
	 */
	public String closeTicket(Integer ticketId) throws PersistenceException {

		final String sql = "update ticket_details set STATUS=? where ID=? AND STATUS!=?";
		final Object[] params = { "CLOSED", ticketId, "CLOSED" };
		jdbcTemplate.update(sql, params);
		return "Ticket Closed";
	}

	/**
	 * Update Ticket
	 * 
	 * @param emailId
	 * @param password
	 * @param ticketId
	 * @param ticketStatus
	 * @return @throws PersistenceException @throws
	 */
	public String updateTicket(TicketDetail ticketDetail) throws PersistenceException {

		if ("CLOSED".equals(ticketDetailDAO.getStatus(ticketDetail.getId()).getStatus())) {
			throw new PersistenceException("You cannot update the ticket which is closed");
		} else {
			final String sql = "update ticket_details set STATUS=? , SUBJECT=? , DESCRIPTION = ? where ID=? ";
			final Object[] params = { ticketDetail.getStatus(), ticketDetail.getSubject(),
					ticketDetail.getDescription(), ticketDetail.getId() };
			jdbcTemplate.update(sql, params);
			return "Ticket updated";
		}

	}

	/**
	 * Display Ticket
	 * 
	 * @param emailId
	 * @param password
	 * @return @throws PersistenceException @throws
	 */
	public List<TicketDetail> displayTicket(String emailId, String password) throws PersistenceException {
		final LoginDAO loginDao = new LoginDAO();
		final UserDetailDAO userDetaildao = new UserDetailDAO();
		if (loginDao.userLogIn(emailId, password)) {
			final String sql = "select SUBJECT,DESCRIPTION,STATUS from ticket_details where USER_ID=?";
			final Object[] params = { userDetaildao.getUserId(emailId) };
			return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
				ticketDetail.setSubject(rs.getString("SUBJECT"));
				ticketDetail.setDescription(rs.getString("DESCRIPTION"));
				ticketDetail.setStatus(rs.getString("STATUS"));
				return ticketDetail;
			});
		}
		return Collections.emptyList();
	}

	public List<TicketDetail> findById(String subject, String description) {
		final String sql = "select ID from ticket_details where subject=? and description=? ";
		Object[] params = { subject, description };
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
			final TicketDetail ticketDetail = new TicketDetail();
			ticketDetail.setId(rs.getInt("ID"));
			return ticketDetail;
		});
	}

}
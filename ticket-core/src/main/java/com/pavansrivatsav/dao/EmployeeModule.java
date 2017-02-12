package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class EmployeeModule {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	private TicketDetailDAO ticketdetailDao = new TicketDetailDAO();
	private EmployeeDetailDAO employeeDetailDao = new EmployeeDetailDAO();
	public static final Logger logger = Logger.getLogger(EmployeeModule.class.getName());

	public String assignTicketToEmployee(String emailId, Integer empId, Integer ticketId) throws PersistenceException {

		String sql = "update ticket_details set ASSIGNED_PERSON_ID=?,MODIFIED_TIMESTAMP=now() ,STATUS=? where STATUS=? AND ID=?";
		Object[] params = { empId, "IN PROGRESS", "OPEN", ticketId };
		logger.log(Level.SEVERE, "No of rows inserted %s ", jdbcTemplate.update(sql, params));
		return "Ticket assigned Successfully ";

	}

	public String reAssignTicketToEmployee(Integer empId, Integer ticketId) throws PersistenceException {

		if (ticketdetailDao.getDeptId(ticketId) == employeeDetailDao.getDepartmentIdByEmpId(empId)) {
			String sql = "update ticket_details set ASSIGNED_PERSON_ID=?,MODIFIED_TIMESTAMP=now() ,STATUS=? where STATUS=? AND ID=?";
			Object[] params = { empId, "IN PROGRESS", "OPEN", ticketId };
			logger.log(Level.SEVERE, "No of rows inserted %s ", jdbcTemplate.update(sql, params));
			return "Ticket assigned Successfully ";

		} else {
			logger.log(Level.SEVERE, "else part ");
			return "Assignment Failed ";
		}

	}

	public List<TicketDetail> displayTicket(Integer id) throws PersistenceException {
		try {
			final String sql = "select ID,SUBJECT,DESCRIPTION,STATUS,PRIORITY from ticket_details where ASSIGNED_PERSON_ID=? ";
			final Object[] params = { id };
			return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
				final TicketDetail ticketDetail = new TicketDetail();
				ticketDetail.setId(rs.getInt("ID"));
				ticketDetail.setSubject(rs.getString("SUBJECT"));
				ticketDetail.setDescription(rs.getString("DESCRIPTION"));
				ticketDetail.setStatus(rs.getString("STATUS"));
				ticketDetail.setPriority(rs.getString("PRIORITY"));
				return ticketDetail;
			});

		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No tickets available", e);
		}

	}

	public Integer employeeReply(IssueHistory issueHistory) throws PersistenceException {
		try {
			String sql = "insert into issues_history (TICKET_ID,SOLUTION) values(?,?) ";
			Object[] params = { issueHistory.getTicketId().getId(), issueHistory.getSolution() };
			return jdbcTemplate.update(sql, params);

		} catch (DuplicateKeyException e) {
			throw new PersistenceException("Sorry ticket already available", e);
		}
	}

	public Integer employeeResolve(Integer ticketId) {
		String sql = "update ticket_details set STATUS=? , MODIFIED_TIMESTAMP=now() where ID=?";
		Object[] params = { "RESOLVED", ticketId };
		return jdbcTemplate.update(sql, params);

	}

	public String deleteTicket(TicketDetail ticketDetail) throws PersistenceException {
		try {
			ticketdetailDao.delete(ticketDetail);
			return "Successfully deleted";
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such email id or ticket id found", e);
		}

	}

	public String getemailIdByTicketId(Integer ticketId) throws PersistenceException {
		try {
			String sql = "SELECT EMAILID FROM user_details WHERE ID=(SELECT USER_ID FROM ticket_details WHERE ID=?)";
			Object[] params = { ticketId };
			return jdbcTemplate.queryForObject(sql, params, String.class);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("Invalid ticket Id", e);
		}
	}

}

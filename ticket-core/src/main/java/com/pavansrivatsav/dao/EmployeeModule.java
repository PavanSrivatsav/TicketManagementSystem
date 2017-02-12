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
	private EmployeeDetailDAO empdao = new EmployeeDetailDAO();
	private TicketDetailDAO ticketdetailDao = new TicketDetailDAO();
	private RoleDAO roleDao = new RoleDAO();
	private EmployeeDetailDAO employeeDetailDao = new EmployeeDetailDAO();
	public static final Logger logger = Logger.getLogger(EmployeeModule.class.getName());

	public String assignTicketToEmployee(String emailId, Integer empId, Integer ticketId) throws PersistenceException {
		Integer roleId = employeeDetailDao.getRoleId(emailId);
		Integer deptId = employeeDetailDao.getDepartmentId(emailId);
		if ((ticketdetailDao.getDeptId(ticketId) == employeeDetailDao.getDepartmentIdByEmpId(empId))
				&& (deptId == ticketdetailDao.getDeptId(ticketId)) && (roleId == roleDao.getRoleId("Admin"))) {
			String sql = "update ticket_details set ASSIGNED_PERSON_ID=?,MODIFIED_TIMESTAMP=now() ,STATUS=? where STATUS=? AND ID=?";
			Object[] params = { empId, "IN PROGRESS", "OPEN", ticketId };
			logger.log(Level.SEVERE, "No of rows inserted %s ", jdbcTemplate.update(sql, params));
			return "Ticket assigned Successfully ";

		} else {
			logger.log(Level.SEVERE, "else part ");
			return "Assignment Failed ";
		}

	}

	public String reAssignTicketToEmployee(Integer empId, Integer ticketId) throws PersistenceException {

		if ((ticketdetailDao.getDeptId(ticketId) == employeeDetailDao.getDepartmentIdByEmpId(empId))) {
			String sql = "update ticket_details set ASSIGNED_PERSON_ID=?,MODIFIED_TIMESTAMP=now() ,STATUS=? where STATUS=? AND ID=?";
			Object[] params = { empId, "IN PROGRESS", "OPEN", ticketId };
			logger.log(Level.SEVERE, "No of rows inserted %s ", jdbcTemplate.update(sql, params));
			return "Ticket assigned Successfully ";

		} else {
			logger.log(Level.SEVERE, "else part ");
			return "Assignment Failed ";
		}

	}

	public List<TicketDetail> displayTicket(String emailId) throws PersistenceException {
		final EmployeeDetailDAO empDetaildao = new EmployeeDetailDAO();
		try {
			final String sql = "select ID,SUBJECT,DESCRIPTION,STATUS,PRIORITY from ticket_details where ASSIGNED_PERSON_ID=? ";
			final Object[] params = { empDetaildao.getEmpId(emailId) };
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
			throw new PersistenceException("No tickets available");
		}

	}

	public Integer employeeReply(IssueHistory issueHistory) throws PersistenceException {
		try {
			String sql = "insert into issues_history (TICKET_ID,SOLUTION) values(?,?) ";
			Object[] params = { issueHistory.getTicketId().getId(), issueHistory.getSolution() };
			return jdbcTemplate.update(sql, params);

		} catch (DuplicateKeyException e) {
			throw new PersistenceException("Sorry ticket already available");
		}
	}

	public Integer employeeResolve(Integer ticketId) {
		String sql = "update ticket_details set STATUS=? , MODIFIED_TIMESTAMP=now() where ID=?";
		Object[] params = { "RESOLVED", ticketId };
		return jdbcTemplate.update(sql, params);

	}

	public String deleteTicket(TicketDetail ticketDetail) throws PersistenceException {
		try {
			// Integer roleId = empdao.getRoleId(emailId);
			// Integer deptId = empdao.getDepartmentId(emailId);
			// if ((deptId == ticketdetailDao.getDeptId(ticketId)) && (roleId ==
			// roleDao.getRoleId("ADMIN"))) {

			ticketdetailDao.delete(ticketDetail);
			return "Successfully deleted";
			// } else {
			// return "You dont have such privileges ";
			// }
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such email id or ticket id found");
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

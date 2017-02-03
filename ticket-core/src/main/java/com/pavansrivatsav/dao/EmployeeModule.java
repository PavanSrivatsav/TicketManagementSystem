package com.pavansrivatsav.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class EmployeeModule {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int assignTicketToEmployee(TicketDetail ticketDetail) {

		String sql = "update ticket_details set ASSIGNED_PERSON_ID=?,MODIFIED_TIMESTAMP=now() ,STATUS=? where STATUS=? AND ID=?";
		Object[] params = { ticketDetail.getEmp().getId(), "IN PROGRESS", "OPEN", ticketDetail.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public List<TicketDetail> displayTicket(String emailId, String password) {
		final LoginDAO loginDao = new LoginDAO();
		final EmployeeDetailDAO empDetaildao = new EmployeeDetailDAO();
		if (loginDao.employeeLogIn(emailId, password)) {
			final String sql = "select SUBJECT,DESCRIPTION,STATUS from ticket_details where ASSIGNED_PERSON_ID=? ";
			final Object[] params = { empDetaildao.getUserId(emailId).getId() };
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

	public int employeeReply(IssueHistory issueHistory) {

		String sql = "update issues_history set SOLUTION=? where TICKET_ID=?";
		Object[] params = { issueHistory.getSolution(), issueHistory.getTicketId().getId() };
		return jdbcTemplate.update(sql, params);
	}

	public int employeeResolve(Integer ticketId) {
		String sql = "update ticket_details set STATUS=? , MODIFIED_TIMESTAMP=now() where ID=?";
		Object[] params = { "RESOLVED", ticketId };
		return jdbcTemplate.update(sql, params);

	}

	public int employeeReassign(Integer employeeId, Integer ticketId) {
		String sql = "update ticket_details set ASSIGNED_PERSON_ID=? where ID=?";
		Object[] params = { employeeId, ticketId };
		return jdbcTemplate.update(sql, params);

	}
}

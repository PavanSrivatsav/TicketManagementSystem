package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class TicketDetailDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public Integer insert(final TicketDetail ticketDetail) {
		final String sql = "insert into ticket_details (USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY,ASSIGNED_PERSON_ID,CREATED_TIMESTAMP,STATUS,MODIFIED_TIMESTAMP) values(?,?,?,?,?,?,?,?,?)";
		final Object[] params = { ticketDetail.getUser().getId(), ticketDetail.getTicketDept().getId(),
				ticketDetail.getSubject(), ticketDetail.getDescription(), ticketDetail.getPriority(),
				ticketDetail.getEmp().getId(), ticketDetail.getCreated(), ticketDetail.getStatus(),
				ticketDetail.getModified() };
		return jdbcTemplate.update(sql, params);

	}

	public Integer update(final TicketDetail ticketDetail) {

		final String sql = "update ticket_details set STATUS=? WHERE ID=? ";
		final Object[] params = { ticketDetail.getStatus(), ticketDetail.getId() };
		return jdbcTemplate.update(sql, params);

	}

	// public Integer delete(final Integer id) throws PersistenceException {
	// try {
	// final String sql = "delete from ticket_details where ID=?";
	// final Object[] params = { id };
	// return jdbcTemplate.update(sql, params);
	// } catch (DataIntegrityViolationException e) {
	// throw new PersistenceException("Cannot delete ", e);
	// }
	// }

	public Integer delete(final TicketDetail ticketDetail) throws PersistenceException {
		try {
			final String sql = "delete from ticket_details where ID=?";
			final Object[] params = { ticketDetail.getId() };
			return jdbcTemplate.update(sql, params);
		} catch (DataIntegrityViolationException e) {
			throw new PersistenceException("Cannot delete ", e);
		}
	}

	public List<TicketDetail> find() {

		final String sql = "select ID,USER_ID,DEPARTMENT_ID,PRIORITY,SUBJECT,DESCRIPTION,CREATED_TIMESTAMP,STATUS from ticket_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	private TicketDetail convert(ResultSet rs) throws SQLException {
		final TicketDetail ticketDetail = new TicketDetail();
		final Department dept = new Department();
		final UserDetail user = new UserDetail();
		ticketDetail.setId(rs.getInt("ID"));

		user.setId(rs.getInt("USER_ID"));
		ticketDetail.setUser(user);

		dept.setId(rs.getInt("DEPARTMENT_ID"));
		ticketDetail.setTicketDept(dept);

		ticketDetail.setSubject(rs.getString("SUBJECT"));
		ticketDetail.setDescription(rs.getString("DESCRIPTION"));
		ticketDetail.setPriority(rs.getString("PRIORITY"));
		ticketDetail.setCreated((rs.getTimestamp("CREATED_TIMESTAMP")).toLocalDateTime());
		ticketDetail.setStatus(rs.getString("STATUS"));
		return ticketDetail;

	}

	public List<TicketDetail> findById(Integer userId) {
		final String sql = "select ID,SUBJECT,DESCRIPTION,PRIORITY,CREATED_TIMESTAMP,STATUS from ticket_details where USER_ID=?";
		Object[] params = { userId };
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
			final TicketDetail ticketDetail = new TicketDetail();
			ticketDetail.setId(rs.getInt("ID"));
			ticketDetail.setSubject(rs.getString("SUBJECT"));
			ticketDetail.setDescription(rs.getString("DESCRIPTION"));
			ticketDetail.setPriority(rs.getString("PRIORITY"));
			ticketDetail.setCreated((rs.getTimestamp("CREATED_TIMESTAMP")).toLocalDateTime());
			ticketDetail.setStatus(rs.getString("STATUS"));
			return ticketDetail;
		});
	}

	/* Functionalities */

	public Integer getDeptId(int id) {
		final String sql = "select department_id from ticket_details where id=?";
		final Object[] params = { id };

		return jdbcTemplate.queryForObject(sql, params, Integer.class);

	}

	public TicketDetail getStatus(int ticketId) {
		final String sql = "select status from ticket_details where id=?";
		final Object[] params = { ticketId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			TicketDetail ticketDetail = new TicketDetail();
			ticketDetail.setStatus(rs.getString("status"));
			return ticketDetail;
		});

	}

}

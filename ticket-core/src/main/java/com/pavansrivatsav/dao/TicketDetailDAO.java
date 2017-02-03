package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class TicketDetailDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int insert(final TicketDetail ticketDetail) {
		final String sql = "insert into ticket_details (ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY,ASSIGNED_PERSON_ID,CREATED_TIMESTAMP,STATUS,MODIFIED_TIMESTAMP) values(?,?,?,?,?,?,?,?,?)";
		final Object[] params = { ticketDetail.getId(), ticketDetail.getUser().getId(),
				ticketDetail.getTicketDept().getId(), ticketDetail.getSubject(), ticketDetail.getDescription(),
				ticketDetail.getPriority(), ticketDetail.getEmp().getId(), ticketDetail.getCreated(),
				ticketDetail.getStatus(), ticketDetail.getModified() };
		return jdbcTemplate.update(sql, params);

	}

	public int update(final TicketDetail ticketDetail) {

		final String sql = "update ticket_details set STATUS=? WHERE ID=? ";
		final Object[] params = { ticketDetail.getStatus(), ticketDetail.getId() };
		return jdbcTemplate.update(sql, params);

	}

	public int delete(final TicketDetail ticketDetail) {

		final String sql = "delete from ticket_details where ID=?";
		final Object[] params = { ticketDetail.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public List<TicketDetail> find() {

		final String sql = "select ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,ASSIGNED_PERSON_ID,CREATED_TIMESTAMP,STATUS,MODIFIED_TIMESTAMP from ticket_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	private TicketDetail convert(ResultSet rs) throws SQLException {
		final TicketDetail ticketDetail = new TicketDetail();
		final Department dept = new Department();
		final UserDetail user = new UserDetail();
		final EmployeeDetail emp = new EmployeeDetail();

		ticketDetail.setId(rs.getInt("ID"));

		user.setId(rs.getInt("USER_ID"));
		ticketDetail.setUser(user);

		dept.setId(rs.getInt("DEPARTMENT_ID"));
		ticketDetail.setTicketDept(dept);

		ticketDetail.setSubject(rs.getString("SUBJECT"));
		ticketDetail.setDescription(rs.getString("DESCRIPTION"));
		ticketDetail.setPriority(rs.getString("PRIORITY"));

		emp.setId(rs.getInt("ASSIGNED_PERSON_ID"));
		ticketDetail.setEmp(emp);

		ticketDetail.setCreated((rs.getTimestamp("CREATED_TIMESTAMP")).toLocalDateTime());
		ticketDetail.setStatus(rs.getString("STATUS"));
		ticketDetail.setModified((rs.getTimestamp("MODIFIED_TIMESTAMP")).toLocalDateTime());

		return ticketDetail;

	}

	public TicketDetail findOne(Integer id) {

		final String sql = "select ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY,ASSIGNED_PERSON_ID,CREATED_TIMESTAMP,STATUS,MODIFIED_TIMESTAMP from ticket_details where ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));

	}

	/* Functionalities */

}

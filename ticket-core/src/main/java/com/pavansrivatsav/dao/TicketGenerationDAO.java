package com.pavansrivatsav.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class TicketGenerationDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String ticketGenerate(TicketDetail ticketDetail) {
		final String sql = "insert into ticket_details(USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION)values(?,?,?,?)";
		final Object[] params = { ticketDetail.getUser().getId(), ticketDetail.getTicketDept().getId(),
				ticketDetail.getSubject(), ticketDetail.getDescription() };
		jdbcTemplate.update(sql, params);
		return "Ticket generated successfully";
	}
}

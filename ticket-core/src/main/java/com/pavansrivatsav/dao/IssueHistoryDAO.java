package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class IssueHistoryDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int insert(final IssueHistory issueHistory) {
		final String sql = "insert into issues_history (TICKET_ID,SOLUTION) values(?,?)";
		final Object[] params = { issueHistory.getTicketId().getId(), issueHistory.getSolution() };
		return jdbcTemplate.update(sql, params);

	}

	public Integer update(final IssueHistory issueHistory) {

		final String sql = "update issues_history set SOLUTION=? WHERE TICKET_ID=? ";
		final Object[] params = { issueHistory.getSolution(), issueHistory.getTicketId().getId() };
		return jdbcTemplate.update(sql, params);

	}

	public Integer delete(final IssueHistory issueHistory) {

		final String sql = "delete from issues_history where ID=?";
		final Object[] params = { issueHistory.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public List<IssueHistory> find() {

		final String sql = "select ID,TICKET_ID,SOLUTION from issues_history";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	private IssueHistory convert(ResultSet rs) throws SQLException {
		final TicketDetail ticketDetail = new TicketDetail();
		final IssueHistory empHistory = new IssueHistory();
		empHistory.setId(rs.getInt("ID"));

		ticketDetail.setId(rs.getInt("TICKET_ID"));
		empHistory.setTicketId(ticketDetail);

		empHistory.setSolution(rs.getString("SOLUTION"));

		return empHistory;
	}

	public IssueHistory findOne(Integer id) {

		final String sql = "select ID,TICKET_ID,SOLUTION from issues_history where ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));

	}

}

package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.util.ConnectionUtil;

public class DepartmentDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int insert(final Department dept) {
		final String sql = "insert into department (ID,NAME,ACTIVE) values(?,?,?)";
		final Object[] params = { dept.getId(), dept.getName(), dept.getStatus() };
		return jdbcTemplate.update(sql, params);

	}

	public int update(final Department dept) {

		final String sql = "update department set ACTIVE=? WHERE ID=? ";
		final Object[] params = { dept.getStatus(), dept.getId() };
		return jdbcTemplate.update(sql, params);

	}

	public int delete(final Department dept) {

		final String sql = "delete from department where ID=?";
		final Object[] params = { dept.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public List<Department> find() {

		final String sql = "select ID,NAME,ACTIVE from department";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	private Department convert(ResultSet rs) throws SQLException {
		final Department dept = new Department();
		dept.setId(rs.getInt("ID"));
		dept.setName(rs.getString("NAME"));
		dept.setStatus(rs.getBoolean("ACTIVE"));
		return dept;
	}

	public Department findOne(Integer id) {

		final String sql = "select ID,NAME,ACTIVE from department where ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));
	}

}

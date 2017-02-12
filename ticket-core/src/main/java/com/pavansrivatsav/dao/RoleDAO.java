package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.Role;
import com.pavansrivatsav.util.ConnectionUtil;

public class RoleDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public Integer insert(final Role role) {
		String sql = "insert into role NAME values (?)";
		Object[] params = { role.getRoleName() };
		return jdbcTemplate.update(sql, params);
	}

	public Integer update(final Role role) {
		String sql = "update role set NAME=? where ID=?";
		Object[] params = { role.getRoleName(), role.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public Integer delete(final Role role) {

		final String sql = "delete from role where ID=?";
		final Object[] params = { role.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public List<Role> find() {

		final String sql = "select ID,NAME,ACTIVE from role";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	private Role convert(ResultSet rs) throws SQLException {
		final Role role = new Role();
		role.setId(rs.getInt("ID"));
		role.setRoleName(rs.getString("NAME"));
		role.setActive(rs.getBoolean("ACTIVE"));
		return role;
	}

	public Role findOne(Integer id) {

		final String sql = "select ID,NAME,ACTIVE from Role where ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));
	}

	/* Functionalities */

	public Integer getRoleId(String name) {
		final String sql = "select id from role where name=?";
		final Object[] params = { name };

		return jdbcTemplate.queryForObject(sql, params, Integer.class);

	}
}

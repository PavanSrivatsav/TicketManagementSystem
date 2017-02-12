package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.util.ConnectionUtil;

public class DepartmentDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int insert(final Department dept) throws PersistenceException {
		try {
			final String sql = "insert into department (NAME,ACTIVE) values(?,?)";
			final Object[] params = { dept.getName(), dept.getStatus() };
			return jdbcTemplate.update(sql, params);
		} catch (DuplicateKeyException e) {
			throw new PersistenceException("department name already exists", e);
		}
	}

	public int update(final Department dept) throws PersistenceException {
		try {
			final String sql = "update department set ACTIVE=? , NAME=? WHERE ID=? ";
			final Object[] params = { dept.getStatus(), dept.getName(), dept.getId() };
			return jdbcTemplate.update(sql, params);
		} catch (DuplicateKeyException e) {
			throw new PersistenceException("department name already exists", e);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("Please check your department id or name");
		}
	}

	public int delete(final Department dept) throws PersistenceException {
		try {
			final String sql = "delete from department where ID=?";
			final Object[] params = { dept.getId() };
			return jdbcTemplate.update(sql, params);
		} catch (DataIntegrityViolationException e) {
			throw new PersistenceException("Cannot delete ", e);
		}
	}

	public List<Department> findAll() {

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

	/* Functionalities */

	public Department findId(String department) {
		String sql = "SELECT ID FROM DEPARTMENT WHERE NAME = ?";
		Object[] params = { department };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Department dept = new Department();
			dept.setId(rs.getInt("ID"));
			return dept;

		});

	}
}

package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.modal.Role;
import com.pavansrivatsav.util.ConnectionUtil;

public class EmployeeDetailDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	private String checkticketId = "Please check your ticket id";
	private String updated = "Successfully updated";
	private String email = "Invalid emailId";

	/**
	 * @param empDetail
	 * @return
	 * @throws PersistenceException
	 */
	public String insert(final EmployeeDetail empDetail) throws PersistenceException {
		try {
			final String sql = "insert into employee_details (DEPT_ID,ROLE_ID,NAME,EMAILID,PASSWORD,ACTIVE) values(?,?,?,?,?,?)";
			final Object[] params = { empDetail.getRoleId().getId(), empDetail.getName(), empDetail.getEmailId(),
					empDetail.getPassword(), empDetail.getStatus() };
			Integer rows = jdbcTemplate.update(sql, params);
			if (rows == 0) {
				return checkticketId;

			} else {
				return updated;
			}
		} catch (DuplicateKeyException e) {
			throw new PersistenceException("EmailId already exists", e);
		}

	}

	/**
	 * @param empDetail
	 * @return
	 * @throws PersistenceException
	 */
	public String update(final EmployeeDetail empDetail) {

		final String sql = "update employee_details set pass=? WHERE EMAILID=? ";
		final Object[] params = { empDetail.getStatus(), empDetail.getEmailId() };
		Integer rows = jdbcTemplate.update(sql, params);
		if (rows == 0) {
			return checkticketId;

		} else {
			return updated;
		}

	}

	/**
	 * @param empDetail
	 * @return
	 * @throws PersistenceException
	 */
	public String delete(final EmployeeDetail empDetail) {

		final String sql = "delete from employee_details where ID=?";
		final Object[] params = { empDetail.getId() };
		final Integer rows = jdbcTemplate.update(sql, params);
		if (rows == 0) {
			return checkticketId;

		} else {
			return updated;
		}

	}

	/**
	 * @return
	 */
	public List<EmployeeDetail> find() {

		final String sql = "select ID,DEPT_ID,ROLE_ID,NAME,EMAILID,PASSWORD,ACTIVE from employee_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	/**
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private EmployeeDetail convert(ResultSet rs) throws SQLException {
		final EmployeeDetail empDetail = new EmployeeDetail();
		final Department dept = new Department();
		final Role role = new Role();
		empDetail.setId(rs.getInt("ID"));
		dept.setId(rs.getInt("DEPT_ID"));
		empDetail.setDept(dept);
		role.setId(rs.getInt("ID"));
		empDetail.setRoleId(role);
		empDetail.setName(rs.getString("NAME"));
		empDetail.setEmailId(rs.getString("EMAILID"));
		empDetail.setPassword(rs.getString("PASSWORD"));
		empDetail.setStatus(rs.getBoolean("ACTIVE"));
		return empDetail;
	}

	public EmployeeDetail findOne(Integer id) throws PersistenceException {
		try {
			final String sql = "select ID,DEPT_ID,ROLE_ID,NAME,EMAILID,PASSWORD,ACTIVE from employee_details where ID=?";
			Object[] params = { id };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("Wrong employee ID ", e);
		}
	}

	/* Functionalities */

	public String getPassword(String emailId) throws PersistenceException {
		try {

			final String sql = "select password from employee_details where EMAILID=?";
			final Object[] params = { emailId };
			return jdbcTemplate.queryForObject(sql, params, String.class);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("Invalid Id", e);
		}

	}

	public String getAdminPassword(String emailId) throws PersistenceException {
		try {

			final String sql = "select password from employee_details where EMAILID=? AND ROLE_ID=?";
			final Object[] params = { emailId, 1 };
			return jdbcTemplate.queryForObject(sql, params, String.class);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("Invalid Id", e);
		}

	}

	/**
	 * @param emailId
	 * @return
	 * @throws PersistenceException
	 */
	public Integer getEmpId(String emailId) throws PersistenceException {
		try {

			final String sql = "select ID from employee_details where EMAILID=?";
			final Object[] params = { emailId };
			return jdbcTemplate.queryForObject(sql, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException(email, e);
		}

	}

	public Integer getDepartmentId(String emailId) throws PersistenceException {
		try {

			final String sql = "select dept_id from employee_details where EMAILID=?";
			final Object[] params = { emailId };
			return jdbcTemplate.queryForObject(sql, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException(email, e);
		}

	}

	public Integer getDepartmentIdByEmpId(Integer empId) throws PersistenceException {
		try {

			final String sql = "select dept_id from employee_details where ID=?";
			final Object[] params = { empId };
			return jdbcTemplate.queryForObject(sql, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("Invalid Employee id", e);
		}

	}

	public Integer getRoleId(String emailId) throws PersistenceException {
		try {

			final String sql = "select ROLE_ID from employee_details where EMAILID=?";
			final Object[] params = { emailId };
			return jdbcTemplate.queryForObject(sql, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException(email, e);
		}

	}

	public String getEmailId(Integer roleId) throws PersistenceException {
		try {

			final String sql = "select emailid from employee_details where ROLE_ID=?";
			final Object[] params = { roleId };
			return jdbcTemplate.queryForObject(sql, params, String.class);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("Invalid role Id", e);
		}

	}
}

package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.modal.Role;
import com.pavansrivatsav.util.ConnectionUtil;

public class EmployeeDetailDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * @param empDetail
	 * @return
	 */
	public int insert(final EmployeeDetail empDetail) {
		final String sql = "insert into employee_details (ID,DEPT_ID,ROLE_ID,NAME,EMAILID,PASSWORD,ACTIVE) values(?,?,?,?,?,?,?)";
		final Object[] params = { empDetail.getId(), empDetail.getDept().getId(), empDetail.getRoleId().getId(),
				empDetail.getName(), empDetail.getEmailId(), empDetail.getPassword(), empDetail.getStatus() };
		return jdbcTemplate.update(sql, params);

	}

	/**
	 * @param empDetail
	 * @return
	 */
	public int update(final EmployeeDetail empDetail) {

		final String sql = "update employee_details set pass=? WHERE EMAILID=? ";
		final Object[] params = { empDetail.getStatus(), empDetail.getEmailId() };
		return jdbcTemplate.update(sql, params);

	}

	/**
	 * @param empDetail
	 * @return
	 */
	public int delete(final EmployeeDetail empDetail) {

		final String sql = "delete from employee_details where ID=?";
		final Object[] params = { empDetail.getId() };
		return jdbcTemplate.update(sql, params);
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

	/**
	 * @param id
	 * @return
	 */
	public EmployeeDetail findOne(Integer id) {

		final String sql = "select ID,DEPT_ID,ROLE_ID,NAME,EMAILID,PASSWORD,ACTIVE from employee_details where ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));

	}

	/* Functionalities */

	/**
	 * @param emailId
	 * @return
	 */
	public EmployeeDetail getPassword(String emailId) {
		final String sql = "select password from employee_details where EMAILID=?";
		final Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			EmployeeDetail emp = new EmployeeDetail();
			emp.setPassword(rs.getString("PASSWORD"));
			return emp;
		});
	}

	/**
	 * @param emailId
	 * @return
	 */
	public EmployeeDetail getUserId(String emailId) {
		final String sql = "select ID from employee_details where EMAILID=?";
		final Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			EmployeeDetail empDetail = new EmployeeDetail();
			empDetail.setId(rs.getInt("ID"));
			return empDetail;
		});
	}
}

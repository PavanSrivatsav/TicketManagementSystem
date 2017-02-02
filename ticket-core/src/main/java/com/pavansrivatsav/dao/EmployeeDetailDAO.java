package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class EmployeeDetailDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int insert(final EmployeeDetail empDetail) {
		final String sql = "insert into employee_details (ID,DEPT_ID,NAME,EMAILID,PASSWORD,ACTIVE) values(?,?,?,?,?,?)";
		final Object[] params = { empDetail.getId(), empDetail.getDept().getId(), empDetail.getName(),
				empDetail.getEmailId(), empDetail.getPassword(), empDetail.getStatus() };
		return jdbcTemplate.update(sql, params);

	}

	public int update(final EmployeeDetail empDetail) {

		final String sql = "update employee_details set pass=? WHERE EMAILID=? ";
		final Object[] params = { empDetail.getStatus(), empDetail.getEmailId() };
		return jdbcTemplate.update(sql, params);

	}

	public int delete(final EmployeeDetail empDetail) {

		final String sql = "delete from employee_details where ID=?";
		final Object[] params = { empDetail.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public List<EmployeeDetail> find() {

		final String sql = "select ID,DEPT_ID,NAME,EMAILID,PASSWORD,ACTIVE from employee_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	private EmployeeDetail convert(ResultSet rs) throws SQLException {
		final EmployeeDetail empDetail = new EmployeeDetail();
		final Department dept = new Department();
		empDetail.setId(rs.getInt("ID"));
		dept.setId(rs.getInt("DEPT_ID"));
		empDetail.setDept(dept);
		empDetail.setName(rs.getString("NAME"));
		empDetail.setEmailId(rs.getString("EMAILID"));
		empDetail.setPassword(rs.getString("PASSWORD"));
		empDetail.setStatus(rs.getBoolean("ACTIVE"));
		return empDetail;
	}

	public EmployeeDetail findOne(Integer id) {

		final String sql = "select ID,DEPT_ID,NAME,EMAILID,PASSWORD,ACTIVE from employee_details where ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));

	}

}

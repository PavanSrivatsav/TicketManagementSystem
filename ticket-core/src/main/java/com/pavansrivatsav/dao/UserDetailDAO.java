package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class UserDetailDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int insert(final UserDetail user) {
		final String sql = "insert into user_details (ID,NAME,EMAILID,PASSWORD,ACTIVE) values(?,?,?,?,?)";
		final Object[] params = { user.getId(), user.getName(), user.getEmailId(), user.getPassword(),
				user.getStatus() };
		return jdbcTemplate.update(sql, params);

	}

	public int update(final UserDetail user) {
		final String sql = "update user_details set pass=? WHERE EMAILID=? ";
		final Object[] params = { user.getPassword(), user.getEmailId() };
		return jdbcTemplate.update(sql, params);

	}

	public int delete(final UserDetail user) {

		final String sql = "delete from user_details where ID=?";
		final Object[] params = { user.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public List<UserDetail> find() {

		final String sql = "select ID,NAME,EMAILID,PASSWORD,ACTIVE from user_details";
		return jdbcTemplate.query(sql, (rs, rownum) -> convert(rs));
	}

	private UserDetail convert(ResultSet rs) throws SQLException {
		final UserDetail user = new UserDetail();
		user.setId(rs.getInt("ID"));
		user.setName(rs.getString("NAME"));
		user.setEmailId(rs.getString("EMAILID"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setStatus(rs.getBoolean("ACTIVE"));
		return user;
	}

	public UserDetail findOne(Integer id) {
		final String sql = "select ID,NAME,EMAILID,PASSWORD,ACTIVE from user_details where ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rownum) -> convert(rs));
	}

	/* Functionalities */

	public void updateAsInactive(UserDetail userDetail) {

		final String sql = "update tbl_users set STATUS=? where EMAILID=?";
		final Object[] params = { userDetail.getStatus(), userDetail.getEmailId() };
		jdbcTemplate.update(sql, params);
	}

	public UserDetail getPassword(String emailId) {
		final String sql = "select password from user_details where EMAILID=?";
		final Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			UserDetail user = new UserDetail();
			user.setPassword(rs.getString("PASSWORD"));
			return user;
		});
	}

	public UserDetail getUserId(String emailId) {
		final String sql = "select ID from user_details where EMAILID=?";
		final Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			UserDetail userDetail = new UserDetail();
			userDetail.setId(rs.getInt("ID"));
			return userDetail;
		});
	}

}

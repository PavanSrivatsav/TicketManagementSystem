package com.pavansrivatsav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.util.ConnectionUtil;

public class UserDetailDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * @param user
	 * @return
	 * @throws PersistenceException
	 */
	public int insert(final UserDetail user) throws PersistenceException {
		try {
			final String sql = "insert into user_details (NAME,EMAILID,PASSWORD) values (?,?,?)";
			final Object[] params = { user.getName(), user.getEmailId(), user.getPassword() };
			return jdbcTemplate.update(sql, params);
		} catch (DuplicateKeyException e) {
			throw new PersistenceException("Email id already exists", e);
		}
	}

	/**
	 * @param user
	 * @return
	 */
	public int update(final UserDetail user) {
		final String sql = "update user_details set pass=? WHERE EMAILID=? ";
		final Object[] params = { user.getPassword(), user.getEmailId() };
		return jdbcTemplate.update(sql, params);

	}

	/**
	 * @param userDetail
	 */
	public void updateAsInactive(UserDetail userDetail) {

		final String sql = "update user_details set STATUS=? where EMAILID=?";
		final Object[] params = { userDetail.getStatus(), userDetail.getEmailId() };
		jdbcTemplate.update(sql, params);
	}

	/**
	 * @param user
	 * @return
	 */
	public int delete(final UserDetail user) {

		final String sql = "delete from user_details where ID=?";
		final Object[] params = { user.getId() };
		return jdbcTemplate.update(sql, params);
	}

	/**
	 * @return
	 */
	public List<UserDetail> find() {

		final String sql = "select ID,NAME,EMAILID,PASSWORD,ACTIVE from user_details";
		return jdbcTemplate.query(sql, (rs, rownum) -> convert(rs));
	}

	/**
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private UserDetail convert(ResultSet rs) throws SQLException {
		final UserDetail user = new UserDetail();
		user.setId(rs.getInt("ID"));
		user.setName(rs.getString("NAME"));
		user.setEmailId(rs.getString("EMAILID"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setStatus(rs.getBoolean("ACTIVE"));
		return user;
	}

	/**
	 * @param id
	 * @return
	 */
	public UserDetail findOne(Integer id) {
		final String sql = "select ID,NAME,EMAILID,PASSWORD,ACTIVE from user_details where ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rownum) -> convert(rs));
	}

	/* Functionalities */

	// login
	/**
	 * @param emailId
	 * @return
	 */

	public String getPassword(String emailId) {

		final String sql = "select password from user_details where EMAILID=?";
		final Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, String.class);
	}

	// close , update and view ticket
	/**
	 * @param emailId
	 * @return
	 */

	public Integer getUserId(String emailId) throws PersistenceException {
		try {

			final String sql = "select ID from user_details where EMAILID=?";
			final Object[] params = { emailId };
			return jdbcTemplate.queryForObject(sql, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("Invalid emailId", e);
		}

	}

}

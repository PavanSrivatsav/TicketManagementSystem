package com.pavansrivatsav.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {

	private ConnectionUtil() {

	}

	private static DataSource getDataSource() {
		final BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("Pavan4Pavan");
		ds.setUrl("jdbc:mysql://localhost:3306/ticketmanagementsystem");
		return ds;
	}

	public static JdbcTemplate getJdbcTemplate() {
		final JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}

}

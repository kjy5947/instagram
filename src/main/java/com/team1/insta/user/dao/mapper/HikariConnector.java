package com.team1.insta.user.dao.mapper;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConnector {
	public Connection getConnection() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		config.setJdbcUrl("database-1.cxc98ia1oha4.us-east-2.rds.amazonaws.com");
		config.setUsername("cafe");
		config.setPassword("!!22Qorthdud");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		HikariDataSource ds = new HikariDataSource(config);

		try {
			return ds.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

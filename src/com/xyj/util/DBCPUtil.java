package com.xyj.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

public class DBCPUtil {
	private static DataSource ds;
	static{
		try {
			Properties ps = new Properties();
			InputStream is = DbUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			ps.load(is);
			ds = BasicDataSourceFactory.createDataSource(ps);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static DataSource getDataSource(){
		return ds;
	}
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

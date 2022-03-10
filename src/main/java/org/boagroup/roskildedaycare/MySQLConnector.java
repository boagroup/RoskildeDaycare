package org.boagroup.roskildedaycare;

import java.sql.*;
import java.util.TreeMap;

public class MySQLConnector {

	private final String url;
	private final String username;
	private final String password;

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet lastResult = null;
	private String lastQuery = null;

	public MySQLConnector(String url, String username, String password) {
		this.url = "jdbc:" + url;
		this.username = username;
		this.password = password;
	}

	public MySQLConnector(String url, String username, String password, boolean connect) {
		this.url = "jdbc:" + url;
		this.username = username;
		this.password = password;
		if (connect) {
			connect();
		}
	}

	public boolean connect() {
		try {
			if (connect == null || !connect.isValid(1000)) {
				connect = DriverManager.getConnection(url, username, password);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connect = null;
		return false;
	}

	private int executeQuery(String query) {
		try {
			if (statement == null) {
				statement = connect.createStatement();
			}
			return statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// TODO: CREATEDATABASE() METHOD

	public boolean createTable(String tableName, TreeMap<String, String> columns) {
		StringBuilder tempQuery = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableName + '(');
		for (String column: columns.navigableKeySet()) {
			tempQuery.append(column).append(' ').append(columns.get(column)).append(',');
		}
		lastQuery = tempQuery.deleteCharAt(tempQuery.length()-1) + ");";
		return executeQuery(lastQuery)>0;
	}

	public boolean insertInto(String tableName, TreeMap<String, String> columns) {
//		INSERT INTO table_name (column1, column2, column3, ...)
//		VALUES (value1, value2, value3, ...);
		StringBuilder tempQuery = new StringBuilder("INSERT INTO " + tableName + " (");
		for (String column: columns.navigableKeySet()) {
			tempQuery.append(column).append(',');
		}
		tempQuery.deleteCharAt(tempQuery.length()-1).append(")VALUES ");
		for (String column: columns.navigableKeySet()) {
			tempQuery.append(column).append(',');
		}
		lastQuery = tempQuery.deleteCharAt(tempQuery.length()-1)+");";
		return executeQuery(lastQuery)>0;
	}
}

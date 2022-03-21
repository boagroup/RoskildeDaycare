package org.boagroup.roskildedaycare;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Core {
	private static Core instance = null;
	private MySQLConnector database;
	private boolean isLogged = false;

	private Core() {
		database = new MySQLConnector("mysql://localhost:3306", "root", "", "Daycare");
		database.connect();
		database.createDatabase();
	}
	public static Core getInstance() {
		return (instance == null ? new Core() : instance);
	}

	public boolean isLogged() {
		return isLogged;
	}

	public boolean login(String name, String password) {
		ResultSet result = database.select("Users","Username, Password", "Username = '" + name + "' AND Password = '" + password +'\'');
		if (result == null) {
			return isLogged=false;
		}
		int count = 0;
		try {
			while (result.next() && count < 2) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return isLogged = false;
		}
		return isLogged = (count == 1);
	}

	@Deprecated
	public boolean readDatabase(Reader reader) {
		return reader.setDatabase(database);
	}

	public ResultSet list(Query query) {
		return isLogged ? database.select(query.TableName(), query.columns(), query.conditions()) : null;
	}

}

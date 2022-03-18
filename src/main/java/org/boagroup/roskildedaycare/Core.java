package org.boagroup.roskildedaycare;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Core {
	private static Core instance = null;
	private MySQLConnector database;
	private boolean isLogged = false;
	private String DBName;

	private Core() {
		database = new MySQLConnector("mysql://localhost:3306", "root", "", "Daycare");
		database.connect();
		database.createDatabase();
	}
	public static Core getInstance() {
		if (instance == null) {
			instance = new Core();
		}
		return instance;
	}

	public String getDBName() {
		return DBName;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public boolean login(String name, String password) {
		ResultSet result = database.select("Users","Username, Password", "Username LIKE " + name + " AND Password LIKE " + password);
		int count = 0;
		try {
			while (result.next() && count < 2) {
				count++;
			}
		} catch (SQLException e) {e.printStackTrace(); return isLogged=false;}
		return isLogged = (count == 1);
	}

	public boolean readDatabase() {return false;}

	public ResultSet list(Query query) {
		return database.select(query.TableName(), query.columns(), query.conditions());
	}

}

package org.boagroup.roskildedaycare;

import java.sql.ResultSet;

public class Core {
	private static Core instance = null;
	private MySQLConnector database;
	private boolean isLogged = false;
	private String DBName;

	private Core() {}
	public static Core getInstance() {
		if (instance == null) {
			instance = new Core();
		}
		return instance;
	}

	public Core setDBName(String DBName) {
		this.DBName = DBName;
		return this;
	}

	public String getDBName() {
		return DBName;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public boolean login(String name, String password) {return isLogged;}

	public boolean readDatabase() {return false;}

	public ResultSet list(QueryState query) {return null;}

}

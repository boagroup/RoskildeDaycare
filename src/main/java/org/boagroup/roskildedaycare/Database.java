package org.boagroup.roskildedaycare;

import java.sql.ResultSet;
import java.util.TreeMap;

public class Database {
	private final MySQLConnector con = new MySQLConnector("mysql://localhost:3306", "root", "", "Daycare");

	public Database() {
		initialize();
	}

	public void initialize() {
		con.connect();
		con.createDatabase();
	}

	public void fillUp(TreeMap<String, TreeMap<String, String>> tables) {}

	public ResultSet selectData() {return null;}



}

package org.boagroup.roskildedaycare;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class CoreTest {
	Core testedCore;

	@Test
	void testGettingInstance() {
		testedCore = Core.getInstance();
		Core secondInstance = Core.getInstance();
		assertSame(testedCore, secondInstance);
	}

	@Test
	void userTest() {
		MySQLConnector con = new MySQLConnector("mysql://localhost:3306", "root", "", "Daycare");
		TreeMap<String,String> tm = new TreeMap<>();
		tm.put("username","VARCHAR(255) NOT NULL");
		tm.put("password", "VARCHAR(255) NOT NULL");
		con.connect();
		con.createDatabase();
		con.createTable("Users", tm);
		tm.clear();
		tm.put("username", "'bart'");
		tm.put("password", "'trab'");
		assertTrue(
		con.insertInto("Users", tm)
		);
	}
}
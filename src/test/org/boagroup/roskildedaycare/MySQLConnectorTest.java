package org.boagroup.roskildedaycare;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test of MySQLConnector")
class MySQLConnectorTest {

	MySQLConnector testedConnector;
	TreeMap<String, String> columns;

//	@BeforeEach
//	void setUp() {
//	}

	@Test
	void connect() {
		testedConnector = new MySQLConnector("mysql://localhost:3306", "root", "");
		assertTrue(testedConnector.connect());
	}

	@Test
	void createDatabase() {
		fail();
	}

	@Test
	void createTable() {
		testedConnector = new MySQLConnector("mysql://localhost:3306/Daycare", "root", "");
		columns = new TreeMap<>();
		columns.put("testId","INT NOT NULL PRIMARY KEY");
		columns.put("testStr", "VARCHAR(3000)");
		System.out.println(columns.toString());
		testedConnector.connect();
		assertTrue(testedConnector.createTable("test", columns));
	}

	@Test
	void insertInto() {
		fail();
	}

	@Test
	void checkLogin() { fail(); }

	@Test
	void checkPassword() { fail(); }
}
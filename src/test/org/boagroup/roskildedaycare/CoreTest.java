package org.boagroup.roskildedaycare;

import org.junit.jupiter.api.*;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CoreTest {

	Core testedCore;

	@BeforeEach
	void setUp() {
		MySQLConnector mySQLConnector = new MySQLConnector("mysql://localhost:3306", "root", "", "Daycare");
		mySQLConnector.connect();
		mySQLConnector.createDatabase();
		TreeMap<String, String> tm = new TreeMap<>();
		tm.put("Username", "VARCHAR(255) NOT NULL PRIMARY KEY");
		tm.put("Password", "VARCHAR(255) NOT NULL");
		mySQLConnector.createTable("Users", tm);
		tm.clear();
		tm.put("Username", "bart");
		tm.put("Password", "trab");
		mySQLConnector.insertInto("Users", tm);
		mySQLConnector.close();
		testedCore = Core.getInstance();
	}

//	@AfterEach
	void tearDown() {
		MySQLConnector mySQLConnector = new MySQLConnector("mysql://localhost:3306", "root", "", "Daycare");
		mySQLConnector.connect();
		mySQLConnector.dropClose();
	}

	@Test
	@Order(0)
	void getInstance() {
		Core secondCore = Core.getInstance();
		assertSame(testedCore, secondCore);
	}

	@Test
	@Order(1)
	void loginWrong() {
		assertFalse(testedCore.login("wrongname", "wrongpassword"));
	}

	@Test
	 @Order(2)
	 void loginCorrect() {
		assertTrue(testedCore.login("bart", "trab"));
	}

//	@Test
//	void readDatabase() {
//	}

	@Test
	@Order(3)
	void list() {
		testedCore.login("bart", "trab");
		assertNotNull(testedCore.list(new Query("Users","*", null)));

	}
}
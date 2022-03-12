package org.boagroup.roskildedaycare;

import org.junit.jupiter.api.*;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test of MySQLConnector")
class MySQLConnectorTest {

	final String url = "mysql://localhost:3306";
	final String usr = "root";
	final String pw = "";
	final String DBName = "Daycare";
	MySQLConnector testedConnector;
	TreeMap<String, String> columns;

//	@BeforeEach
	void setUp() {
		testedConnector = new MySQLConnector(url, usr, pw, DBName, true);
		testedConnector.createDatabase();
	}

//	@AfterEach
	void cleanUp() {
		testedConnector.dropClose();
	}

	@Test
	@Order(0)
	void connect() {
		testedConnector = new MySQLConnector(url, usr, pw, DBName);
		assertTrue(testedConnector.connect());
	}

	@Test
	@Order(1)
	void createDatabase() {
		testedConnector = new MySQLConnector(url, usr, pw, DBName, true);
		assertTrue(testedConnector.createDatabase());
	}

	@Test
	@Order(2)
	void createTable() {
		setUp();
		columns = new TreeMap<>();
		columns.put("testId","INT NOT NULL PRIMARY KEY");
		columns.put("testStr", "VARCHAR(3000)");
		System.out.println(columns.toString());
		assertTrue(testedConnector.createTable("test", columns));
	}

	@Test
	@Order(3)
	void insertInto() {
		createTable();
		columns = new TreeMap<>();
		columns.put("testId", "default");
		columns.put("testStr", "'lolol'");
		System.out.println(columns.toString());
		assertTrue(testedConnector.insertInto("test", columns));
	}

	@Test
	@Order(4)
	void checkLogin() { fail(); }

	@Test
	@Order(5)
	void checkPassword() { fail(); }
}
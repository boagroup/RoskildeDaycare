package org.boagroup.roskildedaycare;

import java.util.List;

public interface Reader {
	List<String> getInstructions(String filepath);
	boolean setDatabase(MySQLConnector connector);
}

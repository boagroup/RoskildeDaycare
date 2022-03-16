package org.boagroup.roskildedaycare;

import org.junit.jupiter.api.Test;

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
	void testSetDBNameReturningCore() {
		assertTrue(Core.getInstance().setDBName("test") instanceof Core);
	}

	@Test
	void testSetDBName() {
		testedCore = Core.getInstance().setDBName("test");
		assertEquals(testedCore.getDBName(),"test");
	}
}
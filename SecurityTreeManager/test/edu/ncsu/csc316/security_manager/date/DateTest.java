package edu.ncsu.csc316.security_manager.date;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Date class
 * @author Justin Schwab
 *
 */
public class DateTest {

	/**
	 * Tests the methods in the Date class
	 */
	@Test
	public void test() {
		Date d1 = new Date(1995, 8, 31, 17, 5, 1);
		assertEquals(1995, d1.getYear());
		assertEquals(8, d1.getMonth());
		assertEquals(31, d1.getDay());
		assertEquals(17, d1.getHour());
		assertEquals(5, d1.getMin());
		assertEquals(1, d1.getSec());
		
		assertEquals("1995/08/31 17:05:01", d1.toString());
		
		Date d2 = new Date(1995, 8, 31, 17, 5, 37);
		Date d3 = new Date(1995, 8, 31, 17, 6, 21);
		Date d4 = new Date(1995, 8, 31, 12, 8, 9);
		Date d5 = new Date(1995, 8, 21, 3, 59, 31);
		Date d6 = new Date(1995, 7, 1, 17, 6, 21);
		Date d7 = new Date(2016, 8, 31, 17, 30, 0);
		
		assertTrue(d1.compareTo(d1) == 0);
		
		assertTrue(d1.compareTo(d2) < 0);
		assertTrue(d2.compareTo(d1) > 0);
		
		assertTrue(d1.compareTo(d3) < 0);
		assertTrue(d3.compareTo(d1) > 0);
		
		assertTrue(d1.compareTo(d4) > 0);
		assertTrue(d4.compareTo(d1) < 0);
		
		assertTrue(d1.compareTo(d5) > 0);
		assertTrue(d5.compareTo(d1) < 0);
		
		assertTrue(d1.compareTo(d6) > 0);
		assertTrue(d6.compareTo(d1) < 0);
		
		assertTrue(d1.compareTo(d7) < 0);
		assertTrue(d7.compareTo(d1) > 0);
	}

}

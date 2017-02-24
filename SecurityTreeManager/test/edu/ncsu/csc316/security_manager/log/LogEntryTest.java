package edu.ncsu.csc316.security_manager.log;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_manager.date.Date;

/**
 * Tests the LogEntry class
 * @author Justin Schwab
 */
public class LogEntryTest {

	/**
	 * Tests the methods in the LogEntry class
	 */
	@Test
	public void test() {
		Date d1 = new Date(1995, 8, 31, 18, 45, 0);
		Date d2 = new Date(2017, 3, 3, 23, 45, 0);
		
		LogEntry le1 = new LogEntry(d1, "jgschwab", "justin was born");
		LogEntry le2 = new LogEntry(d1, "jgschwab", "muh birthday");
		LogEntry le3 = new LogEntry(d1, "jtking", "justin was born");
		LogEntry le4 = new LogEntry(d2, "jgschwab", "this project is due");
		
		assertEquals("LogEntry[timestamp=1995/08/31 18:45:00, user="
				+ "jgschwab, description=justin was born]", le1.toString());
		
		assertEquals("LogEntry[timestamp=1995/08/31 18:45:00, user="
				+ "jgschwab, description=muh birthday]", le2.toString());
		
		assertEquals("LogEntry[timestamp=1995/08/31 18:45:00, user="
				+ "jtking, description=justin was born]", le3.toString());
		
		assertEquals("LogEntry[timestamp=2017/03/03 23:45:00, user="
				+ "jgschwab, description=this project is due]", le4.toString());
		
		assertTrue(le1.compareTo(le1) == 0);
		
		assertTrue(le1.compareTo(le2) < 0);
		assertTrue(le2.compareTo(le1) > 0);

		assertTrue(le1.compareTo(le3) < 0);
		assertTrue(le3.compareTo(le1) > 0);
		
		assertTrue(le1.compareTo(le4) < 0);
		assertTrue(le4.compareTo(le1) > 0);
	}

}

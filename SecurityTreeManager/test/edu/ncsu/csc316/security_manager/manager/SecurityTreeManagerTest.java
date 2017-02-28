package edu.ncsu.csc316.security_manager.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the SecurityTreeManager class
 * @author Justin Schwab
 *
 */
public class SecurityTreeManagerTest {

	/**
	 * Tests the methods in the SecurityTreeManager class
	 */
	@Test
	public void test() {
		SecurityTreeManager stm = new SecurityTreeManager("input/sample-log.txt");
		assertEquals("LogEntry[timestamp=2014/10/06 13:11:31, user=user5, "
				+ "description=edit office visit information]",
				stm.getLogEntriesForDate("10-06-2014"));
		assertEquals("LevelOrder[\n" +
				"   LogEntry[timestamp=2015/09/13 02:58:49, user=user2, description=save patient list]\n" +
				"   LogEntry[timestamp=2012/12/18 16:25:58, user=user18, description=view diagnoses]\n" +
				"   LogEntry[timestamp=2016/12/12 06:28:13, user=user6, description=edit patient representative list]\n" +
				"   LogEntry[timestamp=2011/08/12 20:13:47, user=user1, description=create basic health information]\n" +
				"   LogEntry[timestamp=2013/07/19 22:49:10, user=user1, description=edit email reminders]\n" +
				"   LogEntry[timestamp=2015/10/07 05:34:10, user=user7, description=edit email reminders]\n" +
				"   LogEntry[timestamp=2010/06/27 03:45:37, user=user10, description=delete calendar]\n" +
				"   LogEntry[timestamp=2012/09/17 11:45:24, user=user16, description=create upcoming appointments]\n" +
				"   LogEntry[timestamp=2013/05/14 21:16:36, user=user3, description=add upcoming appointments]\n" +
				"   LogEntry[timestamp=2015/07/10 00:26:58, user=user15, description=add patient representative list]\n" +
				"   LogEntry[timestamp=2007/11/24 24:10:24, user=user19, description=update appointment requests]\n" +
				"   LogEntry[timestamp=2010/07/14 12:53:15, user=user7, description=remove diagnoses]\n" +
				"   LogEntry[timestamp=2013/06/16 24:28:33, user=user3, description=add appointment requests]\n" +
				"   LogEntry[timestamp=2015/02/10 16:12:23, user=user15, description=modify office visit information]\n" +
				"   LogEntry[timestamp=2015/08/01 03:54:17, user=user10, description=update appointment requests]\n" +
				"   LogEntry[timestamp=2007/06/01 07:37:31, user=user3, description=print immunizations]\n" +
				"   LogEntry[timestamp=2009/01/03 10:35:47, user=user11, description=view email reminders]\n" +
				"   LogEntry[timestamp=2014/10/06 13:11:31, user=user5, description=edit office visit information]\n" +
				"   LogEntry[timestamp=2015/03/29 13:38:31, user=user7, description=view demographics]\n" +
				"   LogEntry[timestamp=2015/07/17 15:55:25, user=user8, description=save immunizations]\n" +
				"]", stm.getLogTreeLevelOrder());
	}
}
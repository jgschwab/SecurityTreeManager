 package edu.ncsu.csc316.security_manager.io;

import static org.junit.Assert.*;


import org.junit.Test;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.date.TimeStamp;
import edu.ncsu.csc316.security_manager.list.Queue;
import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * Tests the FileReader class
 * @author Justin Schwab
 *
 */
public class FileReaderTest {

	/**
	 * Tests the methods in the FileReader class
	 */
	@Test
	public void test() {
		FileReader f = new FileReader();
		Queue<AttackStep> preorder = null;
		try{
			preorder = f.readAttackTraversal("input/nonexistent.txt");
			fail();
		} catch(IllegalArgumentException e){
			//pass
		}
		
		preorder = f.readAttackTraversal("input/ddos-preorder.txt");
		
		assertEquals(15, preorder.size());
		
		AttackStep as0 = preorder.dequeue();
		assertEquals('G', as0.getTag() );
		assertEquals("Use DDoS Attack to Disrupt All Users", as0.getDesc() );
		assertEquals(14, preorder.size());
		
		AttackStep as1 = preorder.dequeue();
		assertEquals('O', as1.getTag() );
		assertEquals("Attack Servers", as1.getDesc() );
		assertEquals(13, preorder.size());
		
		AttackStep as2 = preorder.dequeue();
		assertEquals('O', as2.getTag() );
		assertEquals("Direct BOTNET against key Servers", as2.getDesc() );
		assertEquals(12, preorder.size());
		
		AttackStep as3 = preorder.dequeue();
		assertEquals('O', as3.getTag() );
		assertEquals("\"Rent\" Existing BOTNET", as3.getDesc() );
		assertEquals(11, preorder.size());
		
		AttackStep as4 = preorder.dequeue();
		assertEquals('O', as4.getTag() );
		assertEquals("Build a BOTNET", as4.getDesc() );
		assertEquals(10, preorder.size());
		
		AttackStep as5 = preorder.dequeue();
		assertEquals('A', as5.getTag() );
		assertEquals("Find Vulnerable Computers", as5.getDesc() );
		assertEquals(9, preorder.size());
		
		AttackStep as6 = preorder.dequeue();
		assertEquals('A', as6.getTag() );
		assertEquals("Infect Computer with BOT", as6.getDesc() );
		assertEquals(8, preorder.size());
		
		AttackStep as7 = preorder.dequeue();
		assertEquals('A', as7.getTag() );
		assertEquals("Remain Undetected", as7.getDesc() );
		assertEquals(7, preorder.size());
		
		AttackStep as8 = preorder.dequeue();
		assertEquals('O', as8.getTag() );
		assertEquals("Infect Servers with Worm/Virus", as8.getDesc() );
		assertEquals(6, preorder.size());
		
		AttackStep as9 = preorder.dequeue();
		assertEquals('O', as9.getTag() );
		assertEquals("Attack Comm Infrastructure", as9.getDesc() );
		assertEquals(5, preorder.size());
		
		AttackStep as10 = preorder.dequeue();
		assertEquals('O', as10.getTag() );
		assertEquals("Attack Switches", as10.getDesc() );
		assertEquals(0.3, as10.getProb(), 0.0001);
		assertEquals(7, as10.getImpact(), 0.0001);
		assertEquals(30000, as10.getCost(), 0.0001);
		assertEquals(4, preorder.size());
		
		AttackStep as11 = preorder.dequeue();
		assertEquals('O', as11.getTag() );
		assertEquals("Attack Routers", as11.getDesc() );
		assertEquals(3, preorder.size());
		
		AttackStep as12 = preorder.dequeue();
		assertEquals('O', as12.getTag() );
		assertEquals("Attack DNS", as12.getDesc() );
		assertEquals(2, preorder.size());
		
		AttackStep as13 = preorder.dequeue();
		assertEquals('O', as13.getTag() );
		assertEquals("Attack All Clients", as13.getDesc() );
		assertEquals(1, preorder.size());
		
		AttackStep as14 = preorder.dequeue();
		assertEquals('O', as14.getTag() );
		assertEquals("Infect Clients with Worm/Virus", as14.getDesc() );
		assertEquals(0, preorder.size());
		
		
		Queue<LogEntry> logs = null;
		try{
			logs = f.readLogFile("input/FAIL.txt");
			fail();
		} catch(IllegalArgumentException e){
			//pass
		}
		
		logs = f.readLogFile("input/sample-log.txt");
		
		LogEntry log1 = logs.dequeue();
		assertEquals(0, new TimeStamp(2015, 9, 13, 2, 58, 49).compareTo(log1.getTimeStamp()));
		assertEquals("user2", log1.getUser());
		assertEquals("save patient list", log1.getDesc());
		
		logs.dequeue();
		logs.dequeue();
		logs.dequeue();
		logs.dequeue();
		logs.dequeue();
		logs.dequeue();
		
		log1 = logs.dequeue();
		assertEquals(0, new TimeStamp(2015, 10, 7, 5, 34, 10).compareTo(log1.getTimeStamp()));
		assertEquals("user7", log1.getUser());
		assertEquals("edit email reminders", log1.getDesc());
		
		logs.dequeue();
		logs.dequeue();
		logs.dequeue();
		
		log1 = logs.dequeue();
		assertEquals(0, new TimeStamp(2014, 10, 6, 13, 11, 31).compareTo(log1.getTimeStamp()));
		assertEquals("user5", log1.getUser());
		assertEquals("edit office visit information", log1.getDesc());
	}
}
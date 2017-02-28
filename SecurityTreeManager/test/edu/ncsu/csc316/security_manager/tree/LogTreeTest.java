package edu.ncsu.csc316.security_manager.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_manager.io.FileReader;
import edu.ncsu.csc316.security_manager.list.Queue;
import edu.ncsu.csc316.security_manager.log.LogEntry;
import edu.ncsu.csc316.security_manager.tree.LogTree.LogNode;

/**
 * Tests the LogTree class
 * @author Justin Schwab
 *
 */
public class LogTreeTest {

	/**
	 * Tests the methods in the LogTree class
	 */
	@Test
	public void test() {
		LogTree logTree = new LogTree();
		Queue<LogEntry> logs = FileReader.readLogFile("input/sample-log.txt");
		while(!logs.isEmpty()){
			logTree.add(new LogNode(logs.dequeue()));
		}
		logs = logTree.lookUp("07-19-2013");
		assertEquals(1, logs.size());
		logs = logTree.lookUp("08-31-1995");
		assertEquals(0, logs.size());
		logs = logTree.lookUp("10-07-2015");
		assertEquals(1, logs.size());
		logs = logTree.lookUp("12-13-2016");
		assertEquals(0, logs.size());
	}
}
package edu.ncsu.csc316.security_manager.io;

import edu.ncsu.csc316.security_manager.list.AttackList;
import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * Class that contains static methods for 
 * reading files for the attack tree and log tree
 * @author Justin Schwab
 */
public class FileReader {
	/**
	 * Reads an Attack tree traversal file; returns an
	 * AttackList of AttackSteps to use for building
	 * the AttackTree
	 */
	public AttackList readAttackTraversal(String fileName){
		return null;
	}
	
	/**
	 * Reads a log entry file; returns an
	 * array of LogEntries to use for building
	 * the LogTree
	 */
	public LogEntry[] readLogFile(String fileName){
		return null;
	}
}

package edu.ncsu.csc316.security_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.date.Date;
import edu.ncsu.csc316.security_manager.list.Queue;
import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * Class that contains static methods for 
 * reading files for the attack tree and log tree
 * @author Justin Schwab
 */
public class FileReader {
	/**
	 * Reads an Attack tree traversal file; returns a
	 * Queue of AttackSteps to use for building
	 * the AttackTree
	 */
	public Queue<AttackStep> readAttackTraversal(String fileName){
		Scanner fileScan;
		try{
			fileScan = new Scanner(new File(fileName));
		}catch(FileNotFoundException e){
			throw new IllegalArgumentException("File doesn't exist");
		}
		Queue<AttackStep> list = new Queue<AttackStep>();
		while(fileScan.hasNextLine()){
			list.enqueue(readAttackStep(fileScan.nextLine()));
		}
		fileScan.close();
		return null;
	}
	
	/**
	 * Helper method for parsing a line and returning an AttackStep
	 * @param line The line to parse into an AttackStep
	 * @return The AttackStep parsed from the input String
	 */
	private static AttackStep readAttackStep(String line){
		char tag = ' ';
		double prob = -1;
		double impact = -1;
		double cost = -1;
		String desc = null;
		Scanner lineScan = new Scanner(line);
		tag = lineScan.next().charAt(0);
		if(lineScan.hasNextDouble()){ //leaf node
			prob = lineScan.nextDouble();
			impact = lineScan.nextDouble();
			cost = lineScan.nextDouble();
		} else{ //internal node
			desc = lineScan.nextLine(); 
		}
		lineScan.close();
		return new AttackStep(tag, prob, impact, cost, desc);
	}
	
	/**
	 * Reads a log entry file; returns a
	 * Queue of LogEntries to use for building
	 * the LogTree
	 */
	public Queue<LogEntry> readLogFile(String fileName){
		Scanner fileScan;
		try{
			fileScan = new Scanner(new File(fileName));
		}catch(FileNotFoundException e){
			throw new IllegalArgumentException("File doesn't exist");
		}
		Queue<LogEntry> list = new Queue<LogEntry>();
		while(fileScan.hasNextLine()){
			list.enqueue(readLogEntry(fileScan.nextLine()));
		}
		fileScan.close();
		return list;
	}

	/**
	 * Helper method for reading a single line of a log file and
	 * parsing it into a LogEntry object.
	 * @param line The line to parse into a LogEntry
	 * @return The LogEntry parsed from the input String
	 */
	private static LogEntry readLogEntry(String line) {
		Scanner lineScan = new Scanner(line);
		lineScan.useDelimiter(",");
		Date timestamp = parseTimestamp(lineScan.next());
		String user = lineScan.next();
		String desc = lineScan.next();
		lineScan.close();
		return new LogEntry(timestamp, user, desc);
	}

	/**
	 * Helper method to parse a timestamp into a Date object
	 * @param time The String to parse into a Date
	 * @return The Date object parsed from the input String
	 */
	private static Date parseTimestamp(String time) {
		Scanner timeScan = new Scanner(time);
		String ymd = timeScan.next();
		String hms = timeScan.next();
		timeScan.close();
		timeScan = new Scanner(ymd);
		timeScan.useDelimiter("-");
		int month = timeScan.nextInt();
		int day = timeScan.nextInt();
		int year = timeScan.nextInt();
		timeScan.close();
		timeScan = new Scanner(hms);
		timeScan.useDelimiter(":");
		int hour = timeScan.nextInt();
		int min = timeScan.nextInt();
		int sec = timeScan.nextInt();
		timeScan.close();
		return new Date(year, month, day, hour, min, sec);
	}
}
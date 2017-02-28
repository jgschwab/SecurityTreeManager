package edu.ncsu.csc316.security_manager.log;

import edu.ncsu.csc316.security_manager.date.TimeStamp;

/**
 * A Log entry object. Stored in the LogTree data structure
 * @author Justin Schwab
 */
public class LogEntry implements Comparable<LogEntry>{

	/** The timestamp of this log entry */
	private TimeStamp timestamp;
	/** the user associated with this log entry */
	private String user;
	/** The description associated with this log entry */
	private String desc;
	
	/**
	 * Constructs a LogEntry with a date, user, and description
	 * @param timestamp The timestamp of this LogEntry
	 * @param user The user who generated this LogEntry
	 * @param desc The description of this LogEntry
	 */
	public LogEntry(TimeStamp timestamp, String user, String desc){
		this.timestamp = timestamp;
		this.user = user;
		this.desc = desc;
	}

	/**
	 * Gets the timestamp of this log entry
	 * @return The timestamp of this log entry
	 */
	public TimeStamp getTimeStamp() {
		return timestamp;
	}

	/**
	 * Gets the user associated with this log entry
	 * @return The user associated with this log entry
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Gets the description of this log entry
	 * @return The description of this log entry
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Converts this log entry to a String
	 * @return This log entry as a String
	 */
	@Override
	public String toString(){
		return "LogEntry[timestamp=" + timestamp.toString() + ", user="
				+ user + ", description=" + desc + "]";
	}
	
	/**
	 * Compares two log entries and determines how to order them
	 * @param o The other log entry to compare with
	 * @return A positive int if this log entry should appear later than the other
	 */
	@Override
	public int compareTo(LogEntry o) {
		if(timestamp.compareTo(o.getTimeStamp()) != 0){
			return timestamp.compareTo(o.getTimeStamp());
		} else if(user.compareTo(o.getUser()) != 0){
			return user.compareTo(o.getUser());
		} else if(desc.compareTo(o.getDesc()) != 0){
			return desc.compareTo(o.getDesc());
		} else{
			return 0;
		}
	}
}
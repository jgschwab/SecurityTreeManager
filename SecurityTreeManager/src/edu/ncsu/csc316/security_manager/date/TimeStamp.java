package edu.ncsu.csc316.security_manager.date;

public class TimeStamp implements Comparable<TimeStamp> {

	/** The time of this timestamp */
	private Time time;
	/** The date of this timestamp */
	private Date date;
	
	/**
	 * Constructs a TimeStamp object which keeps track of date and time
	 * @param date The date
	 * @param time The time
	 */
	public TimeStamp(Date date, Time time){
		this.date = date;
		this.time = time;
	}
	
	/**
	 * Overloaded constructor to make a TimeStamp directly from 6 ints
	 * @param year The year of this TimeStamp
	 * @param month The month of this TimeStamp
	 * @param day The day of this TimeStamp
	 * @param hour The hour of this TimeStamp
	 * @param minute The minute of this TimeStamp
	 * @param second The second of this TimeStamp
	 */
	public TimeStamp(int year, int month, int day, int hour, int minute, int second){
		this.date = new Date(year, month, day);
		this.time = new Time(hour, minute, second);
	}
	
	/**
	 * Gets the time of this timestamp
	 * @return The time of this timestamp
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * Gets the date of this timestamp
	 * @return The date of this timestamp
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Gets the Year of this TimeStamp
	 * @return The year of this TimeStamp
	 */
	public int getYear(){
		return date.getYear();
	}
	
	/**
	 * Gets the month of this TimeStamp
	 * @return The month of this TimeStamp
	 */
	public int getMonth(){
		return date.getMonth();
	}
	
	/**
	 * Gets the day of this TimeStamp
	 * @return The day of this TimeStamp
	 */
	public int getDay(){
		return date.getDay();
	}
	
	/**
	 * Gets the hour of this TimeStamp
	 * @return The hour of this TimeStamp
	 */
	public int getHour(){
		return time.getHour();
	}
	
	/**
	 * Gets the minute of this TimeStamp
	 * @return The minute of this TimeStamp
	 */
	public int getMin(){
		return time.getMin();
	}
	
	/**
	 * Gets the second of this TimeStamp
	 * @return The second of this TimeStamp
	 */
	public int getSec(){
		return time.getSec();
	}

	public String toString(){
		return this.getDate().toString() + " " + this.getTime().toString();
	}
	
	/**
	 * Compares two timestamps and determines which one should come
	 * after the other based on the data they contain
	 * @param other The other timestamp to consider
	 * @return a positive int if this timestamp is greater
	 * than the other timestamp
	 */
	@Override
	public int compareTo(TimeStamp other) {
		if(this.date.compareTo(other.getDate()) != 0){
			return this.date.compareTo(other.getDate());
		} else if(this.time.compareTo(other.getTime()) != 0){
			return this.time.compareTo(other.getTime());
		} else {
			return 0;
		}
	}
}
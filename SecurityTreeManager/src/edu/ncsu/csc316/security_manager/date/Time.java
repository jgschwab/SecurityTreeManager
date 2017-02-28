package edu.ncsu.csc316.security_manager.date;

public class Time implements Comparable<Time>{

	/** The hour */
	private int hour;
	/** The minute */
	private int min;
	/** The second */
	private int sec;
	
	/**
	 * Constructs a new Time object
	 * @param hour The hour of this Time
	 * @param minute The minute of this Time
	 * @param second The second of this Time
	 */
	public Time(int hour, int minute, int second){
		this.hour = hour;
		this.min = minute;
		this.sec = second;
	}
	
	/**
	 * Gets the Hour of this Time
	 * @return The hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Gets the minute of this Time
	 * @return The minute
	 */
	public int getMin() {
		return min;
	}
	
	/**
	 * Gets the second of this Time
	 * @return The second
	 */
	public int getSec() {
		return sec;
	}
	
	@Override
	public int compareTo(Time other){
		if(this.hour != other.getHour()){
			return this.hour > other.getHour() ? 1 : -1;
		} else if(this.min != other.getMin()){
			return this.min > other.getMin() ? 1 : -1;
		} else if(this.sec != other.getSec()){
			return this.sec > other.getSec() ? 1 : -1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Converts this Time into a String
	 * @return this Time as a String
	 */
	@Override
	public String toString(){
		return String.format("%02d", hour)
				+ ":" + String.format("%02d", min) 
				+ ":" + String.format("%02d", sec);
	}
}
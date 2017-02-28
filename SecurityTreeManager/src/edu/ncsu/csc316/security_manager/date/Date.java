package edu.ncsu.csc316.security_manager.date;

public class Date implements Comparable<Date>{
	
	/** The year */
	private int year;
	/** The month */
	private int month;
	/** The day */
	private int day;
	
	
	/**
	 * Constructs a Date object which keeps track of 6 temporal values
	 * @param year The year
	 * @param month The month
	 * @param day The day
	 */
	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/**
	 * Gets the year of this Date
	 * @return The year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Gets the Month of this Date
	 * @return The month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Gets the day of this Date
	 * @return The day
	 */
	public int getDay() {
		return day;
	}

	
	/**
	 * Converts this Date into a String
	 * @return this Date as a String
	 */
	@Override
	public String toString(){
		return "" + year + "/" + String.format("%02d", month) 
				+ "/" + String.format("%02d", day);
	}
	
	/**
	 * Compares two dates and determines which one comes after the other
	 * @param other The other Date to compare against this Date
	 * @return a positive int if this Date is later than the parameterized Date
	 */
	@Override
	public int compareTo(Date other) {
		if(this.year != other.getYear()){
			return this.year > other.getYear() ? 1 : -1;
		} else if(this.month != other.getMonth()){
			return this.month > other.getMonth() ? 1 : -1;
		} else if(this.day != other.getDay()){
			return this.day > other.getDay() ? 1 : -1;
		} else {
			return 0;
		}
	}
}
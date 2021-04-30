/*
 *  Class: C212 Introduction to Software Systems
 *  Assignment: Project(Movie Booking Application)
 *  Group Number: 27
 *  Group Members: Collin Rassel, Evan Japundza, Maouloune Goumballe, and Spencer Chambers
 *  Due Date: April 30, 2021
 */

public class Date implements Comparable<Object>
{
	// instance variables
	private int year; //year of date
	private int month; //month of date
	private int day; //day of date
	
	//Constructor
	public Date(int year,int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	//getters and setters
	public int getYear()
	{
		return year;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public int getMonth()
	{
		return month;
	}
	public void setMonth(int month)
	{
		this.month = month;
	}
	public int getDay()
	{
		return day;
	}
	public void setDay(int day)
	{
		this.day = day;
	}

	//other methods
	public String toString()
	{ //prints date in readable string format
		String ret = year + "/" + month + "/" + day;
		return ret;
	}
	
	public int compareTo(Object otherObject)
	{
		Date other = (Date) otherObject;
		if(this.year == other.year && this.month == other.month) { //based on days (if years and month are equal)
			if(this.day < other.day) {return -1;}
			if(this.day > other.day) {return 1;}
			else {return 0;}
		}
		if(this.year == other.year) { //based on months (if years are equal)
			if(this.month < other.month) {return -1;}
			if(this.month > other.month) {return 1;}
			else {return 0;}
		}
		else { //based on years
			if(this.year < other.year) {return -1;}
			if(this.year > other.year) {return 1;}
			else {return 0;}
		}
	}
}

package com.example.bencher.json;

public class Birthday{
	private int day;
	private int month;
	private int year;
	public int getDay() {
		return day;
	}
	public Birthday() {
		super();
	}

	public Birthday(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Birthday [year=" + year + ", month=" + month + ", day=" + day
				+ "]";
	}
}
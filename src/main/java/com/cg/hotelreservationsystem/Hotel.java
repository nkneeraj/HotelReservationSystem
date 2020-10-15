package com.cg.hotelreservationsystem;

public class Hotel {
	
	private String hotelName;
	private int regCustomerWeekDayRate;
	private int regCustomerWeekendDayRate;
	private int rating;
	
	public Hotel(String hotelName, int regCustomerRate, int regCustomerWeekendDayRate, int rating) {
		this.hotelName = hotelName;
		this.regCustomerWeekDayRate = regCustomerRate;
		this.regCustomerWeekendDayRate = regCustomerWeekendDayRate;
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegCustomerRate() {
		return regCustomerWeekDayRate;
	}

	public void setRegCustomerRate(int regCustomerRate) {
		this.regCustomerWeekDayRate = regCustomerRate;
	}

	public int getRegCustomerWeekendDayRate() {
		return regCustomerWeekendDayRate;
	}

	public void setRegCustomerWeekendDayRate(int regCustomerWeekendDayRate) {
		this.regCustomerWeekendDayRate = regCustomerWeekendDayRate;
	}	
	
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", regCustomerWeekDayRate=" + regCustomerWeekDayRate
				+ ", regCustomerWeekendDayRate=" + regCustomerWeekendDayRate + "]";
	}
}

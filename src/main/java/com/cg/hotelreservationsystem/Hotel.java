package com.cg.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private int regCustomerWeekDayRate;
	private int regCustomerWeekendDayRate;
	private int rewCustomerWeekDayRate;
	private int rewCustomerWeekeendDayRate;
	private int rating;

	public Hotel(String hotelName, int regCustomerRate, int regCustomerWeekendDayRate, int rewCustomerWeekDayRate,
			int rewCustomerWeekendDayRate, int rating) {
		this.hotelName = hotelName;
		this.regCustomerWeekDayRate = regCustomerRate;
		this.regCustomerWeekendDayRate = regCustomerWeekendDayRate;
		this.rewCustomerWeekDayRate = rewCustomerWeekDayRate;
		this.rewCustomerWeekeendDayRate = rewCustomerWeekendDayRate;
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

	public int getRewCustomerWeekDayRate() {
		return rewCustomerWeekDayRate;
	}

	public void setRewCustomerWeekDayRate(int rewCustomerWeekDayRate) {
		this.rewCustomerWeekDayRate = rewCustomerWeekDayRate;
	}

	public int getRewCustomerWeekeendDayRate() {
		return rewCustomerWeekeendDayRate;
	}

	public void setRewCustomerWeekeendDayRate(int rewCustomerWeekeendDayRate) {
		this.rewCustomerWeekeendDayRate = rewCustomerWeekeendDayRate;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", regCustomerWeekDayRate=" + regCustomerWeekDayRate
				+ ", regCustomerWeekendDayRate=" + regCustomerWeekendDayRate + "]";
	}
}

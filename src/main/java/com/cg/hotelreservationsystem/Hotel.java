package com.cg.hotelreservationsystem;

public class Hotel {
	
	private String hotelName;
	private int regCustomerRate;
	
	public Hotel(String hotelName, int regCustomerRate) {
		this.hotelName = hotelName;
		this.regCustomerRate = regCustomerRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegCustomerRate() {
		return regCustomerRate;
	}

	public void setRegCustomerRate(int regCustomerRate) {
		this.regCustomerRate = regCustomerRate;
	}
}

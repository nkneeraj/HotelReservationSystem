package com.cg.hotelreservationsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HotelReservationServices {

	public static ArrayList<Hotel> hotelList = new ArrayList<>();

	public static void AddHotel(String hotelName, int regularCustomerRate) {

		Hotel hotel = new Hotel(hotelName, regularCustomerRate);
		hotelList.add(hotel);
	}

	public Hotel findCheapestHotel(String firstDay, String secondDay) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = sdf.parse(firstDay);
		Date secondDate = sdf.parse(secondDay);
		long noOfDays = noOfDays(firstDate, secondDate);
		System.out.println("No of days: " + noOfDays);
		long min = Long.MAX_VALUE;
		Hotel hotelWithMinRate = null;
		for (Hotel hotel : hotelList) {
			long rate = hotel.getRegCustomerRate();
			if (rate < min) {
				min = rate;
				hotelWithMinRate = hotel;
			}
		}
		System.out.println("Cheapest " + hotelWithMinRate);
		return hotelWithMinRate;
	}

	private long noOfDays(Date firstDate, Date secondDate) {
		return Math.abs(firstDate.getTime() - secondDate.getTime()) / 86400000;
	}
}

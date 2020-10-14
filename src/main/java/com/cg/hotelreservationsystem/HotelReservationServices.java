package com.cg.hotelreservationsystem;

import java.util.ArrayList;

public class HotelReservationServices {

	public static ArrayList<Hotel> hotelList = new ArrayList<>();
	public static void AddHotel(String hotelName, int regularCustomerRate) {

		Hotel hotel = new Hotel(hotelName,regularCustomerRate);
		hotelList.add(hotel);
	}
}

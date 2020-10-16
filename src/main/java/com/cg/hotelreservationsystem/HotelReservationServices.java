package com.cg.hotelreservationsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.NoSuchElementException;

public class HotelReservationServices {

	public static ArrayList<Hotel> hotelList = new ArrayList<>();

	public static void AddHotel(String hotelName, int regularCustomerRate, int regCustomerWeekendRate, int rewCustomerWeekRate,
			int rewCustomerWeekendRate, int rating) {

		Hotel hotel = new Hotel(hotelName, regularCustomerRate, regCustomerWeekendRate,rewCustomerWeekRate,rewCustomerWeekendRate, rating);
		hotelList.add(hotel);
	}

	public Hotel findCheapestHotel(String firstDay, String secondDay) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = sdf.parse(firstDay);
		Date secondDate = sdf.parse(secondDay);
		long totalDays = totalDays(firstDate, secondDate)+1;
		long weekendDays = weekendDate(firstDate, secondDate);
		long weekDays = totalDays - weekendDays;
		System.out.println("No of days: " + totalDays+ "\nWeek days: "+weekDays+"\nno of weekends: "+ weekendDays );
		long min = Long.MAX_VALUE;
		Hotel hotelWithMinRate = null;
		for (Hotel hotel : hotelList) {
			long rate = hotel.getRegCustomerRate()*weekDays+hotel.getRegCustomerWeekendDayRate()*weekendDays;
			System.out.println("Hotel Name: "+hotel.getHotelName()+ "Total rate: " + rate);
			if (rate < min) {
				min = rate;
				hotelWithMinRate = hotel;
			}
		}
		long x = min;
		List<Hotel> hotelName = new ArrayList<>();
		hotelList.stream().filter(n -> {if((n.getRegCustomerRate()*weekDays+n.getRegCustomerWeekendDayRate()*weekendDays)==x) {return true;} 
		return false;}).forEach(n -> hotelName.add(n));
		return hotelWithMinRate;
	}
	
	//UC12
	public Hotel findCheapestBestRatedHotel(String firstDay, String secondDay) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		Date firstDate = sdf.parse(firstDay);
		Date secondDate = sdf.parse(secondDay);
		long totalDays = totalDays(firstDate, secondDate)+1;
		long weekendDays = weekendDate(firstDate, secondDate);
		long weekDays = totalDays - weekendDays;
		System.out.println("No of days: " + totalDays+ "\nWeek days: "+weekDays+"\nno of weekends: "+ weekendDays );
		long min = Long.MAX_VALUE;
		Hotel hotelWithMinRate = null;
		for (Hotel hotel : hotelList) {
			long rate = hotel.getRegCustomerRate()*weekDays+hotel.getRegCustomerWeekendDayRate()*weekendDays;
			System.out.println("Hotel Name: "+hotel.getHotelName()+ "Total rate: " + rate);
			if (rate < min) {
				min = rate;
				hotelWithMinRate = hotel;
			}
		}
		long x = min;
		List<Hotel> cheapestHotelList = new ArrayList<>();
		hotelList.stream().filter(n -> {if((n.getRegCustomerRate()*weekDays+n.getRegCustomerWeekendDayRate()*weekendDays)==x) {return true;} 
		return false;}).forEach(n -> cheapestHotelList.add(n));
		
		Hotel hotel = cheapestHotelList.stream().max(Comparator.comparing(Hotel::getRating)).
				orElseThrow(NoSuchElementException::new);
		System.out.println("Cheapest Hotel with best rating: "+ hotel.getHotelName());
		return hotelWithMinRate;
		}
		catch(Exception x) {
			System.out.println(x.getMessage());
		}
		return null;
	}
	
	//UC7
	public Hotel findBestRatedHotel(String firstDay, String secondDay) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = sdf.parse(firstDay);
		Date secondDate = sdf.parse(secondDay);
		long totalDays = totalDays(firstDate, secondDate)+1;
		long weekendDays = weekendDate(firstDate, secondDate);
		long weekDays = totalDays - weekendDays;
		System.out.println("No of days: " + totalDays+ "\nWeek days: "+weekDays+"\nno of weekends: "+ weekendDays );
		

		Hotel hotel = hotelList.stream().max(Comparator.comparing(Hotel::getRating)).
				orElseThrow(NoSuchElementException::new);
	
		long rate = hotel.getRegCustomerRate()*weekDays+hotel.getRegCustomerWeekendDayRate()*weekendDays;
		System.out.println("Hotel with best rating: "+ hotel.getHotelName()+ " Total rate: "+rate);
		return hotel;
	}
	
	//UC10 && UC11
	public Hotel findCheapestBestRatedHotelForRewardCust(String firstDay, String secondDay) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		Date firstDate = sdf.parse(firstDay);
		Date secondDate = sdf.parse(secondDay);
		long totalDays = totalDays(firstDate, secondDate)+1;
		long weekendDays = weekendDate(firstDate, secondDate);
		long weekDays = totalDays - weekendDays;
		System.out.println("No of days: " + totalDays+ "\nWeek days: "+weekDays+"\nno of weekends: "+ weekendDays );
		long min = Long.MAX_VALUE;
		Hotel hotelWithMinRate = null;
		for (Hotel hotel : hotelList) {
			long rate = hotel.getRewCustomerWeekDayRate()*weekDays+hotel.getRewCustomerWeekeendDayRate()*weekendDays;
			System.out.println("Hotel Name: "+hotel.getHotelName()+ "Total rate: " + rate);
			if (rate < min) {
				min = rate;
				hotelWithMinRate = hotel;
			}
		}
		long x = min;
		List<Hotel> cheapestHotelList = new ArrayList<>();
		hotelList.stream().filter(n -> {if((n.getRewCustomerWeekDayRate()*weekDays+n.getRewCustomerWeekeendDayRate()*weekendDays)==x) {return true;} 
		return false;}).forEach(n -> cheapestHotelList.add(n));
		
		Hotel hotel = cheapestHotelList.stream().max(Comparator.comparing(Hotel::getRating)).
				orElseThrow(NoSuchElementException::new);
		System.out.println("Cheapest Hotel with best rating: "+ hotel.getHotelName());
		return hotelWithMinRate;
		}
		catch(Exception x) {
			System.out.println(x.getMessage());
		}
		return null;		
	}

	private long totalDays(Date firstDate, Date secondDate) {
		return Math.abs(firstDate.getTime() - secondDate.getTime()) / 86400000;
	}

	private long weekendDate(Date firstDate, Date secondDate) {
		if(firstDate.after(secondDate)) {
			Date temp = secondDate;
			secondDate = firstDate;
			firstDate = temp;
		}
		long count =0;
		while(firstDate.before(secondDate) || firstDate.equals(secondDate)) {
			if(firstDate.getDay() == 0 || firstDate.getDay() == 6) {
				count++;
			}
			firstDate  = new Date(firstDate.getTime() + 86400000);
			}
		return count;
	}

	public void showHotelDetails() {
		for (Hotel hotel : hotelList) {
			System.out.println(hotel);
		}
	}
}

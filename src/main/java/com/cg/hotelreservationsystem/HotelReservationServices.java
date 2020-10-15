package com.cg.hotelreservationsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HotelReservationServices {

	public static ArrayList<Hotel> hotelList = new ArrayList<>();

	public static void AddHotel(String hotelName, int regularCustomerRate, int regCustomerWeekendRate, int rating) {

		Hotel hotel = new Hotel(hotelName, regularCustomerRate,regCustomerWeekendRate, rating);
		hotelList.add(hotel);
	}

	public Hotel findCheapestHotel(String firstDay, String secondDay) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = sdf.parse(firstDay);
		Date secondDate = sdf.parse(secondDay);
		long totalDays = totalDays(firstDate, secondDate)+1;
		long weekDays = weekDays(firstDate, secondDate);
		long weekendDays = totalDays-weekDays;
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
		System.out.println("Cheapest " + hotelWithMinRate);
		return hotelWithMinRate;
	}

	private long totalDays(Date firstDate, Date secondDate) {
		return Math.abs(firstDate.getTime() - secondDate.getTime()) / 86400000;
	}
	
	static long weekDays(Date start, Date end){
	    //Ignore argument check

	    Calendar c1 = GregorianCalendar.getInstance();
	    c1.setTime(start);
	    int w1 = c1.get(Calendar.DAY_OF_WEEK);
	    c1.add(Calendar.DAY_OF_WEEK, -w1 + 1);

	    Calendar c2 = GregorianCalendar.getInstance();
	    c2.setTime(end);
	    int w2 = c2.get(Calendar.DAY_OF_WEEK);
	    c2.add(Calendar.DAY_OF_WEEK, -w2 + 1);

	    //end Saturday to start Saturday 
	    long days = (c2.getTimeInMillis()-c1.getTimeInMillis())/(1000*60*60*24);
	    long daysWithoutSunday = days-(days*2/7);

	    if (w1 == Calendar.SUNDAY) {
	        w1 = Calendar.MONDAY;
	    }
	    if (w2 == Calendar.SUNDAY) {
	        w2 = Calendar.MONDAY;
	    }
	    return daysWithoutSunday-w1+w2;
	}
//	public static int checkWeekDay(Date date)
//	Calendar startDate = Calendar.getInstance();
//	startDate.set(2012, Calendar.DECEMBER, 02);
//	if (startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
//	    System.out.println("true");
//	} else {
//	    System.out.println("FALSE");
//	}

	public void showHotelDetails() {
		for(Hotel hotel: hotelList)
		{
			System.out.println(hotel);
		}
		
	}
}

package com.cg.hotelreservationsystem;

import java.text.ParseException;
import java.util.Scanner;

public class HotelReservation {
	private static Scanner sc = new Scanner(System.in);
	static int option = 0;
	public static void main(String[] args) throws ParseException {	
		
		HotelReservationServices.AddHotel("RidgeWood", 220,90, 5 );
		HotelReservationServices.AddHotel("BridgeWood", 150,50,4);
		HotelReservationServices.AddHotel("LakeWood" , 110,90,3);
		HotelReservationServices hotelServices = new HotelReservationServices();
			
		options();
		while(option!=10)
		{
			if(option==1) {
				hotelServices.showHotelDetails();	
			}	
			if(option==2) {
				System.out.println("Enter date one day before first day in 'yyyy-MM-dd'");
				String firstDay = sc.nextLine();
				System.out.println("Enter date on day before second day in 'yyyy-MM-dd'");
				String secondDay = sc.nextLine();
				hotelServices.findCheapestHotel(firstDay,secondDay);		
			}
			options();
		}
	}	
	public static void options()
	{
		System.out.println("Enter options:");
		System.out.println("Enter 1.Show Hotel details");
		System.out.println("Enter 2.Find cheapest hotel.");
		System.out.println("10.Exit");
		option = sc.nextInt();sc.nextLine();
	}
}

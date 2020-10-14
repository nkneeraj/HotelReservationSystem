package com.cg.hotelreservationsystem;

import java.util.Scanner;

public class HotelReservation {
	private static Scanner sc = new Scanner(System.in);
	static int option = 0;
	public static void main(String[] args) {	
		
		HotelReservationServices.AddHotel("RidgeWood", 220);
		HotelReservationServices.AddHotel("BridgeWood", 150);
		HotelReservationServices.AddHotel("LakeWood" , 110);
			
		options();
		while(option!=2)
		{
			if(option==1) {
				System.out.println("Enter Hotel Name");
				String hotelName = sc.nextLine();
				System.out.println("Enter Hotel Regular Customer rate.");
				int regularCustomerRate = sc.nextInt();
				HotelReservationServices.AddHotel(hotelName, regularCustomerRate);	
			}	
			options();
		}
	}	
	public static void options()
	{
		System.out.println("Enter options:");
		System.out.println("1.Add a new Hotel");
		System.out.println("2.Exit");
		option = sc.nextInt();
		
	}
}

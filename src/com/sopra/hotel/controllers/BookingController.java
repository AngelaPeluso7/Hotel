package com.sopra.hotel.controllers;

import java.util.ArrayList;
import java.util.List;

import com.sopra.hotel.data.BookingData;
import com.sopra.hotel.facades.BookingFacade;
import com.sopra.hotel.models.BookingModel;

public class BookingController {
	
	private BookingFacade bookingFacade;
	
	public String newReservation(BookingModel bookingModel){
		String print;
		if(bookingFacade.newReservation(bookingModel)){
			print="SUCCESS!!! The new reservation was made";
		}
		else print="ERRORR!!! The new reservation has NOT been made";
		return print;
	}
	
	public String viewAllReservation(){
		List<BookingData> reservationsList=bookingFacade.viewAllReservation();
		
		ArrayList<String> reservationsListPrint = new ArrayList<String>();
		for (BookingData b: reservationsList){
			reservationsListPrint.add(b.toString());
		}
		String print = "";
		for (String s : reservationsListPrint)
		{
		    print += s + "\t";
		}
		return print;
	}
}

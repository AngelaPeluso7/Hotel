package com.sopra.hotel.controllers;

import java.util.ArrayList;
import java.util.List;

import com.sopra.hotel.data.BookingData;
import com.sopra.hotel.facades.BookingFacade;
import com.sopra.hotel.facades.impl.DefaultBookingFacade;

public class BookingController {
	
	private BookingFacade bookingFacade;
	
	public BookingController() {
		this.bookingFacade=new DefaultBookingFacade();
	}

	public boolean newBooking(BookingData bookingData){
		Boolean added=false;
		if(bookingFacade.newBooking(bookingData)){
			added=true;
		}
		return added;
//			print="SUCCESS!!! The new reservation was made";
//		}
//		else print="ERRORR!!! The new reservation has NOT been made";
//		return print;
	}
	
	public String showAll(){
		List<BookingData> reservationsList=bookingFacade.getAll();
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
	
	public List<BookingData> getAll(){
		return bookingFacade.getAll();
	}

	public String viewById(int idBooking){
		BookingData reservation=bookingFacade.getById(idBooking);
		String print =reservation.toString();
		return print;
	}
	public BookingData getById(int idBooking){
		BookingData bookingData=bookingFacade.getById(idBooking);
		return bookingData;
	}
	
	public boolean checkIn(int roomNumber,String checkInDate){
		return bookingFacade.checkIn(roomNumber, checkInDate);
	}
	
	public boolean checkOut(int roomNumber,String checkOutDate){
		return bookingFacade.checkOut(roomNumber, checkOutDate);
	}
}

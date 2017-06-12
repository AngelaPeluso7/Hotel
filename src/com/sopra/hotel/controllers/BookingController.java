package com.sopra.hotel.controllers;

import java.util.ArrayList;
import java.util.List;

import com.sopra.hotel.data.BookingData;
import com.sopra.hotel.facades.BookingFacade;
import com.sopra.hotel.models.BookingModel;

public class BookingController {
	
	private BookingFacade bookingFacade;
	private BookingModel bookingModel;
	private BookingData bookingData;
	
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

	public String getBooking(int id){
		BookingData reservation=bookingFacade.getBooking(id);
		String print =reservation.toString();
		return print;
	}
	
	public int getLastId(){
		return bookingFacade.getLastId();
	}
	
	public BookingModel getBookingModel() {
        return bookingModel;
    }

    public void setBookingModel(BookingModel bookingModel) {
        this.bookingModel = bookingModel;
    }
    public BookingData getBookingData() {
        return bookingData;
    }

    public void setBookingModel(BookingData bookingData) {
        this.bookingData = bookingData;
    }
}

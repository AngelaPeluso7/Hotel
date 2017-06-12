package com.sopra.hotel.services.impl;

import java.util.List;

import com.sopra.hotel.DAO.BookingDAO;
import com.sopra.hotel.models.BookingModel;
import com.sopra.hotel.services.BookingService;

public class DefaultBookingService implements BookingService {

	private BookingDAO bookingDAO;
	
	public boolean newReservation(BookingModel bookingModel){
		return bookingDAO.newReservation(bookingModel);
	}
	
	public List<BookingModel> viewAllReservation(){
		return bookingDAO.viewAllReservation();
	}
	
	public BookingModel getBooking(int id){
		return bookingDAO.getBooking(id);
	}
	
	public int getLastId(){
		return bookingDAO.getLastId();
	}
}

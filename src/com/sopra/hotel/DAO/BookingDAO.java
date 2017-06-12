package com.sopra.hotel.DAO;

import java.util.List;

import com.sopra.hotel.models.BookingModel;

public interface BookingDAO {

	public boolean newReservation(BookingModel bookingModel);
	
	public List<BookingModel> viewAllReservation();
	
	public BookingModel getBooking(int id);
	
	public int getLastId();
}

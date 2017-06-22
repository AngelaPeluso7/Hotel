package com.sopra.hotel.services;

import java.util.Date;
import java.util.List;

import com.sopra.hotel.models.BookingModel;

public interface BookingService {
	
	public boolean newBooking(BookingModel bookingModel);
	
	public List<BookingModel> getAll();
	
	public BookingModel getById(int idBooking);
	
	public boolean checkIn(int roomNumber,Date checkInDate);
	
	public boolean checkOut(int roomNumber,Date checkOutDate);
}

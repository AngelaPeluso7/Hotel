package com.sopra.hotel.services;

import java.util.List;

import com.sopra.hotel.models.BookingModel;

public interface BookingService {
	
	public boolean newReservation(BookingModel bookingModel);
	
	public List<BookingModel> viewAllReservation();
}

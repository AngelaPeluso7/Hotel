package com.sopra.hotel.facades;

import java.util.List;

import com.sopra.hotel.models.BookingModel;

public interface BookingFacade {
	
	public boolean newReservation(BookingModel bookingModel);
	
	public List<BookingModel> viewAllReservation();
}

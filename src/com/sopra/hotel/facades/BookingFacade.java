package com.sopra.hotel.facades;

import java.util.List;

import com.sopra.hotel.data.BookingData;
import com.sopra.hotel.models.BookingModel;

public interface BookingFacade {
	
	public boolean newReservation(BookingModel bookingModel);
	
	public List<BookingData> viewAllReservation();
}

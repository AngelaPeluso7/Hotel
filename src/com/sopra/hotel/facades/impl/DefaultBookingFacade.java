package com.sopra.hotel.facades.impl;

import java.util.List;

import com.sopra.hotel.facades.BookingFacade;
import com.sopra.hotel.models.BookingModel;
import com.sopra.hotel.services.BookingService;

public class DefaultBookingFacade implements BookingFacade {

	private BookingService bookingService;
	
	public boolean newReservation(BookingModel bookingModel) {
		return bookingService.newReservation(bookingModel);
	}

	public List<BookingModel> viewAllReservation() {
		return bookingService.viewAllReservation();
	}

}

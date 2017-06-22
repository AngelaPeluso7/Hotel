package com.sopra.hotel.facades;

import java.util.List;

import com.sopra.hotel.data.BookingData;

public interface BookingFacade {
	
	public boolean newBooking(BookingData bookingData);
	
	public List<BookingData> getAll();
	
	public BookingData getById(int idBooking);
	
	public boolean checkIn(int roomNumber,String checkInDate);
	
	public boolean checkOut(int roomNumber,String checkOutDate);
}

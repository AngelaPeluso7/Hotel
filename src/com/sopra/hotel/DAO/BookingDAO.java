package com.sopra.hotel.DAO;

import java.util.Date;
import java.util.List;

import com.sopra.hotel.models.BookingModel;

public interface BookingDAO {

	public boolean newBooking(BookingModel bookingModel);
	
	public List<BookingModel> findAll();
	
	public BookingModel findById(int idBooking);
	
	public boolean checkIn(int roomNumber,Date checkInDate);
	
	public boolean checkOut(int roomNumber,Date checkOutDate);
}

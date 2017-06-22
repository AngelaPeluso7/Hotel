package com.sopra.hotel.services.impl;

import java.util.Date;
import java.util.List;

import com.sopra.hotel.DAO.BookingDAO;
import com.sopra.hotel.DAO.impl.DefaultBookingDAO;
import com.sopra.hotel.models.BookingModel;
import com.sopra.hotel.services.BookingService;

public class DefaultBookingService implements BookingService {

	private BookingDAO bookingDAO;
	
	public DefaultBookingService(){
		this.bookingDAO=new DefaultBookingDAO();
	}
	
	public boolean newBooking(BookingModel bookingModel){
		return bookingDAO.newBooking(bookingModel);
	}
	
	public List<BookingModel> getAll(){
		return bookingDAO.findAll();
	}
	
	public BookingModel getById(int idBooking){
		return bookingDAO.findById(idBooking);
	}

	public BookingDAO getBookingDAO() {
		return bookingDAO;
	}

	public void setBookingDAO(BookingDAO bookingDAO) {
		this.bookingDAO = bookingDAO;
	}
	public boolean checkIn(int roomNumber,Date checkInDate){
		return bookingDAO.checkIn(roomNumber, checkInDate);
	}
	
	public boolean checkOut(int roomNumber,Date checkOutDate){
		return bookingDAO.checkOut(roomNumber, checkOutDate);
	}
	
}

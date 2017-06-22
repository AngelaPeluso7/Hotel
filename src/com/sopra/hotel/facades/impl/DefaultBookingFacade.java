package com.sopra.hotel.facades.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.sopra.hotel.data.BookingData;
import com.sopra.hotel.facades.BookingFacade;
import com.sopra.hotel.models.BookingModel;
import com.sopra.hotel.services.BookingService;
import com.sopra.hotel.services.impl.DefaultBookingService;


public class DefaultBookingFacade implements BookingFacade {
	private BookingService bookingService;
	
	public DefaultBookingFacade(){
		this.bookingService=new DefaultBookingService();
	}
	public boolean newBooking(BookingData bookingData) {
		BookingModel bookingModel=new BookingModel();
		bookingModel.setId(bookingData.getIdBooking());
		bookingModel.setIdRoom(bookingData.getIdRoom());
		bookingModel.setIdClient(bookingModel.getIdClient());
		bookingModel.setPeopleNumber(bookingData.getPeopleNumber());
		bookingModel.setStartDate(Date.valueOf(bookingData.getStartDate()));
		bookingModel.setEndDate(Date.valueOf(bookingData.getStartDate()));
		bookingModel.setNightNumber(bookingData.getNightNumber());
		bookingModel.setTotalPrice(bookingData.getTotalPrice());
		bookingModel.setDeposit(bookingData.getDeposit());
		bookingModel.setCheckInDate(Date.valueOf(bookingData.getCheckInDate()));
		bookingModel.setCheckOutDate(Date.valueOf(bookingData.getCheckOutDate()));
		return bookingService.newBooking(bookingModel);
	}

	public List<BookingData> getAll() {
		List<BookingModel> bookingsModel = bookingService.getAll();
        final List<BookingData> bookingsData = new ArrayList<BookingData>();
        for (final BookingModel booking : bookingsModel) {
            final BookingData bookingData = new BookingData();
            bookingData.setIdBooking(booking.getIdBooking());
            bookingData.setIdRoom(booking.getIdRoom());
            bookingData.setIdClient(booking.getIdClient());
            bookingData.setPeopleNumber(booking.getPeopleNumber());
            bookingData.setStartDate(booking.getStartDate().toString());
            bookingData.setEndDate(booking.getEndDate().toString());
            bookingData.setNightNumber(booking.getNightNumber());
            bookingData.setTotalPrice(booking.getTotalPrice());
            bookingData.setDeposit(booking.getDeposit());
            if(booking.getCheckInDate()==null){
            	bookingData.setCheckInDate("0000-00-00");
            }
            else{
            	bookingData.setCheckInDate(booking.getCheckInDate().toString());
            }
            if(booking.getCheckOutDate()==null){
            	bookingData.setCheckOutDate("0000-00-00");
            }
            else{
            	bookingData.setCheckOutDate(booking.getCheckOutDate().toString());
            }
            bookingsData.add(bookingData);
        }
        return bookingsData;
	}
	public BookingData getById(int idBooking){
		BookingModel bookingModel=bookingService.getById(idBooking);
            BookingData bookingData = new BookingData();
            bookingData.setIdBooking(idBooking);
            bookingData.setIdRoom(bookingModel.getIdRoom());
            bookingData.setIdClient(bookingModel.getIdClient());
            bookingData.setPeopleNumber(bookingModel.getPeopleNumber());
            bookingData.setStartDate(bookingModel.getStartDate().toString());
            bookingData.setEndDate(bookingModel.getEndDate().toString());
            bookingData.setNightNumber(bookingModel.getNightNumber());
            bookingData.setTotalPrice(bookingModel.getTotalPrice());
            bookingData.setDeposit(bookingModel.getDeposit());
            bookingData.setCheckInDate(bookingModel.getCheckInDate().toString());
            bookingData.setCheckOutDate(bookingModel.getCheckOutDate().toString());
        return bookingData;
	}
	public boolean checkIn(int roomNumber,String checkInDate){
		return bookingService.checkIn(roomNumber, Date.valueOf(checkInDate));
	}
	
	public boolean checkOut(int roomNumber,String checkOutDate){
		return bookingService.checkOut(roomNumber, Date.valueOf(checkOutDate));
	}
}

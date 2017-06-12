package com.sopra.hotel.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.sopra.hotel.data.BookingData;
import com.sopra.hotel.facades.BookingFacade;
import com.sopra.hotel.models.BookingModel;
import com.sopra.hotel.services.BookingService;


public class DefaultBookingFacade implements BookingFacade {

	private BookingService bookingService;
	
	public boolean newReservation(BookingModel bookingModel) {
		boolean result= false;
		if (bookingModel != null)
		{
			result = bookingService.newReservation(bookingModel);
		}
		else
		{
			throw new IllegalArgumentException("Reservation not found.");
		}
		return result;
	}

	public List<BookingData> viewAllReservation() {
		List<BookingModel> reservationsModel = bookingService.viewAllReservation();
        final List<BookingData> reservationsData = new ArrayList<BookingData>();
        for (final BookingModel reservation : reservationsModel) {
            final BookingData reservationData = new BookingData();
            reservationData.setId(reservation.getId());
            reservationData.setRoom(reservation.getRoom());
            reservationData.setClient(reservation.getClient());
            reservationData.setPeopleNumber(reservation.getPeopleNumber());
            reservationData.setStartDate(reservation.getStartDate());
            reservationData.setEndDate(reservation.getEndDate());
            reservationData.setNightNumber(reservation.getNightNumber());
            reservationData.setTotalPrice(reservation.getTotalPrice());
            reservationData.setDeposit(reservation.getDeposit());
            reservationData.setCheckInDate(reservation.getCheckInDate());
            reservationData.setCheckOutDate(reservation.getCheckOutDate());
            reservationsData.add(reservationData);
        }
        return reservationsData;
	}
	public BookingData getBooking(int id){
		BookingModel reservation = bookingService.getBooking(id);
        final BookingData reservationData = new BookingData();
            reservationData.setId(reservation.getId());
            reservationData.setRoom(reservation.getRoom());
            reservationData.setClient(reservation.getClient());
            reservationData.setPeopleNumber(reservation.getPeopleNumber());
            reservationData.setStartDate(reservation.getStartDate());
            reservationData.setEndDate(reservation.getEndDate());
            reservationData.setNightNumber(reservation.getNightNumber());
            reservationData.setTotalPrice(reservation.getTotalPrice());
            reservationData.setDeposit(reservation.getDeposit());
            reservationData.setCheckInDate(reservation.getCheckInDate());
            reservationData.setCheckOutDate(reservation.getCheckOutDate());
        return reservationData;
	}
	
	public int getLastId(){
		return bookingService.getLastId();
	}
	
	//TODO public RoomData getRoom(RoomModel room)
	
	//TODO public ClientData getRoom(ClientModel client)
}

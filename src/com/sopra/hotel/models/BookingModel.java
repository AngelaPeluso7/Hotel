package com.sopra.hotel.models;

import java.sql.Date;
import com.sopra.hotel.models.BookingModel;

public class BookingModel {
	private int idBooking;
	private int idRoom;
	private int idClient;
	private int peopleNumber;
	private Date startDate;
	private Date endDate;
	private int nightNumber;
	private Double totalPrice;
	private Double deposit;
	private Date checkInDate;
	private Date checkOutDate;

	public BookingModel(int idBooking, int idRoom, int idClient, int peopleNumber, Date startDate, Date endDate,
			int nightNumber, Double totalPrice, Double deposit, Date checkInDate, Date checkOutDate) {
		this.idBooking = idBooking;
		this.idRoom = idRoom;
		this.idClient = idClient;
		this.peopleNumber = peopleNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.nightNumber = nightNumber;
		this.totalPrice = totalPrice;
		this.deposit = deposit;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public BookingModel() {
	}

	public int getIdBooking() {
		return idBooking;
	}

	public void setId(int idBooking) {
		this.idBooking = idBooking;
	}

//	public RoomModel getRoom() {
//		if (room == null) {
//			room = new RoomDAO().findbyPK(roomId);
//		}
//		return room;
//	}

//	public ClientModel getClient() {
//		if (client == null) {
//			client = new ClientDAO().findbyPK(clientId);
//		}
//		return client;
//	}

	public int getPeopleNumber() {
		return peopleNumber;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getNightNumber() {
		return nightNumber;
	}

	public void setNightNumber(int nightNumber) {
		this.nightNumber = nightNumber;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "BookingModel [idBooking=" + idBooking + ", idRoom=" + idRoom + ", idClient=" + idClient
				+ ", peopleNumber=" + peopleNumber + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", nightNumber=" + nightNumber + ", totalPrice=" + totalPrice + ", deposit=" + deposit
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}
}

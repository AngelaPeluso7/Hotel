package com.sopra.hotel.models;

import java.sql.Date;

import com.sopra.hotel.models.BookingModel;

public class BookingModel {
	int id;
    RoomModel room;
	ClientModel client;
	int peopleNumber;
	Date startDate,endDate;
    int nightNumber;
    Double totalPrice,deposit;
    Date checkInDate,checkOutDate;
    
	public BookingModel(int id, RoomModel room, ClientModel client, int peopleNumber, Date startDate, Date endDate,
			int nightNumber, Double totalPrice, Double deposit, Date checkInDate, Date checkOutDate) {
		super();
		this.id = id;
		this.room = room;
		this.client = client;
		this.peopleNumber = peopleNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.nightNumber = nightNumber;
		this.totalPrice = totalPrice;
		this.deposit = deposit;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoomModel getRoom() {
		return room;
	}

	public void setRoom(RoomModel room) {
		this.room = room;
	}

	public ClientModel getClient() {
		return client;
	}

	public void setClient(ClientModel client) {
		this.client = client;
	}

	public int getPeopleNumber() {
		return peopleNumber;
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
		return "BookingModel [id=" + id + ", room=" + room + ", client=" + client + ", peopleNumber=" + peopleNumber
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", nightNumber=" + nightNumber + ", totalPrice="
				+ totalPrice + ", deposit=" + deposit + ", checkInDate=" + checkInDate + ", checkOutDate="
				+ checkOutDate + "]";
	}
    
    
}

package com.sopra.hotel.data;

public class BookingData {
	private int idBooking;
	private int idRoom;
	private int idClient;
	private int peopleNumber;
	private String startDate;
	private String endDate;
	private int nightNumber;
	private Double totalPrice;
	private Double deposit;
	private String checkInDate;
	private String checkOutDate;
	
	public BookingData(int idBooking, int idRoom, int idClient, int peopleNumber, String startDate, String endDate,
			int nightNumber, Double totalPrice, Double deposit, String checkInDate, String checkOutDate) {
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

	public BookingData() {
	}

	public int getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
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

	public int getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "BookingData [idBooking=" + idBooking + ", idRoom=" + idRoom + ", idClient=" + idClient
				+ ", peopleNumber=" + peopleNumber + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", nightNumber=" + nightNumber + ", totalPrice=" + totalPrice + ", deposit=" + deposit
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}
	
}

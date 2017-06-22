package com.sopra.hotel.data;

public class RoomData {
	int idRoom;
	int number;
	int idType;
	String actualState;
	
	public RoomData(int idRoom, int number, int idType, String actualState) {
		this.idRoom = idRoom;
		this.number = number;
		this.idType = idType;
		this.actualState = actualState;
	}
	public RoomData() {
	}
	
	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getActualState() {
		return actualState;
	}

	public void setActualState(String actualState) {
		this.actualState = actualState;
	}
	
	@Override
	public String toString() {
		return "RoomData [idRoom=" + idRoom + ", number=" + number + ", idType=" + idType + ", actualState="
				+ actualState + "]";
	}
	
}

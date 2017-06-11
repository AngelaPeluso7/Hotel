package com.sopra.hotel.data;

import com.sopra.hotel.models.ActualState;
import com.sopra.hotel.models.Typology;

public class RoomData {
	int number;
	Typology typeRoom;
	ActualState actualState;
	
	public RoomData(int number, Typology typeRoom, ActualState actualState) {
		super();
		this.number = number;
		this.typeRoom = typeRoom;
		this.actualState = actualState;
	}

	public RoomData() {
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Typology getTypeRoom() {
		return typeRoom;
	}

	public void setTypeRoom(Typology typeRoom) {
		this.typeRoom = typeRoom;
	}

	public ActualState getActualState() {
		return actualState;
	}

	public void setActualState(ActualState actualState) {
		this.actualState = actualState;
	}

	@Override
	public String toString() {
		return "RoomData [number=" + number + ", typeRoom=" + typeRoom + ", actualState=" + actualState + "]";
	}
	
	
}

package com.sopra.hotel.models;
import com.sopra.hotel.models.RoomModel;

public class RoomModel {
	int number;
	Typology typeRoom;
	ActualState actualState;
	
	public RoomModel(int number, Typology typeRoom, ActualState actualState) {
		super();
		this.number = number;
		this.typeRoom = typeRoom;
		this.actualState = actualState;
	}
	public RoomModel() {
	}
	
	public RoomModel(int number) {
		this.number = number;
	}

	public RoomModel(int number, Typology typeRoom) {
		this.number = number;
		this.typeRoom = typeRoom;
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
		return "RoomModel [number=" + number + ", typeRoom=" + typeRoom + ", actualState=" + actualState + "]";
	}
	
	
}

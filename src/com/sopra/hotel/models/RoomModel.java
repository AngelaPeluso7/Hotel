package com.sopra.hotel.models;
import com.sopra.hotel.models.RoomModel;

public class RoomModel {
	int number;
	TypeRoomModel typeRoom;
	ActualState actualState;
	
	public RoomModel(int number, TypeRoomModel typeRoom, ActualState actualState) {
		super();
		this.number = number;
		this.typeRoom = typeRoom;
		this.actualState = actualState;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public TypeRoomModel getTypeRoom() {
		return typeRoom;
	}

	public void setTypeRoom(TypeRoomModel typeRoom) {
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

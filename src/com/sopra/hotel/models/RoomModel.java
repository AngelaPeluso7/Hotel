package com.sopra.hotel.models;
import com.sopra.hotel.models.RoomModel;

public class RoomModel {
	int idRoom;
	int number;
	int idType;
	ActualState actualState;
	
	public RoomModel(int idRoom, int number, Typology typeRoom, ActualState actualState, int idType) {
		this.idRoom = idRoom;
		this.number = number;
		this.idType = idType;
		this.actualState = actualState;
	}
	public RoomModel() {
	}
	
	public RoomModel(int number) {
		this.number = number;
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
	public ActualState getActualState() {
		return actualState;
	}
	public void setActualState(ActualState actualState) {
		this.actualState = actualState;
	}
	@Override
	public String toString() {
		return "RoomModel [idRoom=" + idRoom + ", number=" + number + ", idType=" + idType + ", actualState="
				+ actualState + "]";
	}
}

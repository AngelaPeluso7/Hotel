package com.sopra.hotel.models;

import com.sopra.hotel.models.TypeRoomModel;

public class TypeRoomModel {
	int idTypeRoom;
	Typology typology;
	double price;
		
	public TypeRoomModel(int idTypeRoom, Typology typology, double price) {
		this.idTypeRoom = idTypeRoom;
		this.typology = typology;
		this.price = price;
	}
	public TypeRoomModel() {
	}
	
	public int getIdTypeRoom() {
		return idTypeRoom;
	}
	public void setIdTypeRoom(int idTypeRoom) {
		this.idTypeRoom = idTypeRoom;
	}
	public Typology getTypology() {
		return typology;
	}
	public void setTypology(Typology typology) {
		this.typology = typology;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "TypeRoomModel [idTypeRoom=" + idTypeRoom + ", typology=" + typology + ", price=" + price + "]";
	}
	
}

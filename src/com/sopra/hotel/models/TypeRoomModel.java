package com.sopra.hotel.models;

import com.sopra.hotel.models.TypeRoomModel;

public class TypeRoomModel {
	Typology typology;
	double price;
	
	public TypeRoomModel(Typology typology, double price) {
		super();
		this.typology = typology;
		this.price = price;
	}
	public TypeRoomModel() {
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
		return "TypeRoomModel [typology=" + typology + ", price=" + price + "]";
	}
}

package com.sopra.hotel.data;

import com.sopra.hotel.models.Typology;

public class TypeRoomData {
	Typology typology;
	double price;
		
	public TypeRoomData(Typology typology, double price) {
		super();
		this.typology = typology;
		this.price = price;
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
		return "TypeRoomData [typology=" + typology + ", price=" + price + "]";
	}
	
}

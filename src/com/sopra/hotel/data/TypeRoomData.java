package com.sopra.hotel.data;

public class TypeRoomData {
	int idTypeRoom;
	String typology;
	double price;
	
	public TypeRoomData(int idTypeRoom, String typology, double price) {
		this.idTypeRoom = idTypeRoom;
		this.typology = typology;
		this.price = price;
	}

	public TypeRoomData() {
	}

	public int getIdTypeRoom() {
		return idTypeRoom;
	}

	public void setIdTypeRoom(int idTypeRoom) {
		this.idTypeRoom = idTypeRoom;
	}

	public String getTypology() {
		return typology;
	}

	public void setTypology(String typology) {
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
		return "TypeRoomData [idTypeRoom=" + idTypeRoom + ", typology=" + typology + ", price=" + price + "]";
	}
	
}

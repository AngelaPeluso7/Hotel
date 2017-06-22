package com.sopra.hotel.facades;

import java.util.List;

import com.sopra.hotel.data.TypeRoomData;

public interface TypeRoomFacade {
	
	public double getPrice(String typology);
	
	public boolean updateNewPrice(String typology, double newPrice);	
	
	public List<TypeRoomData> getAll();
	
	public TypeRoomData getById(int idTypeRoom);
}

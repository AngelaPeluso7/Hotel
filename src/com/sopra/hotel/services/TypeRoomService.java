package com.sopra.hotel.services;

import java.util.List;

import com.sopra.hotel.models.TypeRoomModel;
import com.sopra.hotel.models.Typology;

public interface TypeRoomService {
	
	public double getPrice(Typology typology);
	
	public boolean updateNewPrice(Typology typology, double newPrice);
	
	public List<TypeRoomModel> getAll();
	
	public TypeRoomModel getById(int idTypeRoom);
}

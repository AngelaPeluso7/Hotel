package com.sopra.hotel.services.impl;

import com.sopra.hotel.DAO.TypeRoomDAO;
import com.sopra.hotel.models.Typology;
import com.sopra.hotel.services.TypeRoomService;

public class DefaultTypeRoomService implements TypeRoomService {

	private TypeRoomDAO typeRoomDAO;
	
	public double getPrice(Typology typology) {
		return typeRoomDAO.getPrice(typology);
	}

	public boolean updateNewPrice(Typology typology, double newPrice) {
		return typeRoomDAO.updateNewPrice(typology, newPrice);
	}

}

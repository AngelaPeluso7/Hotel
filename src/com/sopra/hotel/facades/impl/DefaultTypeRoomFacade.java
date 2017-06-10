package com.sopra.hotel.facades.impl;

import com.sopra.hotel.facades.TypeRoomFacade;
import com.sopra.hotel.models.Typology;
import com.sopra.hotel.services.TypeRoomService;

public class DefaultTypeRoomFacade implements TypeRoomFacade {

	private TypeRoomService typeRoomService;
	
	public double getPrice(Typology typology){
		return typeRoomService.getPrice(typology);
	}
	
	public boolean updateNewPrice(Typology typology, double newPrice){
		return typeRoomService.updateNewPrice(typology, newPrice);
	}
}

package com.sopra.hotel.services;

import com.sopra.hotel.models.Typology;

public interface TypeRoomService {
	
	public double getPrice(Typology typology);
	
	public boolean updateNewPrice(Typology typology, double newPrice);
}

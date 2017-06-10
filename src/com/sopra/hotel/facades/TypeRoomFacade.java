package com.sopra.hotel.facades;

import com.sopra.hotel.models.Typology;

public interface TypeRoomFacade {
	
	public double getPrice(Typology typology);
	
	public boolean updateNewPrice(Typology typology, double newPrice);	
}

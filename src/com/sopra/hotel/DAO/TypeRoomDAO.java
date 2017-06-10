package com.sopra.hotel.DAO;

import com.sopra.hotel.models.Typology;

public interface TypeRoomDAO {
	
	public double getPrice(Typology typology);
	
	public boolean updateNewPrice(Typology typology, double newPrice);
	
	//public boolean newTypeRoom(String newTypeRoom, double price);
}

package com.sopra.hotel.DAO;

import java.util.List;

import com.sopra.hotel.models.TypeRoomModel;
import com.sopra.hotel.models.Typology;

public interface TypeRoomDAO {
	
	public double findPrice(Typology typology);
	
	public boolean updateNewPrice(Typology typology, double newPrice);
	
	public List<TypeRoomModel> findAll();
	
	public TypeRoomModel findById(int idTypeRoom);
	
}

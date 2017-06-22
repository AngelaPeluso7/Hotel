package com.sopra.hotel.services.impl;

import java.util.List;

import com.sopra.hotel.DAO.TypeRoomDAO;
import com.sopra.hotel.DAO.impl.DefaultTypeRoomDAO;
import com.sopra.hotel.models.TypeRoomModel;
import com.sopra.hotel.models.Typology;
import com.sopra.hotel.services.TypeRoomService;

public class DefaultTypeRoomService implements TypeRoomService {

	private TypeRoomDAO typeRoomDAO;
	
	public DefaultTypeRoomService(){
		this.typeRoomDAO=new DefaultTypeRoomDAO();
	}
	
	public double getPrice(Typology typology) {
		return typeRoomDAO.findPrice(typology);
	}

	public boolean updateNewPrice(Typology typology, double newPrice) {
		return typeRoomDAO.updateNewPrice(typology, newPrice);
	}

	public List<TypeRoomModel> getAll(){
		return typeRoomDAO.findAll();
	}
	
	public TypeRoomModel getById(int idTypeRoom){
		return typeRoomDAO.findById(idTypeRoom);
	}
	
	public TypeRoomDAO getTypeRoomDAO() {
		return typeRoomDAO;
	}

	public void setTypeRoomDAO(TypeRoomDAO typeRoomDAO) {
		this.typeRoomDAO = typeRoomDAO;
	}
}

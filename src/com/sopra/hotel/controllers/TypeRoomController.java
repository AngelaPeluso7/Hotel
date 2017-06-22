package com.sopra.hotel.controllers;

import java.util.List;

import com.sopra.hotel.data.TypeRoomData;
import com.sopra.hotel.facades.TypeRoomFacade;
import com.sopra.hotel.facades.impl.DefaultTypeRoomFacade;

public class TypeRoomController {
	private TypeRoomFacade typeRoomFacade;
	
	public TypeRoomController(){
		this.typeRoomFacade=new DefaultTypeRoomFacade();
	}
	
	public String getPrice(String typology){
		return "The price of "+typology+" room is: "+Double.toString(typeRoomFacade.getPrice(typology))+" €";
	}
	
	public String updateNewPrice(String typology, double newPrice){
		if(typeRoomFacade.updateNewPrice(typology, newPrice))
			return "SUCCESS!!! The price has been updated.";
		else
			return "ERROR!!! The price has NOT been updated.";
	}
	
	public List<TypeRoomData> getAll(){
		return typeRoomFacade.getAll();
	}

	public TypeRoomData getById(int idTypeRoom){
		return typeRoomFacade.getById(idTypeRoom);
	}
}

package com.sopra.hotel.controllers;

import com.sopra.hotel.facades.TypeRoomFacade;
import com.sopra.hotel.models.Typology;

public class TypeRoomController {
	private TypeRoomFacade typeRoomFacade;
	
	public String getPrice(Typology typology){
		return "The price of "+typology+" room is: "+Double.toString(typeRoomFacade.getPrice(typology))+" €";
	}
	
	public String updateNewPrice(Typology typology, double newPrice){
		if(typeRoomFacade.updateNewPrice(typology, newPrice))
			return "SUCCESS!!! The price has been updated.";
		else
			return "ERROR!!! The price has NOT been updated.";
	}
}

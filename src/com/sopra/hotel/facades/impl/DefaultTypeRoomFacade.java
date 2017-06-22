package com.sopra.hotel.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.sopra.hotel.data.TypeRoomData;
import com.sopra.hotel.facades.TypeRoomFacade;
import com.sopra.hotel.models.TypeRoomModel;
import com.sopra.hotel.models.Typology;
import com.sopra.hotel.services.TypeRoomService;
import com.sopra.hotel.services.impl.DefaultTypeRoomService;

public class DefaultTypeRoomFacade implements TypeRoomFacade {

	private TypeRoomService typeRoomService;
	
	public DefaultTypeRoomFacade(){
		this.typeRoomService=new DefaultTypeRoomService();
	}
	
	public double getPrice(String typology){
		return typeRoomService.getPrice(Typology.valueOf(typology));
	}
	
	public boolean updateNewPrice(String typology, double newPrice){
		return typeRoomService.updateNewPrice(Typology.valueOf(typology), newPrice);
	}
	
	public List<TypeRoomData> getAll(){
		List<TypeRoomModel> typeRoomsModel=typeRoomService.getAll();
		final List<TypeRoomData> typeRoomsData = new ArrayList<TypeRoomData>();
        for (final TypeRoomModel typeRoomModel : typeRoomsModel) {
        	TypeRoomData typeRoomData=new TypeRoomData();
        	typeRoomData.setIdTypeRoom(typeRoomModel.getIdTypeRoom());
        	typeRoomData.setTypology(typeRoomModel.getTypology().toString());
        	typeRoomData.setPrice(typeRoomModel.getPrice());
        	typeRoomsData.add(typeRoomData);
        }
        return typeRoomsData;
	}
	
	public TypeRoomData getById(int idTypeRoom){
		TypeRoomModel typeRoomModel=typeRoomService.getById(idTypeRoom);
		TypeRoomData typeRoomData = new TypeRoomData();
		typeRoomData.setIdTypeRoom(typeRoomModel.getIdTypeRoom());
    	typeRoomData.setTypology(typeRoomModel.getTypology().toString());
    	typeRoomData.setPrice(typeRoomModel.getPrice());
    	return typeRoomData;
	}
}

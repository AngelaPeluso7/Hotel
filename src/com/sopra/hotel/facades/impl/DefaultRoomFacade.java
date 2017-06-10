package com.sopra.hotel.facades.impl;

import java.util.List;

import com.sopra.hotel.facades.RoomFacade;
import com.sopra.hotel.models.RoomModel;
import com.sopra.hotel.services.RoomService;

public class DefaultRoomFacade implements RoomFacade {
	
	private RoomService roomService;
	
	public boolean checkIsFree(int roomNumber){
		return roomService.checkIsFree(roomNumber);
	}
    
	public boolean checkIsBusy(int roomNumber){
		return roomService.checkIsBusy(roomNumber);
	}

	public List<RoomModel> viewAllRoomFree(){
		return roomService.viewAllRoomFree();
	}
	
	public boolean checkIn(int roomNumber){
		return roomService.checkIn(roomNumber);
	}
	
	public boolean checkOut(int roomNumber){
		return roomService.checkOut(roomNumber);
	}
}

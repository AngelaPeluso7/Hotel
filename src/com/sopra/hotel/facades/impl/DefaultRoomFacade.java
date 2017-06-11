package com.sopra.hotel.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.sopra.hotel.data.RoomData;
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

	public List<RoomData> viewAllRoomFree(){
		List<RoomModel> roomsModel = roomService.viewAllRoomFree();
        final List<RoomData> roomsData = new ArrayList<RoomData>();
        for (final RoomModel room : roomsModel) {
            final RoomData roomData = new RoomData();
            roomData.setNumber(room.getNumber());
            roomData.setTypeRoom(room.getTypeRoom());
            roomData.setActualState(room.getActualState());
            roomsData.add(roomData);
        }
        return roomsData;
	}
	
	public boolean checkIn(int roomNumber){
		return roomService.checkIn(roomNumber);
	}
	
	public boolean checkOut(int roomNumber){
		return roomService.checkOut(roomNumber);
	}
}

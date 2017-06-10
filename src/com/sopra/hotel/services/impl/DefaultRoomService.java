package com.sopra.hotel.services.impl;

import java.util.List;

import com.sopra.hotel.DAO.RoomDAO;
import com.sopra.hotel.models.RoomModel;
import com.sopra.hotel.services.RoomService;

public class DefaultRoomService implements RoomService {
	
	private RoomDAO roomDAO;
	
	public boolean checkIsFree(int roomNumber){
		return  roomDAO.checkIsFree(roomNumber);
	}  
	    
	public boolean checkIsBusy(int roomNumber){
		return roomDAO.checkIsBusy(roomNumber);
	}

	public List<RoomModel> viewAllRoomFree(){
		return roomDAO.viewAllRoomFree();
	}
	
	public boolean checkIn(int roomNumber){
		return roomDAO.checkIn(roomNumber);
	}
	
	public boolean checkOut(int roomNumber){
		return roomDAO.checkOut(roomNumber);
	}
	
	public RoomDAO getRoomDAO() {
		return roomDAO;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
}

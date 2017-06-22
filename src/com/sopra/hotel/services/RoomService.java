package com.sopra.hotel.services;

import java.util.List;

import com.sopra.hotel.models.RoomModel;

public interface RoomService {
	
	public boolean checkIsFree(int roomNumber);
	    
	public boolean checkIsBusy(int roomNumber);

	public List<RoomModel> getAllRoomFree();
	
	public boolean checkIn(int roomNumber);
	
	public boolean checkOut(int roomNumber);
	
	public List<RoomModel> getAll();
	
	public RoomModel getById(int idRoom);
	
	public int getIdRoom(int number);
}

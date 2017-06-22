package com.sopra.hotel.facades;

import java.util.List;

import com.sopra.hotel.data.RoomData;

public interface RoomFacade {
	
	public boolean checkIsFree(int roomNumber);
    
	public boolean checkIsBusy(int roomNumber);

	public List<RoomData> getAllRoomFree();
	
	public boolean checkIn(int roomNumber);
	
	public boolean checkOut(int roomNumber);
	
	public List<RoomData> getAll();
	
	public RoomData getById(int idRoom);
	
	public int getIdRoom(int number);
}

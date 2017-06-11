package com.sopra.hotel.facades;

import java.util.List;

import com.sopra.hotel.data.RoomData;

public interface RoomFacade {
	
	public boolean checkIsFree(int roomNumber);
    
	public boolean checkIsBusy(int roomNumber);

	public List<RoomData> viewAllRoomFree();
	
	public boolean checkIn(int roomNumber);
	
	public boolean checkOut(int roomNumber);
}

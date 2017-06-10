package com.sopra.hotel.DAO;

import java.util.List;

import com.sopra.hotel.models.RoomModel;

public interface RoomDAO {
	
	public boolean checkIsFree(int roomNumber);
	
	public boolean checkIsBusy(int roomNumber);
	
	public List<RoomModel> viewAllRoomFree();
	
	public boolean checkIn(int roomNumber);
	
	public boolean checkOut(int roomNumber);
}

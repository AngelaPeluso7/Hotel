package com.sopra.hotel.services.impl;

import java.util.List;

import com.sopra.hotel.DAO.RoomDAO;
import com.sopra.hotel.DAO.impl.DefaultRoomDAO;
import com.sopra.hotel.models.RoomModel;
import com.sopra.hotel.services.RoomService;

public class DefaultRoomService implements RoomService {
	
	private RoomDAO roomDAO;
	
	public DefaultRoomService(){
		this.roomDAO=new DefaultRoomDAO();
	}
	
	public boolean checkIsFree(int roomNumber){
		return  roomDAO.checkIsFree(roomNumber);
	}  
	    
	public boolean checkIsBusy(int roomNumber){
		return roomDAO.checkIsBusy(roomNumber);
	}

	public List<RoomModel> getAllRoomFree(){
		return roomDAO.findAllRoomFree();
	}
	
	public boolean checkIn(int roomNumber){
		return roomDAO.checkIn(roomNumber);
	}
	
	public boolean checkOut(int roomNumber){
		return roomDAO.checkOut(roomNumber);
	}
	
	public List<RoomModel> getAll(){
		return roomDAO.findAll();
	}
	
	public RoomModel getById(int idRoom){
		return roomDAO.findById(idRoom);
	}

	public RoomDAO getRoomDAO() {
		return roomDAO;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	
	public int getIdRoom(int number){
		return roomDAO.findIdRoom(number);
	}
}

package com.sopra.hotel.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.sopra.hotel.data.RoomData;
import com.sopra.hotel.facades.RoomFacade;
import com.sopra.hotel.models.RoomModel;
import com.sopra.hotel.services.RoomService;
import com.sopra.hotel.services.impl.DefaultRoomService;

public class DefaultRoomFacade implements RoomFacade {
	
	private RoomService roomService;
	//private RoomModel roomModel;
	
	public DefaultRoomFacade(){
		this.roomService=new DefaultRoomService();
		//this.roomModel=new RoomModel();
	}
	
	public boolean checkIsFree(int roomNumber){
		return roomService.checkIsFree(roomNumber);
	}
    
	public boolean checkIsBusy(int roomNumber){
		return roomService.checkIsBusy(roomNumber);
	}

	public List<RoomData> getAllRoomFree(){
		List<RoomModel> roomsModel = roomService.getAllRoomFree();
        final List<RoomData> roomsData = new ArrayList<RoomData>();
        for (final RoomModel roomModel : roomsModel) {
            final RoomData roomData = new RoomData();
            roomData.setIdRoom(roomModel.getIdRoom());
            roomData.setNumber(roomModel.getNumber());
            roomData.setActualState(roomModel.getActualState().toString());
            roomData.setIdType(roomModel.getIdType());
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
	
	public List<RoomData> getAll(){
		List<RoomModel> roomsModel = roomService.getAll();
        final List<RoomData> roomsData = new ArrayList<RoomData>();
        for (final RoomModel roomModel : roomsModel) {
            final RoomData roomData = new RoomData();
            roomData.setIdRoom(roomModel.getIdRoom());
            roomData.setNumber(roomModel.getNumber());
            roomData.setActualState(roomModel.getActualState().toString());
            roomData.setIdType(roomModel.getIdType());
            roomsData.add(roomData);
        }
        return roomsData;
	}
	
	public RoomData getById(int idRoom){
		RoomModel roomModel=roomService.getById(idRoom);
		RoomData roomData = new RoomData();
		roomData.setIdRoom(roomModel.getIdRoom());
        roomData.setNumber(roomModel.getNumber());
        roomData.setActualState(roomModel.getActualState().toString());
        roomData.setIdType(roomModel.getIdType());
    	return roomData;
	}
	
	public int getIdRoom(int number){
		return roomService.getIdRoom(number);
	}
}

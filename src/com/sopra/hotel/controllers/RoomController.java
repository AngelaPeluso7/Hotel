package com.sopra.hotel.controllers;

import java.util.ArrayList;
import java.util.List;

import com.sopra.hotel.data.RoomData;
import com.sopra.hotel.facades.RoomFacade;

public class RoomController {
	private RoomFacade roomFacade;
	
	public String checkIsFree(int roomNumber){
		if(roomFacade.checkIsFree(roomNumber)){
			return "The room Number: "+ roomNumber+" is FREE now.";
		}
		else return "The room Number: "+ roomNumber+" is NOT FREE now.";
	}
    
	public String checkIsBusy(int roomNumber){
		if(roomFacade.checkIsBusy(roomNumber)){
			return "The room Number: "+ roomNumber+" is Busy now.";
		}
		else return "The room Number: "+ roomNumber+" is NOT BUSY now.";
	}

	public String viewAllRoomFree(){
		List<RoomData> roomsList= roomFacade.viewAllRoomFree();
		
		ArrayList<String> roomsListPrint = new ArrayList<String>();
		for (RoomData r: roomsList){
			roomsListPrint.add(r.toString());
		}
		String print = "";
		for (String s : roomsListPrint)
		{
		    print += s + "\t";
		}
		return print;
	}
	
	public String checkIn(int roomNumber){
		String print;
		if(roomFacade.checkIn(roomNumber)){
			print="SUCCESS!!! The checkIn has been added";
		}
		else print="ERRORR!!! The checkIn has NOT been added";
		return print;
	}
	
	public String checkOut(int roomNumber){
		String print;
		if(roomFacade.checkOut(roomNumber)){
			print="SUCCESS!!! The checkOut has been added";
		}
		else print="ERRORR!!! The checkOut has NOT been added";
		return print;
	}
}

package com.sopra.hotel.controllers;

import com.sopra.hotel.data.ClientData;
import com.sopra.hotel.facades.ClientFacade;
import com.sopra.hotel.models.ClientModel;

public class ClientController {
	
	private ClientFacade clientFacade;
	public String newClient(ClientModel clientModel){
		String print;
		if(clientFacade.newClient(clientModel)){
			print="SUCCESS!!! The new client has been added";
		}
		else print="ERRORR!!! The new client has NOT been added";
		return print;
	}
	
	public String getClientInfoToFiscalCode(String fiscalCode){
		ClientData client=clientFacade.getClientInfoToFiscalCode(fiscalCode);
		String print =client.toString();
		return print;
	}
	
	public String getClientInfoToNumber(String phoneNumber){
		ClientData client=clientFacade.getClientInfoToNumber(phoneNumber);
		String print =client.toString();
		return print;
	}
}

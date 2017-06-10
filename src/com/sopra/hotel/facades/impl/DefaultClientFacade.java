package com.sopra.hotel.facades.impl;

import com.sopra.hotel.facades.ClientFacade;
import com.sopra.hotel.models.ClientModel;
import com.sopra.hotel.services.ClientService;

public class DefaultClientFacade implements ClientFacade {
	
	private ClientService clientService;
	
	public boolean newClient(ClientModel clientModel){
		return clientService.newClient(clientModel);
	}
	
	public ClientModel getClientInfoToFiscalCode(String fiscalCode){
		return clientService.getClientInfoToFiscalCode(fiscalCode);
	}
	
	public ClientModel getClientInfoToNumber(String phoneNumber){
		return clientService.getClientInfoToNumber(phoneNumber);
	}
}

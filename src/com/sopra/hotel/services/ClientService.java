package com.sopra.hotel.services;

import com.sopra.hotel.models.ClientModel;

public interface ClientService {

	public boolean newClient(ClientModel clientModel);
	
	public ClientModel getClientInfoToFiscalCode(String fiscalCode);
	
	public ClientModel getClientInfoToNumber(String phoneNumber);
}

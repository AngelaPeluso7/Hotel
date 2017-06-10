package com.sopra.hotel.facades;

import com.sopra.hotel.models.ClientModel;

public interface ClientFacade {
	
	public boolean newClient(ClientModel clientModel);
	
	public ClientModel getClientInfoToFiscalCode(String fiscalCode);
	
	public ClientModel getClientInfoToNumber(String phoneNumber);
}

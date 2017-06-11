package com.sopra.hotel.facades;

import com.sopra.hotel.data.ClientData;
import com.sopra.hotel.models.ClientModel;

public interface ClientFacade {
	
	public boolean newClient(ClientModel clientModel);
	
	public ClientData getClientInfoToFiscalCode(String fiscalCode);
	
	public ClientData getClientInfoToNumber(String phoneNumber);
}

package com.sopra.hotel.DAO;

import com.sopra.hotel.models.ClientModel;

public interface ClientDAO {
	
	public boolean newClient(ClientModel clientModel);
	
	public ClientModel getClientInfoToFiscalCode(String fiscalCode);
	
	public ClientModel getClientInfoToNumber(String phoneNumber);
	
}

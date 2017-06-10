package com.sopra.hotel.services.impl;

import com.sopra.hotel.DAO.ClientDAO;
import com.sopra.hotel.models.ClientModel;
import com.sopra.hotel.services.ClientService;

public class DefaultClientService implements ClientService {
	
	private ClientDAO clientDAO;
	
	public boolean newClient(ClientModel clientModel){
		return clientDAO.newClient(clientModel);
	}
	
	public ClientModel getClientInfoToFiscalCode(String fiscalCode){
		return clientDAO.getClientInfoToFiscalCode(fiscalCode);
	}
	
	public ClientModel getClientInfoToNumber(String phoneNumber){
		return clientDAO.getClientInfoToNumber(phoneNumber);
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
}

package com.sopra.hotel.facades;

import java.util.List;

import com.sopra.hotel.data.ClientData;

public interface ClientFacade {
	
	public boolean newClient(ClientData clientData);
	
	public ClientData getById(int idClient);
	
	public ClientData getByFiscalCode(String fiscalCode);
	
	public ClientData getByNumber(String phoneNumber);
	
	public List<ClientData> getAll();
}

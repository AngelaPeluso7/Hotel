package com.sopra.hotel.services;

import java.util.List;

import com.sopra.hotel.models.ClientModel;

public interface ClientService {

	public boolean newClient(ClientModel clientModel);
	
	public ClientModel getById(int idClient);
	
	public ClientModel getByFiscalCode(String fiscalCode);
	
	public ClientModel getByNumber(String phoneNumber);
	
	public List<ClientModel> getAll();
}

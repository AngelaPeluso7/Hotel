package com.sopra.hotel.DAO;

import java.util.List;

import com.sopra.hotel.models.ClientModel;

public interface ClientDAO {
	
	public boolean newClient(ClientModel clientModel);
	
	public ClientModel findById(int idClient);
	
	public ClientModel findByFiscalCode(String fiscalCode);
	
	public ClientModel findByNumber(String phoneNumber);
	
	public List<ClientModel> findAll();
	
}

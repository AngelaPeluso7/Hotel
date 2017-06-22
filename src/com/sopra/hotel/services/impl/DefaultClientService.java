package com.sopra.hotel.services.impl;

import java.util.List;

import com.sopra.hotel.DAO.ClientDAO;
import com.sopra.hotel.DAO.impl.DefaultClientDAO;
import com.sopra.hotel.models.ClientModel;
import com.sopra.hotel.services.ClientService;

public class DefaultClientService implements ClientService {
	
	private ClientDAO clientDAO;
	
	public DefaultClientService(){
		this.clientDAO=new DefaultClientDAO();
	}
	
	public boolean newClient(ClientModel clientModel){
		return clientDAO.newClient(clientModel);
	}
	
	public ClientModel getById(int idClient){
		return clientDAO.findById(idClient);
	}
	
	public ClientModel getByFiscalCode(String fiscalCode){
		return clientDAO.findByFiscalCode(fiscalCode);
	}
	
	public ClientModel getByNumber(String phoneNumber){
		return clientDAO.findByNumber(phoneNumber);
	}
	
	public List<ClientModel> getAll(){
		return clientDAO.findAll();
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
}

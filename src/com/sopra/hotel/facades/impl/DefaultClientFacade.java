package com.sopra.hotel.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.sopra.hotel.data.ClientData;
import com.sopra.hotel.facades.ClientFacade;
import com.sopra.hotel.models.ClientModel;
import com.sopra.hotel.services.ClientService;
import com.sopra.hotel.services.impl.DefaultClientService;

public class DefaultClientFacade implements ClientFacade {
	
	private ClientService clientService;
	
	public DefaultClientFacade(){
		this.clientService=new DefaultClientService();
	}
	
	public boolean newClient(ClientData clientData){
		ClientModel clientModel=new ClientModel();
		clientModel.setIdClient(clientData.getIdClient());
		clientModel.setFiscalCode(clientData.getFiscalCode());
		clientModel.setName(clientData.getName());
		clientModel.setSurname(clientData.getSurname());
		clientModel.setDateOfBirth(clientData.getDateOfBirth());
		clientModel.setAddress(clientData.getAddress());
		clientModel.setCity(clientData.getCity());
		clientModel.setCountry(clientData.getCountry());
		clientModel.setPhoneNumber(clientData.getPhoneNumber());
		return clientService.newClient(clientModel);
	}
	
	public ClientData getById(int idClient){
		if (idClient != 0)
		{
			ClientModel clientModel = clientService.getById(idClient);
			if (clientModel == null)
			{
				return null;
			}
			ClientData clientData = new ClientData();
			clientData.setIdClient(idClient);
	        clientData.setFiscalCode(clientModel.getFiscalCode());
	        clientData.setName(clientModel.getName());
	        clientData.setSurname(clientModel.getSurname());
	        clientData.setDateOfBirth(clientModel.getDateOfBirth());
	        clientData.setAddress(clientModel.getAddress());
	        clientData.setCity(clientModel.getCity());
	        clientData.setCountry(clientModel.getCountry());
	        clientData.setPhoneNumber(clientModel.getPhoneNumber());
	        return clientData;
		}
		else
		{
			throw new IllegalArgumentException("Client with id: " + idClient + " not found.");
		}
	}
	public ClientData getByFiscalCode(String fiscalCode){
		if (fiscalCode != null)
		{
			ClientModel clientModel = clientService.getByFiscalCode(fiscalCode);
			if (clientModel == null)
			{
				return null;
			}
			ClientData clientData = new ClientData();
			clientData.setIdClient(clientModel.getIdClient());
	        clientData.setFiscalCode(fiscalCode);
	        clientData.setName(clientModel.getName());
	        clientData.setSurname(clientModel.getSurname());
	        clientData.setDateOfBirth(clientModel.getDateOfBirth());
	        clientData.setAddress(clientModel.getAddress());
	        clientData.setCity(clientModel.getCity());
	        clientData.setCountry(clientModel.getCountry());
	        clientData.setPhoneNumber(clientModel.getPhoneNumber());
	        return clientData;
		}
		else
		{
			throw new IllegalArgumentException("Client with Fiscal Code: " + fiscalCode + " not found.");
		}
	}
	
	public ClientData getByNumber(String phoneNumber){
		if (phoneNumber != null)
		{
			ClientModel clientModel = clientService.getByNumber(phoneNumber);
			if (clientModel == null)
			{
				return null;
			}
			ClientData clientData = new ClientData();
			clientData.setIdClient(clientModel.getIdClient());
	        clientData.setFiscalCode(clientModel.getFiscalCode());
	        clientData.setName(clientModel.getName());
	        clientData.setSurname(clientModel.getSurname());
	        clientData.setDateOfBirth(clientModel.getDateOfBirth());
	        clientData.setAddress(clientModel.getAddress());
	        clientData.setCity(clientModel.getCity());
	        clientData.setCountry(clientModel.getCountry());
	        clientData.setPhoneNumber(phoneNumber);
	        return clientData;
		}
		else
		{
			throw new IllegalArgumentException("Client with Phone Number: " + phoneNumber + " not found.");
		}
	}
	
	public List<ClientData> getAll(){
		List<ClientModel> clientsModelList=clientService.getAll();
		List<ClientData> clientsDataList=new ArrayList<ClientData>();
		for(ClientModel clientModel: clientsModelList){
			ClientData clientData=new ClientData();
			clientData.setIdClient(clientModel.getIdClient());
	        clientData.setFiscalCode(clientModel.getFiscalCode());
	        clientData.setName(clientModel.getName());
	        clientData.setSurname(clientModel.getSurname());
	        clientData.setDateOfBirth(clientModel.getDateOfBirth());
	        clientData.setAddress(clientModel.getAddress());
	        clientData.setCity(clientModel.getCity());
	        clientData.setCountry(clientModel.getCountry());
	        clientData.setPhoneNumber(clientModel.getPhoneNumber());
	        clientsDataList.add(clientData);
		}
		return clientsDataList;
		
	}
}

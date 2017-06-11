package com.sopra.hotel.facades.impl;

import com.sopra.hotel.data.ClientData;
import com.sopra.hotel.facades.ClientFacade;
import com.sopra.hotel.models.ClientModel;
import com.sopra.hotel.services.ClientService;

public class DefaultClientFacade implements ClientFacade {
	
	private ClientService clientService;
	
	public boolean newClient(ClientModel clientModel){
		return clientService.newClient(clientModel);
	}
	
	public ClientData getClientInfoToFiscalCode(String fiscalCode){
		ClientModel clientModel = null;
		if (fiscalCode != null)
		{
			clientModel = clientService.getClientInfoToFiscalCode(fiscalCode);
			if (clientModel == null)
			{
				return null;
			}
		}
		else
		{
			throw new IllegalArgumentException("Client with fiscal code: " + fiscalCode + " not found.");
		}

        final ClientData clientData = new ClientData();
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
	
	public ClientData getClientInfoToNumber(String phoneNumber){
		ClientModel clientModel = null;
		if (phoneNumber != null)
		{
			clientModel = clientService.getClientInfoToFiscalCode(phoneNumber);
			if (clientModel == null)
			{
				return null;
			}
		}
		else
		{
			throw new IllegalArgumentException("Client with phone Number: " + phoneNumber + " not found.");
		}

        final ClientData clientData = new ClientData();
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
}

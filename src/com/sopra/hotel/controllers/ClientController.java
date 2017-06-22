package com.sopra.hotel.controllers;

import java.util.List;

import com.sopra.hotel.data.ClientData;
import com.sopra.hotel.facades.ClientFacade;
import com.sopra.hotel.facades.impl.DefaultClientFacade;

public class ClientController {
	
	private ClientFacade clientFacade;
	
	public ClientController(){
		this.clientFacade=new DefaultClientFacade();
	}
	
	public String newClient(ClientData clientData){
		String print;
		if(clientFacade.newClient(clientData)){
			print="SUCCESS!!! The new client has been added";
		}
		else print="ERRORR!!! The new client has NOT been added";
		return print;
	}
	
	public String showById(int idClient){
		ClientData client=clientFacade.getById(idClient);
		String print =client.toString();
		return print;
	}
	
	public ClientData getById(int idClient){
		ClientData client=clientFacade.getById(idClient);
		return client;
	}
	
	public String showClientInfoByFiscalCode(String fiscalCode){
		ClientData client=clientFacade.getByFiscalCode(fiscalCode);
		String print =client.toString();
		return print;
	}
	
	public int getIdClient(String fiscalCode){
		ClientData client=clientFacade.getByFiscalCode(fiscalCode);
		return client.getIdClient();
	}
	public boolean getByFiscalCode(String fiscalCode){
		boolean found=false;
		ClientData c=clientFacade.getByFiscalCode(fiscalCode);
		if (c.getIdClient()!=0){
			return found=true;
		}
		return found;
	}
	
	public String showClientInfoByNumber(String phoneNumber){
		ClientData client=clientFacade.getByNumber(phoneNumber);
		String print =client.toString();
		return print;
	}
	public List<ClientData> getAll(){
		return clientFacade.getAll();
	}
}

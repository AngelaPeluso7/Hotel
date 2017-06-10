package com.sopra.hotel.models;

public class ClientModel {
	String fiscalCode,name,surname,dateOfBirth,address, city, country, phoneNumber;
	
	public ClientModel(String fiscalCode, String name, String surname, String dateOfBirth, String address, String city,
			String country, String phoneNumber) {
		super();
		this.fiscalCode = fiscalCode;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
	}
	
	public ClientModel() {
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ClientModel [fiscalCode=" + fiscalCode + ", name=" + name + ", surname=" + surname + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", city=" + city + ", country=" + country + ", phoneNumber="
				+ phoneNumber + "]";
	}

	
}

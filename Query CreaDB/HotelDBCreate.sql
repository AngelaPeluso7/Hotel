DROP DATABASE IF EXISTS Hotel;

CREATE DATABASE Hotel
	DEFAULT CHARACTER SET latin1
    DEFAULT COLLATE latin1_general_ci;

USE Hotel;

DROP TABLE IF EXISTS Client;

CREATE TABLE Client(
	idClient INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	fiscalCode VARCHAR(64) NOT NULL ,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    dateOfBirth VARCHAR(32) NOT NULL,
    address VARCHAR(64) NOT NULL,
    city VARCHAR(32) NOT NULL,
    country VARCHAR(32) NOT NULL,
    phoneNumber VARCHAR(32) NOT NULL
);
    
DROP TABLE IF EXISTS TypeRoom;
    
CREATE TABLE TypeRoom(
	idTypeRoom INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	typology VARCHAR(32) NOT NULL ,
    price DOUBLE NOT NULL
);
    
DROP TABLE IF EXISTS Room;

CREATE TABLE Room(
	idRoom INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	number INT NOT NULL,
    actualState VARCHAR(32) NOT NULL,
    idType INT NOT NULL,
    FOREIGN KEY (idType) REFERENCES TypeRoom(idTypeRoom)
);
    
DROP TABLE IF EXISTS Booking;

CREATE TABLE Booking(
	idBooking INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idRoom INT NOT NULL,
	idClient INT NOT NULL,
    peopleNumber INT NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    nightNumber INT NOT NULL,
    totalPrice DOUBLE NOT NULL,
    deposit DOUBLE,
    checkInDate DATE,
    checkOutDate DATE,
    FOREIGN KEY (idRoom) REFERENCES Room(idRoom),
    FOREIGN KEY (idClient) REFERENCES Client(idClient)
);
    
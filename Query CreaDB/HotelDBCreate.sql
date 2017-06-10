DROP DATABASE IF EXISTS Hotel;

CREATE DATABASE Hotel
	DEFAULT CHARACTER SET latin1
    DEFAULT COLLATE latin1_general_ci;

USE Hotel;

DROP TABLE IF EXISTS Client;

CREATE TABLE Client(
	fiscalCode VARCHAR(64) NOT NULL PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    dateOfBirth VARCHAR(32) NOT NULL,
    address VARCHAR(64) NOT NULL,
    city VARCHAR(32) NOT NULL,
    country VARCHAR(32) NOT NULL,
    phoneNumber VARCHAR(32) NOT NULL
);
    
DROP TABLE IF EXISTS Room;

CREATE TABLE Room(
	number INT NOT NULL PRIMARY KEY,
    type VARCHAR(32) NOT NULL,
    actualState VARCHAR(32) NOT NULL
);
    
DROP TABLE IF EXISTS TypeRoom;
    
CREATE TABLE TypeRoom(
	typology VARCHAR(32) NOT NULL PRIMARY KEY,
    price DOUBLE NOT NULL
);
    
DROP TABLE IF EXISTS Booking;

CREATE TABLE Booking(
	id INT NOT NULL AUTO_INCREMENT,
    room INT NOT NULL,
	client VARCHAR(64) NOT NULL,
    peopleNumber INT NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    nightNumber INT NOT NULL,
    totalPrice DOUBLE NOT NULL,
    deposit DOUBLE,
    checkInDate DATE,
    checkOutDate DATE,
    CONSTRAINT pk_id PRIMARY KEY (id),
    CONSTRAINT fk_room FOREIGN KEY (room) REFERENCES Room(number),
    CONSTRAINT fk_client FOREIGN KEY (client) REFERENCES Client(fiscalCode)
);
    
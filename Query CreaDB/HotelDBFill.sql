INSERT INTO Client  (idClient, 	fiscalCode,				name,			surname,	dateOfBirth,	address,					city,		country,	phoneNumber) VALUES
					(1,			'RSSMRA87C24A522K', 	'Mario',		'Rossi',	'1987-06-22',	'Via Vittorio Emanuele,33',	'Roma',		'Italia',	'3453745521'),
					(2,			'FRSGVN78D20N456L',		'Giovanni',		'Farisco',	'1978-07-20',	'Piazza Centrale,21',		'Napoli',	'Italia',	'3245533123'),
                    (3,			'LPVDES67F13L234C',		'Filippo',		'Bianco',	'1967-06-18',	'Corso Umberto,16',			'Bergamo',	'Italia',	'3347678456'),
                    (4,			'LKJMRD56E12P990E',		'Maria',		'Salice',	'1956-08-10',	'Via Matteotti,11',			'Pavia',	'Italia',	'3283182443'),
                    (5,			'PLRSRD78D30O433T',		'Teresa',		'Covotta',	'1978-07-15',	'Via Lunga,101',			'Lecce',	'Italia',	'3393542234');
                                                       
INSERT INTO TypeRoom(idTypeRoom,	typology,		price) VALUES
					(1,				'SINGLE',		30.00),
                    (2,				'DOUBLE',		50.00),
                    (3,				'TRIPLE',		80.00),
                    (4,				'QUADRUPLE',	100.00);          
                
INSERT INTO Room(idRoom,number,	actualState,idType) VALUES
				(1,		101,	'FREE',		1	),
                (2,		102,	'FREE',		1	),
                (3,		103,	'FREE',		1	),
                (4,		201,	'FREE',		2	),
                (5,		202,	'FREE',		2	),
                (6,		203,	'FREE',		2	),
                (7,		204,	'FREE',		2	),
                (8,		205,	'FREE',		2	),
                (9,		206,	'FREE',		2	),
                (10,	207,	'FREE',		2	),
                (11,	208,	'FREE',		2	),
                (12,	209,	'FREE',		2	),
                (13,	210,	'FREE',		2	),
                (14,	301,	'FREE',		3	),
                (15,	302,	'FREE',		3	),
                (16,	303,	'FREE',		3	),
                (17,	304,	'FREE',		3	),
                (18,	305,	'FREE',		3	),
                (19,	401,	'FREE',		4	),
                (20,	402,	'FREE',		4	);
                

INSERT INTO Booking	(idBooking,	idRoom,	idClient,	peopleNumber,	startDate,		endDate,		nightNumber, 	totalPrice,	deposit,	checkInDate,	checkOutDate) VALUES
					(1,			1,		1,			1,				'2017-06-22',	'2017-06-28',	6,				180.00,		50.00,		NULL,			NULL		),	
                    (2,			4,		2,			2,				'2017-07-20',	'2017-07-27',	7,				350.00,		100.00,		NULL,			NULL		),
                    (3,			19,		3,			4,				'2017-06-18',	'2017-06-26',	8,				800.00,		200.00,		NULL,			NULL		),	
                    (4,			14,		4,			3,				'2017-08-10',	'2017-08-17',	7,				560.00,		100.00,		NULL,			NULL		),
                    (5,			5,		5,			2,				'2017-07-15',	'2017-07-18',	3,				100.00,		50.00,		NULL,			NULL		),
					(6,			4,		2,			2,				'2017-08-20',	'2017-08-27',	7,				350.00,		100.00,		NULL,			NULL		);
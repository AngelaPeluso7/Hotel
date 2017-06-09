INSERT INTO Client  (fiscalCode,			name,		surname,	address,					city,		country,	phoneNumber) VALUES
					('RSSMRA87C24A522K', 	'Mario',	'Rossi',	'via Vittorio Emanuele,33',	'Roma',		'Italia',	'3453745521'),
					('FRSGVN78D20N456L',	'Giovanni',	'Farisco',	'piazza Centrale,21',		'Napoli',	'Italia',	'3245533123'),
                    ('LPVDES67F13L234C',	'Filippo',	'Bianco',	'Corso Umberto,16',			'Bergamo',	'Italia',	'3347678456'),
                    ('LKJMRD56E12P990E',	'Maria',	'Salice',	'Via Matteotti,11',			'Pavia',	'Italia',	'3283182443'),
                    ('PLRSRD78D30O433T',	'Teresa',	'Covotta',	'Via Lunga,101',			'Lecce',	'Italia',	'3393542234');
                    
                    
INSERT INTO Room(number,type,actualState) VALUES
				(101,'SINGLE','FREE'),
                (102,'SINGLE','FREE'),
                (103,'SINGLE','FREE'),
                (201,'DOUBLE','FREE'),
                (202,'DOUBLE','FREE'),
                (203,'DOUBLE','FREE'),
                (204,'DOUBLE','FREE'),
                (205,'DOUBLE','FREE'),
                (206,'DOUBLE','FREE'),
                (207,'DOUBLE','FREE'),
                (208,'DOUBLE','FREE'),
                (209,'DOUBLE','FREE'),
                (210,'DOUBLE','FREE'),
                (301,'TRIPLE','FREE'),
                (302,'TRIPLE','FREE'),
                (303,'TRIPLE','FREE'),
                (304,'TRIPLE','FREE'),
                (305,'TRIPLE','FREE'),
                (401,'QUADRUPLE','FREE'),
                (402,'QUADRUPLE','FREE');
                
    
INSERT INTO TypeRoom(typology,price) VALUES
					('SINGLE',30.00),
                    ('DOUBLE',50.00),
                    ('TRIPLE',80.00),
                    ('QUADRUPLE',100.00);

INSERT INTO Booking	(id,	room,	client,				peopleNumber,	startDate,		endDate,		night, 	totalPrice,	deposit,	checkInDate,	checkOutDate) VALUES
					(1,		101,	'RSSMRA87C24A522K',	1,				'2017-06-22',	'2017-06-28',	6,		180.00,		50.00,		'',				''			),	
                    (2,		201,	'FRSGVN78D20N456L',	2,				'2017-07-20',	'2017-07-27',	7,		350.00,		100.00,		'',				''			),
                    (3,		401,	'LPVDES67F13L234C',	4,				'2017-06-18',	'2017-06-26',	8,		800.00,		200.00,		'',				''			),	
                    (4,		301,	'LKJMRD56E12P990E',	3,				'2017-08-10',	'2017-08-17',	7,		560.00,		100.00,		'',				''			),
                    (5,		202,	'PLRSRD78D30O433T',	2,				'2017-07-15',	'2017-07-18',	3,		100.00,		50.00,		'',				''			),
					(6,		201,	'FRSGVN78D20N456L',	2,				'2017-08-20',	'2017-08-27',	7,		350.00,		100.00,		'',				''			);
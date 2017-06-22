package com.sopra.hotel.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.sopra.hotel.controllers.BookingController;
import com.sopra.hotel.controllers.ClientController;
import com.sopra.hotel.controllers.RoomController;
import com.sopra.hotel.controllers.TypeRoomController;
import com.sopra.hotel.data.BookingData;
import com.sopra.hotel.data.ClientData;
import com.sopra.hotel.data.RoomData;
import com.sopra.hotel.data.TypeRoomData;

public class HotelView {
	private static TypeRoomController typeRoomController;
	private static RoomController roomController;
	private static ClientController clientController;
	private static BookingController bookingController;
	private static TypeRoomData typeRoomData;
	private static RoomData roomData;
	private static ClientData clientData;
	private static BookingData bookingData;
	
	public static <TypeRoomDate> void main(String[] args) throws ParseException {
		//Loading TypeRoom DB
		typeRoomData=new TypeRoomData();
		typeRoomController = new TypeRoomController();
		List<TypeRoomData> typesRoom = new ArrayList<TypeRoomData>();
		typesRoom = typeRoomController.getAll();
		
		//Loading Room DB
		roomData=new RoomData();
		roomController = new RoomController();
		List<RoomData> rooms = new ArrayList<RoomData>();
		rooms=roomController.getAll();
		
		//Loading Client DB
		clientData=new ClientData();
		clientController = new ClientController();
		List<ClientData> clients = new ArrayList<ClientData>();
		clients=clientController.getAll();
		int lastIdClient=clients.get((clients.size())-1).getIdClient();
		
		//Loading Booking DB
		bookingData=new BookingData();
		bookingController = new BookingController();
		List<BookingData> bookings = new ArrayList<BookingData>();
		bookings=bookingController.getAll();
		int lastIdBooking=bookings.get(bookings.size()-1).getIdBooking();
		
		
		Scanner scan = new Scanner(System.in);
		String choise;
		String menu = "***BOOKING*** SCEGLI L'OPERAZIONE DA ESEGUIRE E INSERISCI IL NUMERO CORRISPONDENTE:\n"
				+ "1) Visualizza prenotazioni\n" + "2) Visualizza camere libere\n" + "3) Prenota camera\n"
				+ "4) Check IN\n" + "5) Check OUT\n" + "6) Chiudi applicazione\n";
		do {
			System.out.println(menu);
			choise = scan.nextLine();
			if ((choise.length() == 1) && Integer.parseInt(choise) > 0 && Integer.parseInt(choise) < 7) {
				switch (Integer.parseInt(choise)) {
				case 1: {
					System.out.println("***Visualizza prenotazioni***");
					System.out.println(bookingController.showAll());
				}
					break;
				case 2:
					System.out.println("***Visualizza camere libere***");
					System.out.println(roomController.showAllRoomFree());
					break;
				case 3:
					try {
						System.out.println("***Prenota camera***");
						boolean roomExists=false;
						int idRoom;
						do {System.out.println("Inserire numero Camera da prenotare --->");
							int roomNumber = scan.nextInt();
							idRoom=roomController.getIdRoom(roomNumber);
							if (idRoom!=0){
								roomExists=true;
							}
						}while(!roomExists);
						System.out.println("Inserire Codice Fiscale Cliente --->");
						String fiscalCode = scan.next();
						System.out.println("Inserire numero DI PERSONE in camera--->");
						int peopleNumber = scan.nextInt();
						System.out.println("Inserire Data iniziale di soggiorno (nella forma: AAAA-MM-GG --->");
						String date = scan.next();
						DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
						Date startDate = df.parse(date);
						System.out.println("Inserire Data finale di soggiorno (nella forma: AAAA-MM-GG --->");
						date = scan.next();
						df = new SimpleDateFormat("yyyy/mm/dd");
						Date endDate = df.parse(date);
						Calendar c1 = Calendar.getInstance();
						Calendar c2 = Calendar.getInstance();
						c1.setTime(startDate);
						c2.setTime(endDate);
						long giorni = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
						//TO DO: Controllare la disponibilità della camera nel periodo richiesto
						
						int nightNumber = (int) giorni;
						System.out.println("Inserire prezzo totale --->");
						double totalPrice = scan.nextDouble();
						System.out.println("Inserire acconto pagato --->");
						double deposit = scan.nextDouble();
						
						//Se il cliente non è già registrato chiediamo i dati del cliente e lo aggiungiamo:
						if (!clientController.getByFiscalCode(fiscalCode)){
							System.out.println("Inserire i dati del nuovo Cliente --->");
							System.out.println("Inserire nome --->");
							String name = scan.next();
							System.out.println("Inserire cognome --->");
							String surname = scan.next();
							System.out.println("Inserire Data di nascita --->");
							String dateOfBirth = scan.next();
							System.out.println("Inserire indirizzo --->");
							String address = scan.next();
							System.out.println("Inserire città --->");
							String city = scan.next();
							System.out.println("Inserire Paese --->");
							String country = scan.next();
							System.out.println("Inserire numero di Telefono --->");
							String phoneNumber = scan.next();
							ClientData clientData=new ClientData();
							clientData.setIdClient(lastIdClient+1);
							clientData.setFiscalCode(fiscalCode);
							clientData.setName(name);
							clientData.setSurname(surname);
							clientData.setDateOfBirth(dateOfBirth);
							clientData.setAddress(address);
							clientData.setCity(city);
							clientData.setCountry(country);
							clientData.setPhoneNumber(phoneNumber);
							clientController.newClient(clientData);
							lastIdClient++;
						}
						BookingData bookingData = new BookingData();
						bookingData.setIdBooking(lastIdBooking+1);
						bookingData.setIdRoom(idRoom);
						bookingData.setIdClient(clientController.getIdClient(fiscalCode));
						bookingData.setPeopleNumber(peopleNumber);
						bookingData.setStartDate(startDate.toString());
						bookingData.setEndDate(endDate.toString());
						bookingData.setNightNumber(nightNumber);
						bookingData.setTotalPrice(totalPrice);
						bookingData.setDeposit(deposit);
						if(bookingController.newBooking(bookingData)){
							lastIdBooking++;
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
					break;
				case 4:{
					System.out.println("***Check IN***");
//					System.out.println("Inserire numero Camera per CHECK-IN --->");
//					int roomNumber = scan.nextInt();
					boolean roomExists=false;
					int idRoom;
					int roomNumber;
					do {System.out.println("Inserire numero Camera per CHECK-IN --->");
						roomNumber = scan.nextInt();
						idRoom=roomController.getIdRoom(roomNumber);
						if (idRoom!=0){
							roomExists=true;
						}
					}while(!roomExists);
					System.out.println("Inserire DATA di Oggi per il CHECK-IN --->");
					String date = scan.next();
					DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
					Date checkInDate = df.parse(date);
					System.out.println(roomController.checkIn(roomNumber));
					bookingController.checkIn(roomNumber, checkInDate.toString());
				}
					break;
				case 5:{
					System.out.println("***Check OUT***");
//					System.out.println("Inserire numero Camera per CHECK-OUT --->");
//					roomNumber = scan.nextInt();
					boolean roomExists=false;
					int idRoom;
					int roomNumber;
					do {System.out.println("Inserire numero Camera per CHECK-IN --->");
						roomNumber = scan.nextInt();
						idRoom=roomController.getIdRoom(roomNumber);
						if (idRoom!=0){
							roomExists=true;
						}
					}while(!roomExists);
					System.out.println("Inserire DATA di Oggi per il CHECK-OUT --->");
					String date = scan.next();
					DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
					Date checkOutDate = df.parse(date);
					System.out.println(roomController.checkIn(roomNumber));
					bookingController.checkIn(roomNumber, checkOutDate.toString());
				}
					break;
				case 6:
					System.out.println("***Chiudi applicazione***");
					break;
				default:
					System.out.println("Scelta errata!");
					break;
				}
			} else {
				System.out.println("ERROR!!!\n");
			}
		} while (Integer.parseInt(choise) != 6);
		System.out.println("Arrivederci!");
		scan.close();
	}

	public static TypeRoomController getTypeRoomController() {
		return typeRoomController;
	}

	public static void setTypeRoomController(TypeRoomController typeRoomController) {
		HotelView.typeRoomController = typeRoomController;
	}

	public static RoomController getRoomController() {
		return roomController;
	}

	public static void setRoomController(RoomController roomController) {
		HotelView.roomController = roomController;
	}

	public static ClientController getClientController() {
		return clientController;
	}

	public static void setClientController(ClientController clientController) {
		HotelView.clientController = clientController;
	}

	public static BookingController getBookingController() {
		return bookingController;
	}

	public static void setBookingController(BookingController bookingController) {
		HotelView.bookingController = bookingController;
	}

	public static TypeRoomData getTypeRoomData() {
		return typeRoomData;
	}

	public static void setTypeRoomData(TypeRoomData typeRoomData) {
		HotelView.typeRoomData = typeRoomData;
	}

	public static RoomData getRoomData() {
		return roomData;
	}

	public static void setRoomData(RoomData roomData) {
		HotelView.roomData = roomData;
	}

	public static ClientData getClientData() {
		return clientData;
	}

	public static void setClientData(ClientData clientData) {
		HotelView.clientData = clientData;
	}

	public static BookingData getBookingData() {
		return bookingData;
	}

	public static void setBookingData(BookingData bookingData) {
		HotelView.bookingData = bookingData;
	}
	
}

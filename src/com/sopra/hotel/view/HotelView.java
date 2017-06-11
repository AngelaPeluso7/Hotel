package com.sopra.hotel.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.sopra.hotel.controllers.BookingController;
import com.sopra.hotel.controllers.RoomController;
import com.sopra.hotel.models.BookingModel;
import com.sopra.hotel.models.ClientModel;
import com.sopra.hotel.models.RoomModel;

public class HotelView {
	private static int id=6;
	public static void main (String[] args){
		BookingController bookingController=new BookingController();
		RoomController roomController=new RoomController();
		Scanner scan = new Scanner(System.in);
		String chois;
		String menu="***BOOKING*** SCEGLI L'OPERAZIONE DA ESEGUIRE E INSERISCI IL NUMERO SCELTO:\n"
				+"1) Visualizza prenotazioni\n"
				+"2) Visualizza camere libere\n"
				+"3) Prenota camera\n"
				+"4) Check IN\n"
				+"5) Check OUT\n"
				+"6) Chiudi applicazione\n";
		do{
			System.out.println(menu);
			chois=scan.nextLine();
			if ((chois.length()==1) && Integer.parseInt(chois)>0 && Integer.parseInt(chois)<7){
					switch(Integer.parseInt(chois)){
					case 1:
						System.out.println("***Visualizza prenotazioni***");
						System.out.println(bookingController.viewAllReservation());
						break;
					case 2:
						System.out.println("***Visualizza camere libere***");
						System.out.println(roomController.viewAllRoomFree());
						break;
					case 3:
						try {
						    System.out.println("***Prenota camera***");
						    id++;
						    System.out.println("Inserire numero Camera da prenotare --->");
						    int room=scan.nextInt();
						    System.out.println("Inserire numero Codice Fiscale Cliente --->");
						    String client=scan.next();
						    System.out.println("Inserire numero DI PERSONE in camera--->");
						    int peopleNumber=scan.nextInt();
						    System.out.println("Inserire Data iniziale di soggiorno (nella forma: AAAA-MM-GG --->");
				        	String date=scan.next();
				        	DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
				        	Date startDate = df.parse(date);
				        	System.out.println("Inserire Data finale di soggiorno (nella forma: AAAA-MM-GG --->");
				        	date=scan.next();
				        	df = new SimpleDateFormat("yyyy/mm/dd");
				        	Date endDate = df.parse(date);
				        	Calendar c1 = Calendar.getInstance();
				        	Calendar c2 = Calendar.getInstance();
				        	c1.setTime(startDate);
				        	c2.setTime(endDate);
				        	long giorni = (c2.getTime().getTime() - c1.getTime().getTime())    / (24 * 3600 * 1000);
				        	int nightNumber=(int) giorni;
				        	System.out.println("Inserire prezzo totale --->");
							double totalPrice=scan.nextDouble();
							System.out.println("Inserire acconto pagato --->");
							double deposit=scan.nextDouble();
							RoomModel roomModel=new RoomModel();
							roomModel.setNumber(room);
							ClientModel clientModel=new ClientModel();
							clientModel.setFiscalCode(client);
							BookingModel bookingModel=new BookingModel();
							//TODO Metodo che restituisce l'ultimo id utilizzato
							bookingModel.setId(id);
							bookingModel.setRoom(roomModel);
							bookingModel.setClient(clientModel);
							bookingModel.setPeopleNumber(peopleNumber);
							bookingModel.setStartDate((java.sql.Date) startDate);
							bookingModel.setEndDate((java.sql.Date) endDate);
							bookingModel.setNightNumber(nightNumber);
							bookingModel.setTotalPrice(totalPrice);
							bookingModel.setDeposit(deposit);
							bookingController.newReservation(bookingModel);
						} catch (ParseException e) {
				            e.printStackTrace();
				        }
						break;
					case 4:
						System.out.println("***Check IN***");
						System.out.println("Inserire numero Camera per CHECK-IN --->");
						chois=scan.nextLine();
						System.out.println(roomController.checkIn(Integer.parseInt(chois)));
						//TODO Metodo in Booking che inserisce la check in date nel model
						break;
					case 5:
						System.out.println("***Check OUT***");
						System.out.println("Inserire numero Camera per CHECK-OUT --->");
						chois=scan.nextLine();
						System.out.println(roomController.checkOut(Integer.parseInt(chois)));
						//TODO Metodo in Booking che inserisce la check out date nel model
						break;
					case 6:
						System.out.println("***Chiudi applicazione***");
						break;
					default:
						System.out.println("Scelta errata!");
						break;
					}
			}
			else{
				System.out.println("ERRORR!!! Bisogna inserire un numero da 1 a 6\n");
			}
		}while(Integer.parseInt(chois)!=6 );
		System.out.println("Arrivederci!");
		scan.close();	
	}
}

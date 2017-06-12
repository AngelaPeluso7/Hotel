package com.sopra.hotel.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sopra.hotel.DAO.BookingDAO;
import com.sopra.hotel.models.BookingModel;
import com.sopra.hotel.models.ClientModel;
import com.sopra.hotel.models.RoomModel;

public class DefaultBookingDAO implements BookingDAO {
	final static Logger log=Logger.getLogger(DefaultBookingDAO.class);
	
	public boolean newReservation(BookingModel bookingModel) {
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String insert = "INSERT INTO Booking(id,room,client,peopleNumber,startDate, "
            		+ " endDate,nightNumber,totalPrice,deposit,checkInDate,checkOutDate) VALUES "
					+ " (?,?,?,?,?,?,?,?,?,?,?) ; ";
            PreparedStatement stmt = conn.prepareStatement(insert);
            stmt.setInt(1,bookingModel.getId());
            stmt.setInt(2,bookingModel.getRoom().getNumber());
            stmt.setString(3,bookingModel.getClient().getFiscalCode());
            stmt.setInt(4,bookingModel.getPeopleNumber());
            stmt.setDate(5,bookingModel.getStartDate());
            stmt.setDate(6,bookingModel.getEndDate());
            stmt.setInt(7,bookingModel.getNightNumber());
            stmt.setDouble(8,bookingModel.getTotalPrice());
            stmt.setDouble(9,bookingModel.getDeposit());
            stmt.setDate(10,bookingModel.getCheckInDate());
            stmt.setDate(11,bookingModel.getCheckOutDate());
            if (stmt.executeUpdate()>0) {
                return true;
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;
	}
	
	public List<BookingModel> viewAllReservation(){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT b.id, b.room, b.client, b.peopleNumber, b.startDate, b.endDate, b.nightNumber, b.totalPrice,b.deposit, b.checkInDate,b.checkOutDate FROM booking as b; ";
            //SELECT b.room, b.client, c.name, c.surname, b.startDate, b.endDate FROM booking as b JOIN client as c on {c.fiscalCode}={b.client};
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            if (result.first()) {
            	final List<BookingModel> reservationsList=new ArrayList<BookingModel>();
            	while (result.next()){
            		BookingModel reservation=new BookingModel();
            		RoomModel room=new RoomModel();
            		ClientModel client=new ClientModel();
            		reservation.setId(result.getInt("id"));
            		room.setNumber(result.getInt("number"));
            		reservation.setRoom(room);
            		client.setFiscalCode(result.getString("client"));
            		reservation.setClient(client);
            		reservation.setPeopleNumber(result.getInt("peopleNumber"));
            		reservation.setStartDate(result.getDate("startDate"));
            		reservation.setEndDate(result.getDate("endDate"));
                    reservation.setNightNumber(result.getInt("nightNumber"));
                    reservation.setTotalPrice(result.getDouble("totalPrice"));
                    reservation.setDeposit(result.getDouble("deposit"));
                    reservation.setCheckInDate(result.getDate("checkInDate"));
                    reservation.setCheckOutDate(result.getDate("checkOutDate"));
            		reservationsList.add(reservation);
            	}   
            	return reservationsList;
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
		return null;
	}
	
	public BookingModel getBooking(int id){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT b.room, b.client, b.peopleNumber, b.startDate, b.endDate, b.nightNumber, b.totalPrice,b.deposit, b.checkInDate,b.checkOutDate FROM booking as b; WHERE b.id=? ";
            //SELECT b.room, b.client, c.name, c.surname, b.startDate, b.endDate FROM booking as b JOIN client as c on {c.fiscalCode}={b.client};
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            ResultSet result = stmt.executeQuery();
            if (result.first()) {
            	final List<BookingModel> reservationsList=new ArrayList<BookingModel>();
            	while (result.next()){
            		BookingModel reservation=new BookingModel();
            		RoomModel room=new RoomModel();
            		ClientModel client=new ClientModel();
            		reservation.setId(id);
            		room.setNumber(result.getInt("number"));
            		reservation.setRoom(room);
            		client.setFiscalCode(result.getString("client"));
            		reservation.setClient(client);
            		reservation.setPeopleNumber(result.getInt("peopleNumber"));
            		reservation.setStartDate(result.getDate("startDate"));
            		reservation.setEndDate(result.getDate("endDate"));
                    reservation.setNightNumber(result.getInt("nightNumber"));
                    reservation.setTotalPrice(result.getDouble("totalPrice"));
                    reservation.setDeposit(result.getDouble("deposit"));
                    reservation.setCheckInDate(result.getDate("checkInDate"));
                    reservation.setCheckOutDate(result.getDate("checkOutDate"));
            		reservationsList.add(reservation);
            	}   
            	return reservationsList.get(0);
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
		return null;
	}
	public int getLastId(){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        int lastId=0;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT b.id FROM booking as b; ";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            if (result.first()) {
            	final List<BookingModel> reservationsId=new ArrayList<BookingModel>();
            	while (result.next()){
            		BookingModel reservation=new BookingModel();
            		reservation.setId(result.getInt("id"));
            		reservationsId.add(reservation);
            	}   
            	int last=reservationsId.size()-1;
            	lastId=reservationsId.indexOf(last);
            }
            
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
		return lastId;
	}
}

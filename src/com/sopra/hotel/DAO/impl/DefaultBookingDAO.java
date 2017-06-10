package com.sopra.hotel.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String query = "SELECT b.room, b.client, b.startDate, b.endDate FROM booking as b; ";
            //SELECT b.room, b.client, c.name, c.surname, b.startDate, b.endDate FROM booking as b JOIN client as c on {c.fiscalCode}={b.client};
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            if (result.first()) {
            	List<BookingModel> reservationsList=null;
            	while (result.next()){
            		BookingModel reservation=new BookingModel();
            		RoomModel room=new RoomModel();
            		ClientModel client=new ClientModel();
            		room.setNumber(result.getInt("number"));
            		reservation.setRoom(room);
            		client.setFiscalCode(result.getString("client"));
            		reservation.setClient(client);
            		reservation.setStartDate(result.getDate("startDate"));
            		reservation.setEndDate(result.getDate("endDate"));
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
}

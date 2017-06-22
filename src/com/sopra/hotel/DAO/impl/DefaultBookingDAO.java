package com.sopra.hotel.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sopra.hotel.DAO.BookingDAO;
import com.sopra.hotel.models.BookingModel;

public class DefaultBookingDAO implements BookingDAO {
	final static Logger log = Logger.getLogger(DefaultBookingDAO.class);
	
	public boolean newBooking(BookingModel bookingModel) {
		Connection conn=null;
		try {
			conn=connection();
			String insert = "INSERT INTO Booking(idBooking,idRoom,idClient,peopleNumber,startDate, "
					+ " endDate,nightNumber,totalPrice,deposit,checkInDate,checkOutDate) VALUES "
					+ " (?,?,?,?,?,?,?,?,?,?,?) ; ";
			PreparedStatement stmt = conn.prepareStatement(insert);
			stmt.setInt(1, bookingModel.getIdBooking());
			stmt.setInt(2, bookingModel.getIdRoom());
			stmt.setInt(3, bookingModel.getIdClient());
			stmt.setInt(4, bookingModel.getPeopleNumber());
			stmt.setDate(5, bookingModel.getStartDate());
			stmt.setDate(6, bookingModel.getEndDate());
			stmt.setInt(7, bookingModel.getNightNumber());
			stmt.setDouble(8, bookingModel.getTotalPrice());
			stmt.setDouble(9, bookingModel.getDeposit());
			stmt.setDate(10, bookingModel.getCheckInDate());
			stmt.setDate(11, bookingModel.getCheckOutDate());
			if (stmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			log.error(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

	public List<BookingModel> findAll() {
		Connection conn=null;
		try {
			conn=connection();
			String query = "SELECT b.idBooking, b.idRoom, b.idClient, b.peopleNumber, b.startDate, b.endDate, "
					+ "b.nightNumber, b.totalPrice,b.deposit, b.checkInDate,b.checkOutDate FROM booking as b; ";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			final List<BookingModel> reservationsList = new ArrayList<BookingModel>();
			while (result.next()) {
				BookingModel reservation = new BookingModel();
				reservation.setId(result.getInt("idBooking"));
				reservation.setIdRoom(result.getInt("idRoom"));
				reservation.setIdClient(result.getInt("idClient"));
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
		} catch (SQLException e) {
			log.error(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	public BookingModel findById(int idBooking) {
		Connection conn = null;
		try {
			conn=connection();
			String query = "SELECT b.idRoom, b.idClient, b.peopleNumber, b.startDate, b.endDate, "
					+ "b.nightNumber, b.totalPrice,b.deposit, b.checkInDate,b.checkOutDate FROM booking as b; WHERE b.idBooking=? ";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, idBooking);
			ResultSet result = stmt.executeQuery();
			final List<BookingModel> reservationsList = new ArrayList<BookingModel>();
			while (result.next()) {
				BookingModel reservation = new BookingModel();
				reservation.setId(idBooking);
				reservation.setIdRoom(result.getInt("idRoom"));
				reservation.setIdClient(result.getInt("idClient"));
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

		} catch (SQLException e) {
			log.error(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	public boolean checkIn(int roomNumber,Date checkInDate){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "UPDATE booking SET checkInDate=? "
                    + "WHERE room.number = ? ;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDate(1, (java.sql.Date) checkInDate);
            stmt.setInt(2,roomNumber);
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;
	}
	
	public boolean checkOut(int roomNumber,Date checkOutDate){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "UPDATE booking SET checkOutDate=? "
                    + "WHERE room.number = ? ;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDate(1, (java.sql.Date) checkOutDate);
            stmt.setInt(2,roomNumber);
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;
	}
	
	public Connection connection(){
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

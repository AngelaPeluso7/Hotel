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
import com.sopra.hotel.DAO.RoomDAO;
import com.sopra.hotel.models.ActualState;
import com.sopra.hotel.models.RoomModel;

public class DefaultRoomDAO implements RoomDAO {
	final static Logger log=Logger.getLogger(DefaultRoomDAO.class);
	
	public DefaultRoomDAO() {
	}

	public boolean checkIsFree(int roomNumber){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT r.actualState FROM room r WHERE r.number =? ; ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,String.valueOf(roomNumber));
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
            	String state = result.getString("actualState");
            	if (state.equals("FREE")){
            		return true;
            	}
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
		return false;
	}
	
	public boolean checkIsBusy(int roomNumber){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT r.actualState FROM room r WHERE r.number =? ; ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,String.valueOf(roomNumber));
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
            	String state = result.getString("actualState");
            	if (state.equals("BUSY")){
            		return true;
            	}
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
		return false;
	}
	
	public List<RoomModel> findAllRoomFree(){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT r.number FROM room r WHERE r.actualState = 'FREE' ; ";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            if (result.first()) {
            	final List<RoomModel> roomsList=new ArrayList<RoomModel>();
            	while (result.next()){
            		int n = result.getInt("number");
            		RoomModel roomModel=new RoomModel();
            		roomModel.setNumber(n);
            		roomsList.add(roomModel);
            	}   
            	return roomsList;
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
		return null;
	}
	
	public boolean checkIn(int roomNumber){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "UPDATE room SET actualState='BUSY' "
                    + "WHERE room.number = ? ;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, String.valueOf(roomNumber));
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
	public boolean checkOut(int roomNumber){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "UPDATE room SET actualState='FREE' "
                    + "WHERE room.number = ? ;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, String.valueOf(roomNumber));
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
	public List<RoomModel> findAll(){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT r.idRoom,r.number,r.actualState,r.idType FROM room r  ; ";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            final List<RoomModel> roomsList=new ArrayList<RoomModel>();
            while (result.next()){
            	RoomModel roomModel=new RoomModel();
            	roomModel.setIdRoom(result.getInt("idRoom"));
            	roomModel.setNumber(result.getInt("number"));
            	roomModel.setActualState(ActualState.valueOf(result.getString("actualState")));
            	roomModel.setIdType(result.getInt("idType"));
            	roomsList.add(roomModel);
            }   
            return roomsList;
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
		return null;
	}
	public RoomModel findById(int idRoom) {
		Connection conn = null;
		try {
			conn=connection();
			String query = "SELECT r.number,r.actualState,r.idType "
					+ "FROM room as r ; WHERE r.idRoom=? ";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, idRoom);
			ResultSet result = stmt.executeQuery();
			final List<RoomModel> roomsList = new ArrayList<RoomModel>();
			while (result.next()) {
				RoomModel roomModel=new RoomModel();
            	roomModel.setIdRoom(result.getInt("idRoom"));
            	roomModel.setNumber(result.getInt("number"));
            	roomModel.setActualState(ActualState.valueOf(result.getString("actualState")));
            	roomModel.setIdType(result.getInt("idType"));
				roomsList.add(roomModel);
			}
			return roomsList.get(0);

		} catch (SQLException e) {
			log.error(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	
	public int findIdRoom(int number){
		Connection conn = null;
		try {
			conn=connection();
			String query = "SELECT r.idRoom "
					+ "FROM room as r ; WHERE r.number=? ";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, number);
			ResultSet result = stmt.executeQuery();
			final List<RoomModel> roomsList = new ArrayList<RoomModel>();
			while (result.next()) {
				RoomModel roomModel=new RoomModel();
            	roomModel.setIdRoom(result.getInt("idRoom"));
				roomsList.add(roomModel);
			}
			return roomsList.get(0).getIdRoom();

		} catch (SQLException e) {
			log.error(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return 0;
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

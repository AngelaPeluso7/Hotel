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
import com.sopra.hotel.DAO.TypeRoomDAO;
import com.sopra.hotel.models.TypeRoomModel;
import com.sopra.hotel.models.Typology;

public class DefaultTypeRoomDAO implements TypeRoomDAO {

	final static Logger log=Logger.getLogger(DefaultTypeRoomDAO.class);
	
	public DefaultTypeRoomDAO() {
	}

	public double findPrice(Typology typology) {
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT t.price FROM typeroom t WHERE t.typology =? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,typology.toString());
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
            	return result.getDouble("price");
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return -1;
	}
	
	 public boolean updateNewPrice(Typology typology, double newPrice) {
	        MysqlDataSource dataSource = new MysqlDataSource();
	        dataSource.setUser("root");
	        dataSource.setPassword("root");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/Rubrica");
	        Connection conn = null;
	        try {
	            conn = dataSource.getConnection();
	            String query = "UPDATE persona SET price = ?"
	                    + " WHERE typeroom.typology = ? ;";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setString(1, Double.toString(newPrice));
	            stmt.setString(2, typology.toString());
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
	 
	 public List<TypeRoomModel> findAll() {
			Connection conn=null;
			try {
				conn=connection();
				String query = "SELECT t.idTypeRoom, t.typology, t.price "
						+ " FROM typeRoom as t; ";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet result = stmt.executeQuery();
				final List<TypeRoomModel> typeRoomsList = new ArrayList<TypeRoomModel>();
				while (result.next()) {
					TypeRoomModel typeRoom = new TypeRoomModel();
					typeRoom.setIdTypeRoom((result.getInt("idTypeRoom")));
					typeRoom.setTypology(Typology.valueOf(result.getString("typology")));
					typeRoom.setPrice(result.getDouble("price"));
					typeRoomsList.add(typeRoom);
				}
				return typeRoomsList;
			} catch (SQLException e) {
				log.error(e);
			} finally {
				DbUtils.closeQuietly(conn);
			}
			return null;
		}

		public TypeRoomModel findById(int idTypeRoom) {
			Connection conn = null;
			try {
				conn=connection();
				String query = "SELECT t.typology, t.price "
						+ "FROM typeRoom as t ; WHERE t.idTypeRoom=? ";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1, idTypeRoom);
				ResultSet result = stmt.executeQuery();
				final List<TypeRoomModel> typeRoomsList = new ArrayList<TypeRoomModel>();
				while (result.next()) {
					TypeRoomModel typeRoom = new TypeRoomModel();
					typeRoom.setIdTypeRoom(idTypeRoom);
					typeRoom.setTypology(Typology.valueOf(result.getString("typology")));
					typeRoom.setPrice(result.getDouble("price"));
					typeRoomsList.add(typeRoom);
				}
				return typeRoomsList.get(0);

			} catch (SQLException e) {
				log.error(e);
			} finally {
				DbUtils.closeQuietly(conn);
			}
			return null;
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

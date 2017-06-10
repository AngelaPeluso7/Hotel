package com.sopra.hotel.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sopra.hotel.DAO.TypeRoomDAO;
import com.sopra.hotel.models.Typology;

public class DefaultTypeRoomDAO implements TypeRoomDAO {

	final static Logger log=Logger.getLogger(DefaultTypeRoomDAO.class);
	
	public double getPrice(Typology typology) {
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
            if (result.first()) {
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
	                    + "WHERE typeroom.typology = ? ;";
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
	 
//public boolean newTypeRoom(String newTypeRoom, double price) {
//     MysqlDataSource dataSource = new MysqlDataSource();
//     dataSource.setUser("root");
//     dataSource.setPassword("root");
//     dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
//     Connection conn = null;
//     try {
//         conn = dataSource.getConnection();
//         String insert = "INSERT INTO TypeRoom ((typology,price) VALUES (?,?);";
//         PreparedStatement stmt = conn.prepareStatement(insert);
//         stmt.setString(1,newTypeRoom);
//         stmt.setDouble(2,price);
//         if (stmt.executeUpdate()>0) {
//         	//Typology.add(newTypeRoom);
//             return true;
//         }
//     } catch (SQLException e) {
//         log.error(e);
//     } finally {
//         DbUtils.closeQuietly(conn);
//     }
//     return false;
//	}
	
}

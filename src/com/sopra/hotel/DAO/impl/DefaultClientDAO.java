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
import com.sopra.hotel.DAO.ClientDAO;
import com.sopra.hotel.models.ClientModel;

public class DefaultClientDAO implements ClientDAO {

	final static Logger log=Logger.getLogger(DefaultClientDAO.class);
	
	public DefaultClientDAO() {
	}
	
	public boolean newClient(ClientModel clientModel) {
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String insert = "INSERT INTO Client  (idClient, fiscalCode,name,surname,dateOfBirth, "
            				+ " address,city,country,phoneNumber) VALUES "
            				+ "(?,?,?,?,?, ?,?,?,?); ";
            PreparedStatement stmt = conn.prepareStatement(insert);
            stmt.setInt(1, clientModel.getIdClient());
            stmt.setString(2,clientModel.getFiscalCode());
            stmt.setString(3,clientModel.getName());
            stmt.setString(4,clientModel.getSurname());
            stmt.setString(5,clientModel.getDateOfBirth());
            stmt.setString(6,clientModel.getAddress());
            stmt.setString(7,clientModel.getCity());
            stmt.setString(8,clientModel.getCountry());
            stmt.setString(9,clientModel.getPhoneNumber());
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
	public ClientModel findById(int idClient) {
		ClientModel clientModel=new ClientModel();
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT c.fiscalCode, c.name, c.surname, c.phoneNumber , c.dateOfBirth, c.address, c.city, c.country "
            			+ "FROM client c "
            			+ "WHERE c.idClient = ? ; ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,idClient);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
            	clientModel.setIdClient(idClient);
            	clientModel.setFiscalCode(result.getString("fiscalCode"));
                clientModel.setName(result.getString("name"));
                clientModel.setSurname(result.getString("surname"));
                clientModel.setPhoneNumber(result.getString("phoneNumber"));
                clientModel.setDateOfBirth(result.getString("dateOfBirth"));
                clientModel.setAddress(result.getString("address"));
                clientModel.setCity(result.getString("city"));
                clientModel.setCountry(result.getString("country"));  
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return clientModel;
	}
	public ClientModel findByFiscalCode(String fiscalCode) {
		ClientModel clientModel=new ClientModel();
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT c.idClient,c.name, c.surname, c.dateOfBirth, c.phoneNumber , c.address, c.city, c.country "
            			+ "FROM client c "
            			+ "WHERE c.fiscalCode = ? ; ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,fiscalCode);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
            	clientModel.setIdClient(result.getInt("idClient"));
                clientModel.setName(result.getString("name"));
                clientModel.setSurname(result.getString("surname"));
                clientModel.setFiscalCode(result.getString("phoneNumber"));
                clientModel.setDateOfBirth(result.getString("dateOfBirth"));
                clientModel.setAddress(result.getString("address"));
                clientModel.setCity(result.getString("city"));
                clientModel.setCountry(result.getString("country"));  
                clientModel.setPhoneNumber(fiscalCode);
            }
            else{
            	clientModel=null;
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return clientModel;
	}
	
	public ClientModel findByNumber(String phoneNumber) {
		ClientModel clientModel=new ClientModel();
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT c.name, c.surname, c.fiscalCode , c.address, c.city, c.country "
            			+ "FROM client c "
            			+ "WHERE c.phoneNumber = ? ; ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,phoneNumber);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
            	clientModel.setIdClient(result.getInt("idClient"));
                clientModel.setName(result.getString("name"));
                clientModel.setSurname(result.getString("surname"));
                clientModel.setDateOfBirth(result.getString("dateOfBirth"));
                clientModel.setFiscalCode(result.getString("fiscalCode"));
                clientModel.setAddress(result.getString("address"));
                clientModel.setCity(result.getString("city"));
                clientModel.setCountry(result.getString("country"));  
                clientModel.setPhoneNumber(phoneNumber);
            }
            else{
            	clientModel=null;
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return clientModel;
	}
	
	public List<ClientModel> findAll(){
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Hotel");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String query = "SELECT c.idClient, c.fiscalCode, c.name, c.surname, c.dateOfBirth , c.address, c.city, c.country, c.phoneNumber FROM client as c  ; ";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            final List<ClientModel> clientsList=new ArrayList<ClientModel>();
            while (result.next()){
            	ClientModel clientModel=new ClientModel();
            	clientModel.setIdClient(result.getInt("idClient"));
            	clientModel.setFiscalCode(result.getString("fiscalCode"));
                clientModel.setName(result.getString("name"));
                clientModel.setSurname(result.getString("surname"));
                clientModel.setDateOfBirth(result.getString("dateOfBirth"));
                clientModel.setAddress(result.getString("address"));
                clientModel.setCity(result.getString("city"));
                clientModel.setCountry(result.getString("country"));  
                clientModel.setPhoneNumber(result.getString("phoneNumber"));
            	clientsList.add(clientModel);
            }   
            return clientsList;
        } catch (SQLException e) {
            log.error(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
		return null;
	}
}

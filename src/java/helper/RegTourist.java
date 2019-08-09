/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author sudhan
 */
import dbConnection.DbConnect;
import beans.TouristBean;
import java.sql.*;
import java.util.Date;

public class RegTourist {
    
    private boolean regStatus;
    
    public boolean register(TouristBean tourist) throws SQLException{
        Connection con = null;
        try {
            con = DbConnect.getConnection();
           
            String sqlQuery = "INSERT INTO `tourist-user`(`firstName`, `lastName`, `emailAdd`, `username`, `password`, `dob`, `contactNumber`, `addNo`, `addStreet1`, `addStreet2`, `city`, `postalCode`, `country`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
                  String sqlQueryCreateTable = "CREATE TABLE "+tourist.getUsername()+"_tourist_event_history ("
                    + "Id int KEY AUTO_INCREMENT,"
                    + "eventName varchar(30),"
                    + "catOfEvent varchar(30),"
                    + "bookedDate Date,"
                    + "city varchar(30),"
                    + "orgBy varchar(30)"
                    + ")";
            
            
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            PreparedStatement stmTable = con.prepareStatement(sqlQueryCreateTable);
            
            stm.setString(1, tourist.getFirstName());
            stm.setString(2, tourist.getLastName());
            stm.setString(3, tourist.getEmailAdd());
            stm.setString(4, tourist.getUsername());
            stm.setString(5, tourist.getPassword());
            stm.setString(6, tourist.getDob());
            stm.setInt(7, tourist.getContactNumber() );
            stm.setString(8, tourist.getAddNo());
            stm.setString(9, tourist.getAddStreet1());
            stm.setString(10, tourist.getAddStreet2());
            stm.setString(11, tourist.getCity());
            stm.setInt(12, tourist.getPostalCode());
            stm.setString(13, tourist.getCountry());
            
            stm.execute();
            stmTable.execute();
            regStatus = true;
            //return regStatus;
        }
        catch (Exception e) {
            e.getMessage();
            regStatus = false;
        }
        finally{
            con.close();
            return regStatus;
        }
        
    }
}

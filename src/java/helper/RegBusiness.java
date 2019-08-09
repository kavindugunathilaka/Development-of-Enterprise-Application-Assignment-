/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import dbConnection.DbConnect;
import java.sql.*;
import beans.BusinessBean;
/**
 *
 * @author sudhan
 */
public class RegBusiness {
    
    private boolean regStatus;
    
    public boolean register(BusinessBean business) throws SQLException{
        
        Connection con = null;
        
        try {
            con =  DbConnect.getConnection();
            
            String sqlQuery = "INSERT INTO `business-user` (`ownerFirstName`, `ownerLastName`, `businessEmail`, `username`, `password`, `businessName`, `addNo`, `addStreet1`, `addStreet2`, `city`, `postalCode`, `province`, `approvelStatus`)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            
            stm.setString(1, business.getOwnerFirstName());
            stm.setString(2, business.getOwnerLastName());
            stm.setString(3, business.getBusinessEmail());
            stm.setString(4, business.getUsername());
            stm.setString(5, business.getPassword());
            stm.setString(6, business.getBusinessName());
            stm.setString(7, business.getAddNo());
            stm.setString(8, business.getAddStreet1());
            stm.setString(9, business.getAddStreet2());
            stm.setString(10, business.getCity());
            stm.setInt(11, business.getPostalCode());
            stm.setString(12, business.getProvince());
            stm.setString(13, business.getApprovelStatus());
            
            stm.execute();
            regStatus = true;
            
            return regStatus;
            
        } 
        catch (Exception e) {
            e.getStackTrace();
            regStatus = false;
        }
        finally{
            con.close();
            return regStatus;
        }
    }
    
    public boolean addAccApprovel(String username) throws SQLException{
        boolean approveStatus = false;
        Connection con = null;
        try {
            con = DbConnect.getConnection();
            
            String sqlQuery = "UPDATE `business-user` SET `approvelStatus` = 'approved' "
                    + " WHERE `username` = (?);";
        
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            stm.setString(1, username);
            
            int updatedRow = stm.executeUpdate();
            if (updatedRow >0){
                approveStatus = true;
            }
        } 
        catch (Exception e) {
            approveStatus = false;
        }
        finally{
            con.close();
            return approveStatus;
        }
    }
    
        public boolean addAccReject(String username) throws SQLException{
        boolean rejectStatus = false;
        Connection con = null;
        try {
            con = DbConnect.getConnection();
            
            String sqlQuery = "UPDATE `business-user` SET `approvelStatus` = 'rejected' "
                    + " WHERE `username` = (?);";
        
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            stm.setString(1, username);
            
            int updatedRow = stm.executeUpdate();
            if (updatedRow >0){
                rejectStatus = true;
                
            }
        } 
        catch (Exception e) {
            rejectStatus = false;
        }
        finally{
            con.close();
            return rejectStatus;
        }
    }
        
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.*;
import dbConnection.DbConnect;
import beans.AdminBean;
import beans.BusinessBean;
import beans.TouristBean;

/**
 *
 * @author sudhan
 */
public class AuthenUser {
    
    public int validateResult(ResultSet rslt) throws SQLException{
        
        rslt.last();
        int size = rslt.getRow(); 
        return size;
    }
    
    public boolean validateAdmin(AdminBean admin) throws SQLException{
        
        boolean loginStatus = false;
        Connection con = null;
        
        try {
            con = DbConnect.getConnection();
            
            String sqlQuery = "SELECT `password` FROM `admin-user` WHERE `username` = ?";
            
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            stm.setString(1, admin.getUsername());
            
            ResultSet rslt = stm.executeQuery();
 
            if (validateResult(rslt) == 0){
                return loginStatus;
            }
            
            String userEntered  = admin.getPassword();
            String dbRecord = rslt.getString("password");
            if (userEntered.equals(dbRecord)){
                loginStatus = true;
            }
        } 
        catch (Exception e) {
        
        }
        finally{
            con.close();
        }
        
      return loginStatus;
    }
    
        public boolean validateTourist(TouristBean tourist) throws SQLException{
        
        boolean loginStatus = false;
        Connection con = null;
        
        try {
            con = DbConnect.getConnection();
            
            String sqlQuery = "SELECT `password` FROM `tourist-user` WHERE `username` = (?)";
            
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            stm.setString(1, tourist.getUsername());
            
            ResultSet rslt = stm.executeQuery();
 
            if (validateResult(rslt) == 0){
                return loginStatus;
            }
            
            String userEntered  = tourist.getPassword();
            String dbRecord = rslt.getString("password");
            if (userEntered.equals(dbRecord)){
                loginStatus = true;
            }
        } 
        catch (Exception e) {
        
        }
        finally{
            con.close();
        }
        
      return loginStatus;
    }
    
        public boolean validateBusiness(BusinessBean business) throws SQLException{
        
            boolean loginStatus = false;
            Connection con = null;
        
            try {
                con = DbConnect.getConnection();
            
                String sqlQuery = "SELECT `password` FROM `business-user` WHERE `username` = (?) AND `approvelStatus` = 'approved'";
            
                PreparedStatement stm = con.prepareStatement(sqlQuery);
                stm.setString(1, business.getUsername());
            
                ResultSet rslt = stm.executeQuery();
 
                if (validateResult(rslt) == 0){
                    return loginStatus;
                }
            
                String userEntered  = business.getPassword();
                String dbRecord = rslt.getString("password");
                if (userEntered.equals(dbRecord)){
                    loginStatus = true;
                }
            } 
            catch (Exception e) {
        
            }
            finally{
                con.close();
            }
        
        return loginStatus;
        }   
    
        public AdminBean getAdminDetails(String username) throws SQLException  {
    
            AdminBean admin = null;
            Connection con = null;
            try {
                con = DbConnect.getConnection();
            
                String sqlQuery = "SELECT * FROM `admin-user` WHERE `username` = ?";
            
                PreparedStatement stm = con.prepareStatement(sqlQuery);
                stm.setString(1, username);
            
                ResultSet rslt = stm.executeQuery();
                
                admin.setFirstName(rslt.getString("firstname"));
                admin.setLastName(rslt.getString("lastname"));
                admin.setUsername(rslt.getString("username"));
                admin.setPassword(rslt.getString("password"));
            } 
            catch (Exception e) {
        
            }
            finally{
                con.close();
            }
        
        return admin;
        }
        
        public TouristBean getTouristDetails(String username) throws SQLException  {
    
            TouristBean tourist = null;
            Connection con = null;
            try {
                con = DbConnect.getConnection();
            
                String sqlQuery = "SELECT * FROM `tourist-user` WHERE `username` = ?";
            
                PreparedStatement stm = con.prepareStatement(sqlQuery);
                stm.setString(1, username);
            
                ResultSet rslt = stm.executeQuery();
                
                // set tourist value
                
            } 
            catch (Exception e) {
        
            }
            finally{
                con.close();
            }
        
        return tourist;
        }
        
        public BusinessBean getBusinessDetails(String username) throws SQLException  {
    
            BusinessBean business= null;
            Connection con = null;
            try {
                con = DbConnect.getConnection();
            
                String sqlQuery = "SELECT * FROM `business-user` WHERE `username` = ?";
            
                PreparedStatement stm = con.prepareStatement(sqlQuery);
                stm.setString(1, username);
            
                ResultSet rslt = stm.executeQuery();
 
                // set businsss value
            } 
            catch (Exception e) {
        
            }
            finally{
                con.close();
            }
        
        return business;
        }
}

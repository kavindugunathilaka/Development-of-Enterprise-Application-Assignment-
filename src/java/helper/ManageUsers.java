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
import java.sql.*;
import beans.BusinessBean;
import beans.TouristBean;
import java.util.ArrayList;
import java.util.List;

public class ManageUsers {
    
    public ArrayList<BusinessBean> getBusinessUsers(String status) throws SQLException{
        
        Connection con = null;
        ArrayList<BusinessBean> businessList = new ArrayList<BusinessBean>();
        
        try {
        con = DbConnect.getConnection();
        
        String  sqlQuery = "SELECT * FROM `business-user` WHERE `approvelStatus`=(?)";
        
        PreparedStatement stm = con.prepareStatement(sqlQuery);
        stm.setString(1, status);
        
        ResultSet rslt = stm.executeQuery();
        
            while(rslt.next()){
                BusinessBean business = new BusinessBean();
                
                business.setOwnerFirstName(rslt.getString("ownerFirstName"));
                business.setOwnerLastName(rslt.getString("ownerLastName"));
                business.setBusinessEmail(rslt.getString("businessEmail"));
                business.setUsername(rslt.getString("username"));
                business.setBusinessName(rslt.getString("businessName"));
                business.setAddNo(rslt.getString("addNo"));
                business.setAddStreet1(rslt.getString("addStreet1"));
                business.setAddStreet2(rslt.getString("addStreet2"));
                business.setCity(rslt.getString("city"));
                business.setPostalCode(rslt.getInt("postalCode"));
                business.setProvince(rslt.getString("province"));
            
                businessList.add(business);
            }
            
        } 
        catch (Exception e) {
        
        }
        finally{
            con.close();
        }
        return businessList;    
    }
    
    public TouristBean getTouristSingleUser(String username) throws SQLException{
        Connection con = null;
        TouristBean tourist = new TouristBean();
        
        try {
            con =DbConnect.getConnection();
            
            String sql = "SELECT * FROM `tourist-user` WHERE `username` =(?) ";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            
            ResultSet rslt = stm.executeQuery();
            if(rslt.next()){
                tourist.setFirstName(rslt.getString("firstName"));
                tourist.setLastName(rslt.getString("lastName"));
                tourist.setEmailAdd(rslt.getString("emailAdd"));
                tourist.setUsername(rslt.getString("username"));
            
                // Complete others also
            }
            else{
                tourist.setUsername(null);
            }
        } 
        catch (Exception e) {
            e.getMessage();
            tourist.setUsername(null);
        }
        finally{
            con.close();
            return tourist;
        }
        
    }
    
}

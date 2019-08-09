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
import java.sql.*;
import dbConnection.DbConnect;
import beans.EventBean;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.http.Part;

public class ManageEvent {
    
    public EventBean getSingleEvent(int eventId) throws SQLException{
        
        EventBean event = new EventBean();
        Connection con = null;
        
        try {
            con = DbConnect.getConnection();
            
            String sql = "SELECT * FROM `events-table` WHERE `eventId`= (?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, eventId);
            
            ResultSet rslt = stm.executeQuery();
            if (rslt.next()){
                event.setEventId(rslt.getInt("eventId"));
                event.setEventName(rslt.getString("eventName"));
                event.setBusinessUsername(rslt.getString("businessEventUsername"));
                event.setCategory(rslt.getString("eventCategory"));
                event.setStartDate(rslt.getString("startDate"));
                event.setEndDate(rslt.getString("endDate"));
                event.setEventContactNumber(rslt.getInt("eventContactNumber"));
                event.setEventContactPerson(rslt.getString("eventContactPerson"));
                event.setEventPrice(rslt.getInt("eventPrice"));
                event.setEventCity(rslt.getString("eventCity"));
                event.setEventDetails(rslt.getString("eventDetails"));
                event.setEventImage(rslt.getBlob("eventImage"));
                event.setEventBookDetail(rslt.getString("eventBookDetail"));
            }
            
        } 
        catch (Exception e) {
            e.getMessage();
        }
        finally{
            con.close();
            return event;
        }
        
    }
    
    public boolean addEvent(EventBean event) throws SQLException{
        boolean status = false;
        Connection con = null;
        try {
             con = DbConnect.getConnection();
             
             String sqlQuery = "INSERT INTO `events-table` (`eventName`, `businessEventUsername`,"
                     + " `startDate`, `endDate`, `eventCategory`, `eventContactNumber`, `eventContactPerson`,"
                     + " `eventPrice`, `eventCity`, `eventDetails`, `eventImage`,`eventBookDetail`)"
                     + " VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?);";
             
      String sqlCreateTable = "CREATE TABLE `"+event.getEventBookDetail()+"`("
                     + "eventBookId int AUTO_INCREMENT,"
                     + "touristFirstName varchar(50),"
                     + "touristLastName varchar(50),"
                     + "touristEmailAdd varchar(50),"
                     + "mobileNumber int(50)"
                     + "bookingDate varchar(50),"
                     + "bookingTime varchar(50)"
                     + "numberOfPerson int,"
                     + "totalPrice int,"
                     + ""
                     + "PRIMARY KEY (eventBookId)"
                     + ");";
                            
             PreparedStatement stm = con.prepareStatement(sqlQuery);
             PreparedStatement stmCreateTable = con.prepareStatement(sqlCreateTable);
             
             stm.setString(1, event.getEventName());
             stm.setString(2, event.getBusinessUsername());
             stm.setString(3, event.getStartDate());
             stm.setString(4, event.getEndDate());
             stm.setString(5, event.getCategory());
             stm.setInt(6, event.getEventContactNumber());
             stm.setString(7, event.getEventContactPerson());
             stm.setInt(8, event.getEventPrice());
             stm.setString(9, event.getEventCity());
             stm.setString(10, event.getEventDetails());
             
//             Part img = event.getEventImage();
//             InputStream istream = img.getInputStream();
             stm.setBlob(11, event.getInsertImage());
             stm.setString(12, event.getEventBookDetail());
             
             stm.execute();
             stmCreateTable.execute();
             status = true;
        } 
        catch (Exception e) {
            e.getMessage();
            status = false;
        }   
        finally{
            con.close();
            return status;
        }
        
    }
    
    public ArrayList<EventBean> getEvents(String city) throws SQLException{
        
        Connection con = null;
        String sqlQuery;
        ArrayList<EventBean> eventsList = new ArrayList<EventBean>();
        boolean queryChange = false;
        
        try {
            con = DbConnect.getConnection();
            
            if (city.equalsIgnoreCase("all")){
                sqlQuery = "SELECT * FROM `events-table`";
            }
            else{
                sqlQuery = "SELECT * FROM `events-table` WHERE `eventCity` =(?)";
                queryChange =true;
            }
            
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            if (queryChange){
                stm.setString(1, city);
            }
            
            ResultSet rslt = stm.executeQuery();
            while(rslt.next()){
                EventBean event = new EventBean();
                
                event.setEventId(rslt.getInt("eventId"));
                event.setEventName(rslt.getString("eventName"));
                event.setBusinessUsername(rslt.getString("businessEventUsername"));
                event.setCategory(rslt.getString("eventCategory"));
                event.setStartDate(rslt.getString("startDate"));
                event.setEndDate(rslt.getString("endDate"));
                event.setEventContactNumber(rslt.getInt("eventContactNumber"));
                event.setEventContactPerson(rslt.getString("eventContactPerson"));
                event.setEventPrice(rslt.getInt("eventPrice"));
                event.setEventCity(rslt.getString("eventCity"));
                event.setEventDetails(rslt.getString("eventDetails"));
                event.setEventImage(rslt.getBlob("eventImage"));
                event.setEventBookDetail(rslt.getString("eventBookDetail"));
                eventsList.add(event);
            }
            
        } 
        catch (Exception e) {
            
        }
        finally{
            con.close();
            return eventsList;
        }
    }
    
    public boolean delEvents(int eventId) throws SQLException   {
        Connection con = null;
        boolean actionStatus = false;
        String bookTableName = null;
        try {
            con = DbConnect.getConnection();
            String sqlSelectQuery = "SELECT `eventBookDetail` FROM `events-table` WHERE `eventId` = (?)";
            String sqlQuery = "DELETE FROM `events-table` WHERE `eventId` = (?)";
            
            
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            PreparedStatement stmSelect = con.prepareStatement(sqlSelectQuery);
            stm.setInt(1, eventId);
            stmSelect.setInt(1, eventId);
            
            ResultSet rslt = stmSelect.executeQuery();
            if(rslt.next()){
                bookTableName = rslt.getString("eventBookDetail");
            }
            
            
            stm.execute();
            boolean delAction = true;
            
            if(bookTableName != null && delAction){
                String sqlDropQuery = "DROP TABLE IF EXISTS `"+bookTableName+"`;";
                PreparedStatement stmdel = con.prepareStatement(sqlDropQuery);
                stmdel.execute();
                actionStatus = true;
            }
            
                    
        } 
        catch (Exception e) {
           actionStatus = false;  
        }
        finally{
            con.close();
            return actionStatus;
        }
    }
    
    public ArrayList<EventBean> getBusinessEvents(String username) throws SQLException{
        
        Connection con = null;
        String sqlQuery;
        ArrayList<EventBean> eventsList = new ArrayList<EventBean>();
        boolean queryChange = false;
        
        try {
            con = DbConnect.getConnection();
            
            
            sqlQuery = "SELECT * FROM `events-table` WHERE `businessEventUsername`= (?) ";
            
            
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            
            stm.setString(1, username);
            
            
            ResultSet rslt = stm.executeQuery();
            while(rslt.next()){
                EventBean event = new EventBean();
                
                event.setEventId(rslt.getInt("eventId"));
                event.setEventName(rslt.getString("eventName"));
                event.setBusinessUsername(rslt.getString("businessEventUsername"));
                event.setCategory(rslt.getString("eventCategory"));
                event.setStartDate(rslt.getString("startDate"));
                event.setEndDate(rslt.getString("endDate"));
                event.setEventContactNumber(rslt.getInt("eventContactNumber"));
                event.setEventContactPerson(rslt.getString("eventContactPerson"));
                event.setEventPrice(rslt.getInt("eventPrice"));
                event.setEventCity(rslt.getString("eventCity"));
                event.setEventDetails(rslt.getString("eventDetails"));
                event.setEventImage(rslt.getBlob("eventImage"));
                event.setEventBookDetail(rslt.getString("eventBookDetail"));
                
                eventsList.add(event);
            }
            
        } 
        catch (Exception e) {
            
        }
        finally{
            con.close();
            return eventsList;
        }
    }
}




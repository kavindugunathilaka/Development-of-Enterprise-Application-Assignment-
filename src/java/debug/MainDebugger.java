/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debug;

/**
 *
 * @author sudhan
 */
import beans.BookEventBean;
import beans.BusinessBean;
import beans.EventBean;
import beans.MessageBean;
import dbConnection.DbConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import beans.TouristBean;
import helper.ManageEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


public class MainDebugger {
    
        public ArrayList<MessageBean> getMessages(String receiver, String userType, int eventId) throws SQLException{
        
        Connection con = null;
        ArrayList<MessageBean> msgList = new ArrayList<MessageBean>();
        String colName = null;
        
        if(userType.equals("businessAuth")){
            colName = "business-user";
        }
        else if(userType.equals("touristAuth")){
            colName = "tourist-user";
        }
        
        try {
            con = DbConnect.getConnection();
            
            String sql = "SELECT * FROM `message-table` WHERE `"+colName+"` = ? AND `eventId` = ? ";
            
            PreparedStatement stm = con.prepareCall(sql);
            stm.setString(1, receiver);
            stm.setInt(2, eventId);
            
            ResultSet rslt = stm.executeQuery();
            
            while(rslt.next()){
                MessageBean msg = new MessageBean();
                msg.setMsgId(rslt.getInt("msgId"));
                msg.setTouristUser(rslt.getString("tourist-user"));
                msg.setBusinessUser(rslt.getString("business-user"));
                msg.setEventId(rslt.getInt("eventId"));
                msg.setMessage(rslt.getString("message"));
                
                msgList.add(msg);
            }
            
        } 
        catch (Exception e) {
            e.getMessage();
        }
        finally{
            con.close();
            return msgList;        
        }
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
    
    public String addbookEvent(BookEventBean evnt) throws SQLException{
        Connection con = null;
        String status = null;
        
        try {
            con = DbConnect.getConnection();
            String tableName = evnt.getEventBookTable();
            String sql = "INSERT INTO `"+tableName+"`"
                    + "(`touristFirstName`, `touristLastName`, `touristEmailAdd`, `mobileNumber`, `bookingDate`, `bookingTime`, `numberOfPerson`, `totalPrice`)"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            
            PreparedStatement stm = con.prepareStatement(sql);
             stm.setString(1, evnt.getTouristFirstName());
            stm.setString(2, evnt.getTouristLastName());
            stm.setString(3, evnt.getTouristEmailAdd());
            stm.setInt(4, evnt.getMobileNumber());
            stm.setString(5, evnt.getBookingDate());
            stm.setString(6, evnt.getBookingTime());
            stm.setInt(7, evnt.getNumberOfPerson());
            stm.setInt(8, evnt.getTotalPrice());
            
            stm.execute();
            status = "Done";
        } 
        catch (Exception e) {
            status = e.getMessage();
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
                sqlQuery = "SELECT * FROM `events-table`;";
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
    
    
    public String getInfo() throws SQLException{
        String str = "null-info";
        ResultSet rslt=null;
        Connection conn = null;
        try {
            conn = dbConnection.DbConnect.getConnection();
            
        
        boolean loginStatus = false;
        Connection con = null;
        
            con = DbConnect.getConnection();
            String tour = "QWERT";
                  String sqlQueryCreateTable = "CREATE TABLE "+tour+"_tourist_event_history ("
                    + "Id int KEY AUTO_INCREMENT,"
                    + "eventName varchar(30),"
                    + "catOfEvent varchar(30),"
                    + "bookedDate Date,"
                    + "city varchar(30),"
                    + "orgBy varchar(30)"
                    + ")";
            
            
            PreparedStatement stmTable = con.prepareStatement(sqlQueryCreateTable);
       
            
            System.out.println(stmTable.execute());
            str = "Success";
            
        } 
        catch (Exception e) {
            
            str = e.getMessage()+"Failed";
                
        }
        finally{
            conn.close();
        }
        
        
        return str;
    }
    
    public int validateResult(ResultSet rslt) throws SQLException{
        
        rslt.last();
        int size = rslt.getRow(); 
        return size;
    }
    
    
    public static void main(String[] args) throws SQLException {
        MainDebugger debug = new MainDebugger();
        ArrayList<MessageBean> msgList = debug.getMessages("delan", "touristAuth", 14);
         
         Enumeration<MessageBean> msges = Collections.enumeration(msgList);
         if(!msgList.isEmpty()){
            while(msges.hasMoreElements()){
                MessageBean msg = new MessageBean();
         
             }
        }
        else{
             System.out.println("Currently no messages");
        }   
        
    }
    
}


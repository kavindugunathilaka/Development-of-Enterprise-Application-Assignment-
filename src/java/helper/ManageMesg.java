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
import beans.MessageBean;
import dbConnection.DbConnect;
import java.sql.*;
import java.util.ArrayList;

public class ManageMesg {
    
    public boolean sengMsg(MessageBean msg) throws SQLException{
        
        Connection con = null;
        boolean actionStatus = false;
        
        try {
            con = DbConnect.getConnection();
            
            String sql = "INSERT INTO `message-table`"
                    + "(`tourist-user`, `business-user`, `eventId`, `message`) "
                    + "VALUES (?,?,?,?)";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, msg.getTouristUser());
            stm.setString(2, msg.getBusinessUser());
            stm.setInt(3, msg.getEventId());
            stm.setString(4, msg.getMessage());
            
            stm.execute();
            actionStatus = true;
            
        } 
        catch (Exception e) {
            actionStatus = false;
        }
        finally{
            con.close();
            return actionStatus;
        }
    }
    
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
    
    public ArrayList<MessageBean> getMesgCount(String receiver, String userType) throws SQLException{
        
        Connection con = null;
        ArrayList<MessageBean> CountList = new ArrayList<MessageBean>(); 
        String colName = null;
        
        if(userType.equals("businessAuth")){
            colName = "business-user";
        }
        else if(userType.equals("touristAuth")){
            colName = "tourist-user";
        }
        
        try {
            con = DbConnect.getConnection();

            String sql = "SELECT DISTINCT `tourist-user`,`business-user`,`eventId` FROM `message-table` WHERE `"+colName+"` = ? ";
            
            PreparedStatement stm = con.prepareCall(sql);
            stm.setString(1, receiver);
            
            ResultSet rslt = stm.executeQuery();
            
            while(rslt.next()){
                MessageBean msg = new MessageBean();
                msg.setMsgId(rslt.getInt("msgId"));
                msg.setTouristUser(rslt.getString("tourist-user"));
                msg.setBusinessUser(rslt.getString("business-user"));
                msg.setEventId(rslt.getInt("eventId"));
                msg.setMessage(rslt.getString("message"));
                
                CountList.add(msg);
            }
            
        } 
        catch (Exception e) {
            e.getMessage();
        }
        finally{
            con.close();
            return CountList;        
        }
        
    }
    
}

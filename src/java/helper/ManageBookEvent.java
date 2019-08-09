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
import beans.BookEventBean;
import dbConnection.DbConnect;
import helper.ManageBookEvent;
import java.sql.*;
public class ManageBookEvent {
    
    public boolean addbookEvent(BookEventBean evnt) throws SQLException{
        Connection con = null;
        boolean status = false;
        
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
            status = true;
        } 
        catch (Exception e) {
            status = false;
        }
        finally{
         con.close();
         return status;
            
        }
    }
    
}

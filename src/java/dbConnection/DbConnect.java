/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

/**
 *
 * @author sudhan
 */
import java.sql.*;

public class DbConnect {
     
    public static Connection getConnection(){
        
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String server = "localhost";
            String portNum = "3306";
            String dbName = "deaTest";
            String username = "root";
            String password = "";
            
            conn = DriverManager.getConnection("jdbc:mysql://"+server+":"+portNum+"/"+dbName,username,password);
            return conn;
        } 
        catch (Exception e) {
//            System.out.println(e.getMessage());
            e.getMessage();
            conn =null;
            return conn;
        }
    
    }

    
}

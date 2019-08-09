<%-- 
    Document   : testimagePage
    Created on : Jun 14, 2019, 3:10:34 PM
    Author     : sudhan
--%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.*"%>
<%@page import="dbConnection.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Connection con = null;
        try {
                con =DbConnect.getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT * FROM testImagetable");
                ResultSet rslt = stm.executeQuery();
                if (rslt.next()){
                    Blob b = rslt.getBlob("image");
                    byte byArray[] = b.getBytes(1, (int)b.length());
//                    response.setContentType("image/gif");
//                    OutputStream ostream = response.getOutputStream();
                    
//                    ostream.write(byArray);
//                    ostream.flush();
//                    ostream.close();
                out.print("<img width=50% src='data:image/jpeg;base64,"+Base64.encode(byArray) +"'>");    
                }
                
            } 
            catch (Exception e) {
                out.print(e.getMessage());
            }

        %>
    </body>
</html>

<%-- 
    Document   : eventPage
    Created on : Jun 15, 2019, 6:49:35 PM
    Author     : sudhan
--%>

<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.EventBean"%>
<%@page import="helper.ManageEvent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
            <%
            String username = "";
            String searchByCity = null;
                try {
                    
                    username = (String)session.getAttribute("username");
                    String userType = (String)session.getAttribute("userType");

                    if ( userType.equals("touristAuth") ){
                    }
                    else{
                        response.sendRedirect("login.jsp");
                    }
                }
                catch (Exception e) {
                    RequestDispatcher loginReqDispatch = request.getRequestDispatcher("login.jsp");
                    loginReqDispatch.forward(request, response);
                }
                
        %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/dashboard-css.css">
        <title>Event Page</title>
    </head>
    <style media="screen">
    body{
      background-image: url(Images/bg3.jpg);
            background-size: cover;

    }
    </style>
    <body>
     
      <div class="header">
        <%@include file="header.jsp"%>
      </div>
        <div class="pageDiv">
                <%
//                out.print(username);
                try {
                    
                    String status = response.getHeader("event-msg");

                    if (status != null){
                        out.print("<h4>"+status+"</h4>");
                    }
                }
                catch (Exception e) {
                    out.print("<h4>"+e.getMessage()+"</h4>");
                }
            %>
      <div class="firstDiv">
        <br>
          <br>
            prfile picture
        <form class="" action="#" method="get">
          <input type="text" name="searchLocation" class="form-text-box" value="" placeholder="Search location in Sri lanka">
            <input type="submit" name="" value="Search" class="dash-menu-content">
        </form><br><br>
        <a href="#">
          <button type="button" name="button" class="dash-menu-content">
            Setting</button>
        </a><br>
        <a href="#">
          <button type="button" name="button" class="dash-menu-content">
            Booking</button>
        </a><br>
        <a href="#">
          <button type="button" name="button" class="dash-menu-content">
            Messages</button>
        </a><br>
<!--         <a href="#" class="nav-content">
          <button type="button" name="button" class="dash-menu-content">
            Add Event</button>
        </a>-->
      </div>
      <div class="secondDiv">
        background color should be traparent
        <%--<jsp:useBean id="event" class="beans.EventBean" />--%>
        <%
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        ManageEvent manageEvent = new ManageEvent();
        EventBean event = manageEvent.getSingleEvent(eventId);
        %>
        
                <table width=100% height=100%>
            <tr>
              <td width=100% height=40% >
                
                 
                <%
                      Blob blobImage = event.getEventImage();
                      byte imgArray[] = blobImage.getBytes(1, (int) blobImage.length());

                    out.print("<img width=100% class='event_poster-img' src='data:image/jpeg;base64,"+Base64.encode(imgArray) +"'>");
                %>
              </td>
            </tr>
            <tr>
              <td width=100% height=auto class=main_event_detail>
                
                Event Name : <%=event.getEventName() %><br>
                Category : <%=event.getCategory() %><br>
                
                City : <%=event.getEventCity() %><br>
                Details : <%=event.getEventDetails() %><br>
                
              </td>
            </tr>
          </table>
       
      </div>
      <div class="thirdDiv">
          <form class="signup-form" action="BookEventServlet" method="post" >
              <input type="hidden" name="eventId" value='<%=eventId%>'>
              <input type="hidden" name="touristUsername" value='<%=username %>'>
              
            <table  class="signup-table">
              <tr>
                <th colspan="2">Book</th>
              </tr>
                
                <tr>
                    <td>
                      <input type="text" name="bookDate" value="" class="form-text-box-left" placeholder="Date : dd-mm-yyyy">
                    </td>
                </tr>
                <tr>
                  <td >
                    <input type="text" name="bookTime" value="" class="form-text-box-left" placeholder="Time : hh-mm">
                  </td>
                </tr>
                <tr >
                  <td>
                    <input type="text" name="contactNumber" value="" class="form-text-box-left" placeholder="Mobile Number">
                  </td>
                </tr>
                  <tr>
                    <td>
                      <input type="text" name="numPeople" value="" class="form-text-box-left" placeholder="Number of people">
                    </td>
                  </tr>
                <tr>
                    <td colspan="2"><input type="checkbox" name="agreement-check" value="agree" required>I agree to terms and conditions</td>
                </tr>
                <tr>
                    <td colspan="2" >
                    <button type="submit" name="submit-btn" class="signup-btn">Book</button>
                  </td>
                </tr>
          </table>
        </form>
        </div>
      </div>
    <div class="footer-div">
      <%@include file="footer.jsp"%>
    </div>
  </body>
</html>


<%--
    Document   : dashboard-tourist
    Created on : Jun 9, 2019, 4:37:37 PM
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
                try {
                    searchByCity = request.getParameter("searchByCity");
                    if (searchByCity == null){
                        searchByCity = "all";
                    }
                } 
                catch (Exception e) {
                    searchByCity = "all";
                }
                
        %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/dashboard-css.css">
        <title>Dashboard-tourist</title>
    </head>
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
            <table>
              <tr>
                <td>Pro pic</td>
              </tr>
              <tr>
                  <td>
                    <form class="" action="#" method="get">
                      <input type="text" name="searchLocation" class="form-text-box" value="" placeholder="Search location in Sri lanka">
                        <input type="submit" name="" value="Search" class="dash-menu-content">
                    </form>
                  </td>
              </tr>
              <tr>
                <td>
                  <a href="#">
                    <button type="button" name="button" class="dash-menu-content">
                      Setting</button>
                  </a>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="#">
                    <button type="button" name="button" class="dash-menu-content">
                      Booking</button>
                    </a>
                </td>
              </tr>
              <tr>
                <td>
<!--                  <a href="#">
                    <button type="button" name="button" class="dash-menu-content">
                      Messages</button>
                    </a>-->
                </td>
              </tr>
            </table>
          </div>
      <div class="secondDiv">
        
        <%
        boolean displayCard = false;
        ManageEvent events = new ManageEvent();
        ArrayList<EventBean> elist = events.getEvents(searchByCity);
        Enumeration<EventBean> eventsList = Collections.enumeration(elist);
        
        if (!elist.isEmpty()){
            displayCard = true;
        }
        
        %>
          <div class="cards">
              
              <%
                  if (displayCard){
                      try {
                        while(eventsList.hasMoreElements()){
                            EventBean event = eventsList.nextElement();

                            Blob blobImage = event.getEventImage();
                            byte imgArray[] = blobImage.getBytes(1, (int) blobImage.length());

                            out.print("<table class='event-card' width=100% height=100% >"
                                + "<tr>"
                                    + "<td  width=50% >"
                                      +"Event Name : "+ event.getEventName()+"<br>"
                                      + "Category : "+event.getCategory()+"<br>"
                                      +"Start Date : " +event.getStartDate()+"  End Date: "+event.getEndDate()+"<br>"
                                      + "Event City : "+event.getEventCity()+"<br>"
                                      + "Event Price : "+event.getEventPrice()+"<br>"
                                      + "Organized by : "+event.getBusinessUsername()+"<br>"
                                      
                                        + "<form action='eventPage.jsp' method='get'>"
                                        + "<input type='hidden' name='eventId' value='"+event.getEventId()+"'>"
                                        + "<input type='hidden' name='eventbook' value='"+event.getEventBookDetail()+"'>"                                                
                                        + "<button type='submit' name='eventAction' value='eventDetails'>View Details & Book </button>"
                                        + "</form>"
                                                + "<form action='message-dashboard.jsp' action='get'>"
                                                + "<input type='hidden' name='eventId' value='"+event.getEventId()+"'>"
                                        + "<button type='submit' name='eventAction' value=''>Message Business</button>"
                                                + "</form>"
                                    + "</td>"
                                    + "<td  width=50% >"
                                        + "<img width=100% src='data:image/jpeg;base64,"+Base64.encode(imgArray) +"'>"
                                    + "</td>"
                                + "</tr>"
                                + "</table>");
                        }
                      }
                      catch (Exception e) {
                          out.print(e.getMessage());
                      }
                  }
                  else{
                      out.print("<h2><center>No active events</center> </h2><br>");
                  }
             
              %>

          </div>
      </div>

      </div>
    <div class="footer">
      <%@include file="footer.jsp"%>
    </div>
  </body>
</html>

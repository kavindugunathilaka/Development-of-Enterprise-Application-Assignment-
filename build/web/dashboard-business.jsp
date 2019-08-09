<%--
    Document   : dashboard-business
    Created on : Jun 9, 2019, 12:16:16 PM
    Author     : sudhan
--%>

<%@page import="java.sql.Blob"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%--<%@page import="org.apache.xml.security.utils.Base64"%>--%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.EventBean"%>
<%@page import="helper.ManageEvent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <%
            String username = "";
        try {

                username = (String)session.getAttribute("username");
                String userType = (String)session.getAttribute("userType");

                if ( userType.equals("businessAuth") ){

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
        <title>Dashboard-business-eventM</title>
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
            %><div class="firstDiv">
            <table  > 
              <tr>
                <td>Pro pic</td>
              </tr>
              <tr>
                  <td>
                    <form class="" action="#" method="get">
                      <input type="text" name="searchLocation" class="form-text-box" value="" placeholder="Search location in Sri lanka"><br>
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
        background color should be traparent
        <%
           boolean displayCard = false;
           ManageEvent events = new ManageEvent();
           ArrayList<EventBean> elist = events.getBusinessEvents(username);
//           out.print(elist);
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
                                      + "Contact Person : "+event.getEventContactPerson()+"<br>"
                                      +"For More Ifo :" +event.getEventContactNumber()+"<br>"
                                      + "City : "+event.getEventCity()+"<br>"
                                      + "Details : "+event.getEventDetails()+"<br>"
                                        + "<form action='EventServlet' method='get'>"
                                        + "<input type='hidden' name='eventId' value='"+event.getEventId()+"'>"
                                        + "<button type='submit' name='eventAction' value='something'>Edit Event</button>"
                                        + "<button type='submit' name='eventAction' value='eventDel'>Delete Event</button>"
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
                      out.print("<h2>You no active events.. </h2><br>");
                      out.print("<h2>Please update new events </h2>");
                  }
              %>
          </div>
      </div>
      <div class="thirdDiv">
          <form class="signup-form" action="EventServlet" method="post" enctype="multipart/form-data">
              
              <input type='hidden' name='businessUsername' value='<%=userSession.getAttribute("username")%>'>
              <input type='hidden' name='eventAction' value='eventReg'>
            <table  class="signup-table">
              <tr >
                <th colspan="2">Service Offered</th>
              </tr>
                <tr>
                  <td colspan="2">
                    <input type="text" name="eventName" value="" class="form-text-box-left" placeholder="Event Name">
                  </td>
                </tr>
                <tr>
                    <td>
                      <input type="text" name="startDate" value="" class="form-text-box-left" placeholder="Start Date">
                    </td>
                    <td>
                      <input type="text" name="endDate" value="" class="form-text-box-right" placeholder="End Date">
                    </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <input type="text" name="eventCat" value="" class="form-text-box-left" placeholder="Category">
                  </td>
                </tr>
                <tr >
                  <td >
                    <input type="text" name="contactNumber" value="" class="form-text-box-left" placeholder="Contact number">
                  </td>
                  <td>
                    <input type="text" name="contactPerson" value="" class="form-text-box-left" placeholder="Person in-charge">
                  </td>
                </tr>
                  <tr>
                    <td>
                      <input type="text" name="eventPrice" value="" class="form-text-box-left" placeholder="Price per Person">
                    </td>
                    <td>
                      <input type="text" name="city" value="" class="form-text-box-right" placeholder="City">
                    </td>
                  </tr>
                <tr>
                  <td colspan="2">
                    <label for="eventDetail">Enter event details</label>
                    <textarea name="eventDetail" rows="8" cols="10" class="form-text-box">
                    </textarea>
                    </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <input type="file" name="eventImage" value="" placeholder="Select your event image">
                  </td>
                </tr>
                <tr>
                  <td colspan="2"><input type="checkbox" name="agreement-check" value="agree" required>I agree to terms and conditions</td>
                </tr>
                <tr>
                    <td colspan="2" >
                    <button type="submit" name="submit-btn" class="signup-btn">Join</button>
                  </td>
                </tr>
          </table>
        </form>
        </div>
      </div>
    <div class="footer">
      <%@include file="footer.jsp"%>
    </div>
    </body>
</html>

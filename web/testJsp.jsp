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
//        try {
//
//                String username = (String)session.getAttribute("username");
//                String userType = (String)session.getAttribute("userType");
//
//                if ( userType.equals("businessAuth") ){
//
//                }
//                else{
//                    response.sendRedirect("login.jsp");
//                }
//            }
//            catch (Exception e) {
//                response.sendRedirect("login.jsp");
//            }
//
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
      <div class="firstDiv">
        <br>
          <br>
            prfile picture
        <a href="#">
          <button type="button" name="button" class="dash-menu-content">
            Manage Events</button>
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
        <%
           ManageEvent events = new ManageEvent();
           ArrayList<EventBean> elist = events.getEvents("all");
//           out.print(elist);
           Enumeration<EventBean> eventsList = Collections.enumeration(elist);

        %>
          <div class="cards">
              <%
                  try {
                        while(eventsList.hasMoreElements()){
                            EventBean event = eventsList.nextElement();

                      Blob blobImage = event.getEventImage();
                      byte imgArray[] = blobImage.getBytes(1, (int) blobImage.length());


                        }
                      } catch (Exception e) {
                          out.print(e.getMessage());
                      }

              %>
          </div>
      </div>
      <div class="thirdDiv">
          <form class="signup-form" action="#" method="post" >
              <%--<%=userSession.getAttribute("username").toString()%>--%>
              <input type='hidden' name='businessUsername' value='firsttestUser'>
              <input type='hidden' name='event-action' value='eventReg'>
            <table  class="signup-table">
              <tr>
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
                        <a href="index.jsp"><button type="button"  name="button">Home</button></a>
                        
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

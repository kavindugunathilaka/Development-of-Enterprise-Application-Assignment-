<%--
    Document   : message-dashboard
    Created on : Jun 16, 2019, 4:06:39 PM
    Author     : sudhan
--%>

<%@page import="sun.misc.CompoundEnumeration"%>
<%@page import="java.util.Enumeration"%>
<%@page import="beans.MessageBean"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="helper.ManageMesg"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <%        // Session Checking 
            String username = "";
            String userType = null;
            int eventId = 14;
//                if(request.getParameter("eventId") != null ){
//                    eventId = Integer.parseInt(request.getParameter("eventId")); 
//                }
//                else{
//                    eventId =-1;
//                }
                try {
                    username = (String)session.getAttribute("username");
                    userType = (String)session.getAttribute("userType");

                    if ( userType != null ){
                    }
                    else{
                        response.sendRedirect("login.jsp");
                    }
                }
                catch (Exception e) {
                    RequestDispatcher loginReqDispatch = request.getRequestDispatcher("message-dashboard.jsp");
                    loginReqDispatch.forward(request, response);
                }
                
        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Styles/messageDasboard.css">
    </head>
    <body>

      <div class="header">
        <%@include file="header.jsp"%>
      </div>
        <div class="pageDiv">
           <%
                
                  String status = response.getHeader("msgStatus");

                  if(status != null){
                    out.print("<h4>"+status+"</h4>");
                  }
                  if(status == null){
                      out.print("<h4>"+status+"</h4>");
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
                          <div class="tble" height=10%>
                <section align='center' >
                  
                  <text>  Recevier Name and Event Name</text>
                   
                </section>
              </div><br>
    
              
              <div class="message-panel" >
                  <%
                      
                  %>
                <div class="messages">
                    <%
                        
                        
                        boolean showMsg =false;
                        ManageMesg manageMsg = new ManageMesg();
//                        ArrayList<MessageBean> userList = new ArrayList<MessageBean>();
                        if(eventId > 0){
                            ArrayList<MessageBean> msgList = manageMsg.getMessages(username, userType,eventId);
                            Enumeration<MessageBean> msges = Collections.enumeration(msgList);
//                            
//                            MessageBean firstSender = msges.nextElement();
//                            
//                            String fsender = firstSender.getTouristUser();
//                            
                            
                            if(!msgList.isEmpty()){
                                while(msges.hasMoreElements()){
                                    MessageBean msg = msges.nextElement();
//                                    if(fsender.equalsIgnoreCase(msg.getTouristUser())){
                                        out.print("<div class='msg-single-div-left'>"
                                            +"Messages :" +msg.getMessage()
                                            + "</div><br>");
//                                    }
//                                    else{
//                                        userList.add(msg);
//                                    }
                                }
                            }
                            else{
                                out.print("Currently no messages");
                            }   
                        }
                        else{
                            out.print("No event selected");
                        }
                    
                    %>
                </div>
              </div>
              <br><center>
                <div class="msg-form-div">
                  <form class="" action="MessageServlet" method="post">
                    <input type="text" class="msg-form" name="msgFromSender" value="" placeholder="Enter your message"> &nbsp;
                    <input type="hidden" name="eventId" value='<%= 14 %>' >
                    <input type="hidden" name="sender" value='<%= username %>'>
                    <input type="hidden" name="userType" value='<%= userType %>'>
                    <button type="submit" name="send-msg-btn" class="">
                        Send > </button>
                  </form>
                </div>
                  </center>

        </div>
          <div class="thirdDiv">
                        <%
//                        if(eventId > 0){
//                            Enumeration<MessageBean> userMsges = Collections.enumeration(userList);
//                            
//                            if(!userList.isEmpty()){
//                                while(userMsges.hasMoreElements()){
//                                    MessageBean m = userMsges.nextElement();
//                                    out.print("<div class='msg-single-div-left'>"
//                                            + "From : "+m.getTouristUser()+" "
//                                            +"Message ID :" +m.getMsgId()
//                                            + "</div><br>");
//                                }
//                            }
//                            else{
//                                out.print("Currently no messages from users");
//                            }   
//                        }
//                        else{
//                            out.print("No event selected");
//                        }
                        %>
          </div>
    </div>
<!--        <div class="footer">
      <%@include file="footer.jsp"%>
      </div>-->
        </body>
</html>

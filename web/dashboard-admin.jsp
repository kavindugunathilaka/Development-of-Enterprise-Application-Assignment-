<%--
    Document   : dashboard-admin
    Created on : Jun 9, 2019, 5:31:06 PM
    Author     : sudhan
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.BusinessBean"%>
<%@page import="java.util.List"%>
<%@page import="helper.ManageUsers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <%
            try {
                
                String username = (String)session.getAttribute("username");
                String userType = (String)session.getAttribute("userType");
            
                if ( userType.equals("adminAuth") ){
                    }
                else    {
                    response.sendRedirect("adminLogin.jsp");
                }
                
            } 
            catch (Exception e) {
                response.sendRedirect("adminLogin.jsp");
            } 
        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="Styles/dashboard-css.css">
        <title>Dashboard Admin</title>
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
            Account Requests</button>
        </a><br>
        <a href="#">
          <button type="button" name="button" class="dash-menu-content">
            Business</button>
        </a>
        <br>
          <br>
        <a href="#">
          <button type="button" name="button" class="dash-menu-content">
            Events</button>
        </a><br>
        <a href="#" class="nav-content">
          <button type="button" name="button" class="dash-menu-content">
            Setting</button>
        </a>
      </div>
      <div class="secondDiv">
        background color should be traparent
<!--        <form action="adminDetailServlet" method="get">
            button
        </form>-->
        <button onclick=''>Pending</button>
        <button onclick=''>Approved</button>
        <button onclick=''>Rejected</button>
        <%
            ManageUsers users = new ManageUsers();
            ArrayList<BusinessBean> bList = users.getBusinessUsers("pending");
            Enumeration<BusinessBean> businessList = Collections.enumeration(bList);
            
            %>
          <div class="cards">
              <%
              while (businessList.hasMoreElements()){
                BusinessBean business = businessList.nextElement();
                
                out.print("<div class='event-card'>"
                            + "<div class='event-detail'>"
                                + business.getBusinessName()+"<br>"
                                + business.getOwnerFirstName()+" <br>"+business.getOwnerLastName()+"br"
                                + business.getUsername()+"<br>"
                                + business.getBusinessEmail()+"<br>"
                                + business.getCity()+"  "+business.getProvince()
                                + ""+"<br>"
                            + "</div>"
                         + "<div class='event-image'>"
                           + ""
                         + "</div>"
                        + "<div class='event-card-btn'>"
                                + "<form action='BusinessRegServlet' method='get'>"
                                + "<input type='hidden' name='username' value='"+business.getUsername()+"'>"
                                + "<button type='submit' name='approve-btn'value='approve'>Approve</button>"
                                + "<button type='submit' name='reject-btn' value='reject'>Reject</button>"
                                + "</form>"
                        + "</div>"
                       + "</div>");
            }
              %>
          </div>
      </div>
      <%-- <div class="thirdDiv">
        </div> --%>
      </div>
    <div class="footer">
      <%@include file="footer.jsp"%>
    </div>

    </body>
</html>

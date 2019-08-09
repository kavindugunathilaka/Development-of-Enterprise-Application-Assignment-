<%--
    Document   : login
    Created on : Jun 7, 2019, 2:07:40 AM
    Author     : sudhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="Styles/login-css.css">
          <script src="Script/loginScript.js" charset="utf-8"></script>
    </head>
    <body>
        <div class="header">
          <%@include file="header.jsp"%>
        </div>
          <div class="page-div" align="center">

            <%
                try {

                    String status = response.getHeader("loginStatus");

                    if (status.equalsIgnoreCase("success&pending")){
                        out.print("<h4>You can login to account after account approval</h4>");
                    }
                    else if (status.equalsIgnoreCase("invalidLogin")){
                        out.print("<h4>Invalid username or password</h4>");
                    }
                    else if (status != null){
                        out.print("<h4>"+status+"</h4>");
                    }
                }
                catch (Exception e) {
                    out.print("<h4>"+e.getMessage()+"</h4>");
                }
            %>

          <form class="" action="AuthenticationServlet" method="post" >
          <!--<form class="" action="TestServlet" method="post" >-->    
          <input type="hidden" name="typeOfUser" id="user-type" value="">
            <table class="login-table" >
              <tr>
                <td colspan="2">
                  <input type="text" name="username" class="form-text-box" value="" placeholder="Username">
                </td>
              </tr>
              <tr>
                <td colspan="2">
                  <input type="password" name="password" class="form-text-box" value="" placeholder="Password">
                </td>
              </tr>
              <tr>
                <td >
                    <button type="submit" name="submit-btn" class="login-btn"  onclick="loginTourist()" >
                      Login as Tourist
                  </button>
                </td>
                <td >
                  <button type="submit" name="submit-btn" class="login-btn" onclick="loginBusiness()" >
                      Login as Business
                  </button>
                </td>
              </tr>
            </table>
          </form>
        </div>
        <div class="footer">
          <%@include file="footer.jsp"%>
        </div>
    </body>
</html>

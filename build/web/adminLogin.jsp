<%--
    Document   : adminLogin
    Created on : Jun 11, 2019, 5:56:17 PM
    Author     : sudhan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/login-css.css">
        <title>Admin Login Page</title>
    </head>
    <body>
      <div class="header">
        <%@include file="header.jsp"%>
      </div>
        <div class="page-div" align="center">

          <%
              try {

                  String status = response.getHeader("RegStatus");
                  String msg = response.getHeader("msg");
                  
                  if (status.equalsIgnoreCase("success&pending")){
                    out.print("<h4>You can login to account after account approval</h4>");
                   }
                  else if (status.equalsIgnoreCase("invalidLogin")){
                    out.print("<h4>Invalid username or password</h4>");
                   }
                  
                  if (msg != null){
                      out.print("<h3>"+msg+"</h3>");
                  }
              }
              catch (Exception e) {
                  out.print("<h4>"+e.getMessage()+"</h4><br>");
                  out.print("Enter admin and Password to login");
                    // status = null;
              }

            
          %>

        <form class="" action="AuthenticationServlet" method="post">
            <input type="hidden" name="typeOfUser" id="user-type" value="adminUser">
          <table class="login-table">
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
              <td colspan="2">
                <button type="submit" name="submit-btn" class="login-btn">Login</button>
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

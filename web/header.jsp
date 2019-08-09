<%--
    Document   : header
    Created on : Jun 2, 2019, 8:53:24 PM
    Author     : sudhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/header-css.css">
        <script src="Script/indexScript.js" charset="utf-8"></script>
    </head>
    <body>
      <header>
        <div class="nav-bar">
            <a href="index.jsp" class="nav-content">
                <button class="nav-btn">Home</button>
                <b
              </a>
              <a href="#" class="nav-content">
                <button class="nav-btn">About us</button>
              </a>
              <a href="#" class="nav-content">
                <button class="nav-btn">Services</button>
              </a>
              <a href="#" class="nav-content">
                <button class="nav-btn">Blog</button>
              </a>
              <a href="#" class="nav-content">
                <button class="nav-btn">Contact us</button>
              </a>
            <%
                // clean session
                HttpSession userSession = request.getSession(false);
//                userSession.invalidate();

            if (userSession.getAttribute("username") != null){
//                String name = (String)userSession.getAttribute("username");
                out.print(""
                        + "<a href='LogoutServlet' class='nav-content-left'>"
                        + "<button class='nav-btn'>Log out</button>"
                        + "</a>"
                        + "<text class='nav-content-left'>"+userSession.getAttribute("username")+"</text>"
                        + "");
            }
            else{
                out.print("<a href='Signup-tourist.jsp' class='nav-content-left'>"
//                        + "Signup as Tourist"
//                        + "</a>"
//                        + "<a href='Signup-business.jsp' class='nav-content-left'>"
//                        + "Signup as Business"
//                        + "</a>"
                        + "<a href='login.jsp' class='nav-content-left'>"
                        + "<button class='nav-btn'>Login</button>"
                        + "</a>" );
            }
            %>


    <!--          <a href="#" class="nav-content-left">
                Login
              </a>
              <a href=" " class="nav-content-left">
                Signup
              </a>
        -->
        </div>
 <!--       <div class="login-panel" id="id01">
            <div class="login-panel-content"><center>
                <a href="Signup-tourist.jsp">
                    <button type="submit" name="tourist-login-btn" class="login-panel-btn">Login as Tourist</button>
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="Signup-business.jsp">
                    <button type="button" name="business-login-btn" class="login-panel-btn">Login as Business</button>
                </a>
            </center></div>
        </div>
      </header>
-->
    </body>
</html>

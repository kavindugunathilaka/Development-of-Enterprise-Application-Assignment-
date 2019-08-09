<%--
    Document   : Signup
    Created on : Jun 5, 2019, 9:47:41 PM
    Author     : sudhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup - Tourist </title>
        <link rel="stylesheet" href="Styles/signup-css.css">
    </head>
    <body>
        <div class="header">
            <%@include file="header.jsp"%>
        </div>
        <div class="page-div" align="center">
          <%
              String status = response.getHeader("regStatus");
              out.print("<h4> Status Response :"+status+"</h4>");
          %>
          <div class="signup-form-div" >
            <form class="signup-form" action="BusinessRegServlet" method="post" >

              <table  class="signup-table">
                <tr>
                  <th colspan="2">Join global tourism</th>
                </tr>
                  <tr>
                    <td>
                      <input type="text" name="ownersFirstName" value="" class="form-text-box-left" placeholder="Owner's First Name" required>
                    </td>
                    <td>
                      <input type="text" name="ownersLastName" value="" class="form-text-box-right" placeholder="Owner's Last Name" required>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2">
                      <input type="text" name="businessEmailAdd" value="" class="form-text-box" placeholder="Business Email address" required>
                    </td>
                  </tr>
                  <tr>
                      <td>
                        <input type="text" name="username" value="" class="form-text-box-left" placeholder="Username" required>
                      </td>
                      <td>
                        <input type="password" name="password" value="" class="form-text-box-right" placeholder="Password" required>
                      </td>
                  </tr>
                  <tr >
                    <td colspan="2">
                      <input type="text" name="businessName" value="" class="form-text-box-left" placeholder="Business Name" required>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <input type="text" name="no" value="" class="form-text-box-left" placeholder="No." required>
                    </td>
                    <td>
                      <input type="text" name="streetAdd-1" value="" class="form-text-box-right" placeholder="Street address 1" required>
                    </td>
                  </tr>
                    <tr>
                      <td>
                        <input type="text" name="streetAdd-2" value="" class="form-text-box-left" placeholder="Street address 2" required>
                      </td>
                      <td>
                        <input type="text" name="city" value="" class="form-text-box-right" placeholder="City" required>
                      </td>
                    </tr>
                  <tr>
                    <td>
                      <input type="text" name="postalCode" value="" class="form-text-box-left" placeholder="Postal code" required>
                      </td>
                    <td>
                      <input type="text" name="province" value="" class="form-text-box-right" placeholder="Province" required>
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

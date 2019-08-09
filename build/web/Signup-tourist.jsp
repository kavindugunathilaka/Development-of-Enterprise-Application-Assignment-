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
                String st2 = response.getHeader("regStatus");
                out.print("<h4> Status Response :"+st2+"</h4>");

            %>
          <div class="signup-form-div" >
            <form class="signup-form" action="TouristRegServlet" method="post" >
            <!-- <fieldset class="signup-fieldset"> -->
              <!-- <legend>Enter your details</legend> -->
              <table  class="signup-table">
                <tr>
                  <th colspan="2">Enter your details</th>
                </tr>
                  <tr>
                    <td>
                        <input type="text" name="firstName" value="" class="form-text-box-left" placeholder="First Name" required>
                    </td>
                    <td>
                      <input type="text" name="lastName" value="" class="form-text-box-right" placeholder="Last Name" required>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2">
                      <input type="text" name="emailAddress" value="" class="form-text-box" placeholder="Email address" required>
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
                    <td >
                      <input type="text" name="dob" value="" class="form-text-box-left" placeholder="Date of birth" required>
                    </td>
                    <td>
                      <input type="text" name="contactNumber" value="" class="form-text-box-left" placeholder="Contact Number" required>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <input type="text" name="houseNo" value="" class="form-text-box-left" placeholder="House No" required>
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
                      <input type="text" name="country" value="" class="form-text-box-right" placeholder="Country" required>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2"><input type="checkbox" name="agreement-check" value="agree" required>I agree to terms and conditions</td>
                  </tr>
                  <tr>
                      <td colspan="2" >
                      <!-- <button type="cancel" name="cancel-btn" class="signup-btn">Cancel</button> -->
                      <button type="submit" name="submit-btn" class="signup-btn">Sign in</button>
                    </td>
                  </tr>
            </table>
            <!-- </fieldset> -->
          </form>
          </div>
        </div>
        <div class="footer">
          <%@include file="footer.jsp"%>
        </div>
    </body>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.RegTourist;
import beans.TouristBean;
import dbConnection.DbConnect;
import debug.MainDebugger;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author sudhan
 */
public class TouristRegServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TouristRegServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TouristRegServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        // debuuger prupose
        PrintWriter out = response.getWriter();
        
       TouristBean tourist = new TouristBean();
       tourist.setFirstName(request.getParameter("firstName"));
       tourist.setLastName(request.getParameter("lastName"));
       tourist.setEmailAdd(request.getParameter("emailAddress"));
       tourist.setUsername(request.getParameter("username"));
       tourist.setPassword(request.getParameter("password")); 
       tourist.setDob(request.getParameter("dob"));
       tourist.setContactNumber(Integer.parseInt(request.getParameter("contactNumber")));
       tourist.setAddNo(request.getParameter("houseNo"));
       tourist.setAddStreet1(request.getParameter("streetAdd-1"));
       tourist.setAddStreet2(request.getParameter("streetAdd-2"));
       tourist.setCity(request.getParameter("city"));
       tourist.setPostalCode(Integer.parseInt(request.getParameter("postalCode")));
       tourist.setCountry(request.getParameter("country"));
       
        try {
            RegTourist reg = new RegTourist();
            boolean resultStatus = reg.register(tourist);
//            MainDebugger debug = new MainDebugger();
//            String rslt = debug.getInfo(tourist);
//            out.print(rslt);
            if (resultStatus == true){
                RequestDispatcher loginReqDispatcher = request.getRequestDispatcher("login.jsp");
                response.addHeader("RegStatus", "success");
                loginReqDispatcher.forward(request, response);
            }
            else{
                RequestDispatcher signupReqDispatcher = request.getRequestDispatcher("Signup-tourist.jsp");
                response.addHeader("RegStatus", "failed");
                out.print("Failed");
                signupReqDispatcher.forward(request, response);
            }         
        } 
        catch (Exception e) {        
            out.print(e.getMessage());
        }
   
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

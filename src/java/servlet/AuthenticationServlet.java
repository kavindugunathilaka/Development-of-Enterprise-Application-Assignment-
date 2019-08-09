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


import beans.AdminBean;
import beans.BusinessBean;
import beans.TouristBean;
import helper.AuthenUser;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author sudhan
 */
public class AuthenticationServlet extends HttpServlet {

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
            out.println("<title>Servlet AuthenticationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthenticationServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
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
        
    // debug purpose
        PrintWriter out = response.getWriter();
        
        String typeOfUser = request.getParameter("typeOfUser");

        RequestDispatcher adminDashReqDisp = request.getRequestDispatcher("dashboard-admin.jsp");
        RequestDispatcher loginReqDisp = request.getRequestDispatcher("login.jsp");

        
        if(typeOfUser.equals("adminUser")){
            AdminBean admin = new AdminBean();
            admin.setUsername(request.getParameter("username"));
            admin.setPassword(request.getParameter("password"));
        
            try {
                AuthenUser authenticate = new AuthenUser();
                boolean loginStatus = authenticate.validateAdmin(admin);
                if (loginStatus) {
                    HttpSession userSession = request.getSession(true);
                    userSession.setAttribute("username",admin.getUsername());
                    userSession.setAttribute("userType", "adminAuth");
                    userSession.setMaxInactiveInterval(60*5);
//                  out.print(loginStatus);
                    response.sendRedirect("dashboard-admin.jsp");
                }
                else {
                    RequestDispatcher adminLoginReqDispatcher = request.getRequestDispatcher("adminLogin.jsp");
                    response.addHeader("loginStatus", "failed");
                    out.print("Failed");
                    adminLoginReqDispatcher.forward(request, response);
                }
            } 
            catch (Exception e) {
                out.print(e.getMessage());
            }
        }
        if (typeOfUser.equals("businessUser")){
            BusinessBean business = new BusinessBean();
            business.setUsername(request.getParameter("username"));
            business.setPassword(request.getParameter("password"));
            
            try {
                AuthenUser authenticate = new AuthenUser();
                boolean loginStatus = authenticate.validateBusiness(business);
                if(loginStatus){
                    HttpSession userSession = request.getSession(true);
                    userSession.setAttribute("username", business.getUsername());
                    userSession.setAttribute("userType", "businessAuth");
                    userSession.setMaxInactiveInterval(60*8);
                    response.sendRedirect("dashboard-business.jsp");
                }
                else{
                    response.addHeader("loginStatus", "failed");
                    out.print("Failed");
                    loginReqDisp.forward(request, response);
                }
            } 
            catch (Exception e) {
                out.print("Exception : "+e.getMessage());
            }
        }
        if (typeOfUser.equals("touristUser")){
            TouristBean tourist = new TouristBean();
            tourist.setUsername(request.getParameter("username"));
            tourist.setPassword(request.getParameter("password"));
            
            try {
                AuthenUser authenticate = new AuthenUser();
                boolean loginStatus = authenticate.validateTourist(tourist);
                if(loginStatus){
                    HttpSession userSession = request.getSession(true);
                    userSession.setAttribute("username", tourist.getUsername());
                    userSession.setAttribute("userType", "touristAuth");
                    userSession.setMaxInactiveInterval(60*8);
                    response.sendRedirect("dashboard-tourist.jsp");
                }
                else{
                    response.addHeader("loginStatus", "failed");
                    out.print("Failed");
                    loginReqDisp.forward(request, response);
                }
            } 
            catch (Exception e) {
                out.print("Exception : "+e.getMessage());
            }
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

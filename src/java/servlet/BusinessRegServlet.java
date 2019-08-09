/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.BusinessBean;
import helper.RegBusiness;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sudhan
 */
public class BusinessRegServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
            PrintWriter out = response.getWriter();
            try {
                
            
            String aproValue =(String) request.getParameter("approve-btn");
            String rejeValue =(String) request.getParameter("reject-btn");
            
            out.print("Approve : "+aproValue+" "+"Reject : "+rejeValue+"\n"+"Hidden Data : "+request.getParameter("username").toString()+"\n");
                
            if(aproValue != null){
               RegBusiness accAprove = new RegBusiness();
               boolean status = accAprove.addAccApprovel(request.getParameter("username").toString());
               if ( status ){
                   response.sendRedirect("dashboard-admin.jsp");
               }
               else{
                   response.addHeader("status-msg","Account is NOT APPROVED");
                   response.sendRedirect("dashboard-admin.jsp");
               }
            }
                
            if(rejeValue != null){
               RegBusiness accReject = new RegBusiness();
               boolean status = accReject.addAccReject(request.getParameter("username").toString());
               if ( status ){
                   response.sendRedirect("dashboard-admin.jsp");
               }
               else{
                   response.addHeader("status-msg","Account is NOT REJECTED");
                   response.sendRedirect("dashboard-admin.jsp");
               }
            }
            
        } 
            catch (Exception e) {
                out.print(e.getMessage());
            }
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
        // debugging purpose
        PrintWriter out = response.getWriter();
        
        BusinessBean business = new BusinessBean();
        business.setOwnerFirstName(request.getParameter("ownersFirstName"));
        business.setOwnerLastName(request.getParameter("ownersLastName"));
        business.setBusinessEmail(request.getParameter("businessEmailAdd"));
        business.setUsername(request.getParameter("username"));
        business.setPassword(request.getParameter("password"));
        business.setBusinessName(request.getParameter("businessName"));
        business.setAddNo(request.getParameter("no"));
        business.setAddStreet1(request.getParameter("streetAdd-1"));
        business.setAddStreet2(request.getParameter("streetAdd-2"));
        business.setCity(request.getParameter("city"));
        business.setPostalCode(Integer.parseInt(request.getParameter("postalCode")));
        business.setProvince(request.getParameter("province"));
        business.setApprovelStatus("pending");
        
        try {
            RegBusiness reg = new RegBusiness();
            
            boolean resultStatus = reg.register(business);
            
            if (resultStatus){
                RequestDispatcher loginReqDispatcher = request.getRequestDispatcher("login.jsp");
                response.addHeader("RegStatus", "success&pending");
                loginReqDispatcher.forward(request, response);
            }
            else{
                RequestDispatcher signupReqDispatcher = request.getRequestDispatcher("Signup-tourist.jsp");
                response.addHeader("RegStatus", "failed");
            //    out.print("Failed");
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

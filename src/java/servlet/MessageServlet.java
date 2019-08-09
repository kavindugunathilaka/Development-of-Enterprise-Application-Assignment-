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

/**
 *
 * @author sudhan
 */
import beans.MessageBean;
import beans.BusinessBean;
import beans.TouristBean;
import beans.EventBean;
import helper.*;
import javax.servlet.RequestDispatcher;

public class MessageServlet extends HttpServlet {

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
        // debug purpose
        PrintWriter out = response.getWriter();
        
        
        ManageEvent magEvent = new ManageEvent();
        ManageUsers magUser = new ManageUsers();
        
        EventBean eventDetail = new EventBean();
        MessageBean msg = new MessageBean();
//        BusinessBean business = new BusinessBean();
        TouristBean tourist = new TouristBean();
        ManageMesg magMsg = new ManageMesg();
        
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        String sender = request.getParameter("sender");
        String userType = request.getParameter("userType");
        String messages = request.getParameter("msgFromSender");
        try {
            eventDetail = magEvent.getSingleEvent(eventId);
            
            msg.setEventId(eventDetail.getEventId());
            msg.setMessage(messages);
            if(userType.equals("touristAuth")){
                msg.setTouristUser(sender);
                msg.setBusinessUser(eventDetail.getBusinessUsername());
            }
            else if(userType.equals("businessAuth")){
                msg.setBusinessUser(sender);
                // tourist are receiver
                        //  use MsgManager 
                        msg.setTouristUser(null);
            }
            
            boolean status = magMsg.sengMsg(msg);
            out.print(status);
            if(status) {
                
                response.addHeader("msgStatus", "message sent");
                response.sendRedirect("message-dashboard.jsp");
            } 
            else{
                
                response.addHeader("msgStatus", "message NOT sent");
                response.sendRedirect("message-dashboard.jsp");
            }
            
        } 
        catch (Exception e) {
            
            out.print(e.getMessage()); 
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
        processRequest(request, response);
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
        processRequest(request, response);
//        PrintWriter out = response.getWriter();
//        ManageEvent magEvent = new ManageEvent();
//        ManageUsers magUser = new ManageUsers();
//        EventBean eventDetail = new EventBean();
//        MessageBean msg = new MessageBean();
////        BusinessBean business = new BusinessBean();
//        TouristBean tourist = new TouristBean();
//        ManageMesg magMsg = new ManageMesg();
//        
//        int eventId = Integer.parseInt(request.getParameter("eventId"));
//        String sender = request.getParameter("sender");
//        String userType = request.getParameter("userType");
//        String messages = request.getParameter("msg");
//        try {
//            eventDetail = magEvent.getSingleEvent(14);
//            out.print(sender+"\n");
//           out.print(userType+"\n"); 
//            out.print(messages+"\n");
//            out.print(eventId+"\n");
//            
//            if(userType.equals("touristAuth")){
//                
//                out.print("TouristSender : "+eventDetail.getBusinessUsername()+"\n");
//            }
//            else if(userType.equals("businessAuth")){
//                out.print("BusinesSender : "+sender);
//                // tourist are receiver
//                        //  use MsgManager 
//                        msg.setTouristUser(null);
//            }
//
//    }
//        catch(Exception e){
//            out.print("Exception "+e.getMessage());
//            }
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

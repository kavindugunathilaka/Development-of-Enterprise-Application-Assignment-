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

import beans.EventBean;
import debug.MainDebugger;
import helper.ManageEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

/**
 *
 * @author sudhan
 */
@MultipartConfig(maxFileSize = 1000000000)
public class EventServlet extends HttpServlet {

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
        
         PrintWriter out = response.getWriter();
        
        String eventAction = request.getParameter("eventAction");
        RequestDispatcher dashbusinessReqDispatcher = request.getRequestDispatcher("dashboard-business.jsp");
        
        if (eventAction.equals("eventReg")) {
            
            EventBean event = new EventBean();
            event.setEventName(request.getParameter("eventName"));
            event.setBusinessUsername(request.getParameter("businessUsername"));
            event.setStartDate(request.getParameter("startDate"));
            event.setEndDate(request.getParameter("endDate"));
            event.setCategory(request.getParameter("eventCat"));
            event.setEventContactNumber(Integer.parseInt(request.getParameter("contactNumber")));
            event.setEventContactPerson(request.getParameter("contactPerson"));
            event.setEventPrice(Integer.parseInt(request.getParameter("eventPrice")));
            event.setEventCity(request.getParameter("city"));
            event.setEventDetails(request.getParameter("eventDetail"));
            Part img = request.getPart("eventImage"); 
            event.setInsertImage(img.getInputStream());
            
//            OutputStream ostream = istream.n
//              byte[] imgByte = istream.
            event.setEventBookDetail(event.getBusinessUsername()+"-booking-"+event.getEventName());
            
           try {
               //debuging 
//               debug.MainDebugger bug =new MainDebugger();
//               String st =bug.addEvent(event);
//               out.print(st);
               
                ManageEvent regEvent = new ManageEvent();
                boolean regStatus = regEvent.addEvent(event);
                            
                if (regStatus){
                    response.addHeader("event-msg", "Event SUCCESSFULLY Recorded");
                    dashbusinessReqDispatcher.forward(request, response);
                }
                else{
                    response.addHeader("event-msg", "Event FAILED to Record");
                //    out.print("Failed");
                    dashbusinessReqDispatcher.forward(request, response);
                }
            } 
            catch (Exception e) {
                out.print(e.getMessage());
            }
        }
        if (eventAction.equals("eventDel")){
            
            EventBean event = new EventBean();
            
            
            try {
                event.setEventId(Integer.parseInt(request.getParameter("eventId")));
                //debuging 
//               debug.MainDebugger bug =new MainDebugger();
//               String st =bug.delEvents(event.getEventId());
//               out.print(st);
//                
                
                ManageEvent del =  new ManageEvent();
                boolean actionStatus  = del.delEvents(event.getEventId());
                if (actionStatus){
                    response.addHeader("event-msg", "Event SUCCESSFULLY DELECTED");
                    dashbusinessReqDispatcher.forward(request, response);
                }
                else{
                    response.addHeader("event-msg", "Event FAILED to Delete");
                //    out.print("Failed");
                    dashbusinessReqDispatcher.forward(request, response);
                }
            } 
            catch (Exception e) {
                out.print(e.getMessage());
            }
    
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

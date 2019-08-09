/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.BookEventBean;
import helper.ManageBookEvent;
import beans.EventBean;
import beans.TouristBean;
import debug.MainDebugger;
import helper.ManageUsers;
import helper.ManageEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sudhan
 */
public class BookEventServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        
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
    //    processRequest(request, response);
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
    //    processRequest(request, response);
           // debugg
            PrintWriter out = response.getWriter();
          int eventId = Integer.parseInt(request.getParameter("eventId"));
        String touristUsername = request.getParameter("touristUsername");
        ManageEvent magEvent = new ManageEvent();
        ManageUsers magUser = new ManageUsers();
        EventBean  eventDetail = new EventBean();
        TouristBean tourist = new TouristBean();
        BookEventBean evnt = new BookEventBean();
        ManageBookEvent bookEvent = new ManageBookEvent();
        try {
            eventDetail = magEvent.getSingleEvent(eventId);
            tourist = magUser.getTouristSingleUser(touristUsername);
            if (tourist.getUsername() != null){
                evnt.setEventBookTable(eventDetail.getEventBookDetail()); 
                evnt.setTouristFirstName(tourist.getFirstName());
                evnt.setTouristLastName(tourist.getLastName());
                evnt.setTouristEmailAdd(tourist.getEmailAdd());
                evnt.setMobileNumber(Integer.parseInt(request.getParameter("contactNumber")));
                evnt.setBookingDate(request.getParameter("bookDate"));
                evnt.setBookingTime(request.getParameter("bookTime"));
                evnt.setNumberOfPerson(Integer.parseInt(request.getParameter("numPeople")));
                int totalPrice =evnt.getNumberOfPerson() + eventDetail.getEventPrice() ;
                evnt.setTotalPrice(totalPrice);

                boolean bookStatus = bookEvent.addbookEvent(evnt);
                RequestDispatcher dashboardDispatcher = request.getRequestDispatcher("dashboard-tourist.jsp");
                if (bookStatus == true){

                    response.addHeader("event-msg", "Successfuly to book");
                    dashboardDispatcher.forward(request, response);
                }
                else{
                    response.addHeader("event-msg", "FAILED to book");
                    out.print("Failed");
                    dashboardDispatcher.forward(request, response);
                }
            }
            else{
                out.print("Tourist Name : "+tourist.getFirstName());
            }
            
                // debugger
//                MainDebugger bug = new MainDebugger();
//                out.print(bug.addbookEvent(evnt)); 
        } 
        catch (Exception e) {
            out.print("Exception : "+e.getMessage());
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

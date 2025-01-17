/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SyazKhwarzm
 */
public class viewSchedule extends HttpServlet {

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
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<a href='viewStaff'>Return</a>");
        out.println("<h1>Schedule List</h1>");
        
        List<Schedule> list=ScheduleDao.getAllSchedule();
        
        out.print("<table border ='1' width='100%'");
        out.print("<tr><th>Schedule Id</th><th>Staff Id</th><th>Date</th><th>Time</th><th>Status</th>"+
                "<th>Edit</th><th>Delete</th></tr>");
        
        for(Schedule e:list){
            out.print("<tr><td>"+e.getScheduleId()+"</td><td>"+e.getStaffId()+"</td><td>"+e.getDate()+"</td><td>"+e.getTime()+"</td><td>"+e.getStatus()+"</td><td><a href='EditSchedule?ScheduleId="
                    +e.getScheduleId()+"'>edit</a></td> <td><a href='DeleteSchedule?ScheduleId="+e.getScheduleId()+"'>delete</a></td></tr>");
            
        }
        out.print("</table>");
        
        out.close();
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package AccountController;

import DBcontext.AcountDBcontext;
import DBcontext.ClassDBcontext;
import DBcontext.StudentDBcontext;


import Model.Account;
import Model.Classs;
import Model.Student;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author phung
 */
public class AcountController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    request.getRequestDispatcher("login.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String user=request.getParameter("user");
        String Pass=request.getParameter("pass");
        AcountDBcontext dbaccount = new AcountDBcontext();
        Account accounts = dbaccount.getAccountbyuserpass(user, Pass); 
        if(accounts == null)
        {
           request.setAttribute("error", "error");
            request.getRequestDispatcher("login.jsp").forward(request, response);
           
        }
        else
        {   
             if(accounts.getRoless()==0)
             {
                 request.getSession().setAttribute("account", accounts);
            request.getRequestDispatcher("Admin").forward(request, response);
             }
             else {
                 request.getSession().setAttribute("account", accounts);
            request.getRequestDispatcher("Home").forward(request, response);
             }
    }}

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

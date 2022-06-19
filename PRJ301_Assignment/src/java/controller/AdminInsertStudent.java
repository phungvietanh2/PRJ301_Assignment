/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DBcontext.ClassDBcontext;
import DBcontext.StudentDBcontext;
import Model.Classs;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author phung
 */
public class AdminInsertStudent extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminInsertStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminInsertStudent at " + request.getContextPath() + "</h1>");
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
        ClassDBcontext dbclass = new ClassDBcontext();
        ArrayList<Classs> classs = dbclass.list();
        request.setAttribute("classs", classs);
        request.getRequestDispatcher("admin/insert student.jsp").forward(request, response);
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
        String raw_rollnumber = request.getParameter("MaSV");
        String raw_Namesv = request.getParameter("TenSV");
        String raw_dob = request.getParameter("dob");
        String raw_gmail = request.getParameter("gmail");
        String raw_gender = request.getParameter("gender");
        String raw_Nameclass = request.getParameter("nameclass");

//        check 
        //validate inputs
        Student s = new Student();
        s.setMasv(raw_rollnumber);
        s.setName(raw_Namesv);
        s.setDob(Date.valueOf(raw_dob));
        s.setGmail(raw_gmail);
        s.setGender(raw_gender);
        Classs c = new Classs();
        c.setTenlop(raw_Nameclass);
        s.setClasss(c);
        StudentDBcontext dbstudent = new StudentDBcontext();   
        dbstudent.insert(s);
        request.setAttribute("action", "Insert Successfully");
        request.getRequestDispatcher("admin/successfully.jsp").forward(request, response);
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

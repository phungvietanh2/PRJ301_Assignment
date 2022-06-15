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
        String raw_Masv = request.getParameter("MaSV");
        String raw_TenSV = request.getParameter("TenSV");
        String raw_NgaySinh = request.getParameter("dob");
        String raw_gmail = request.getParameter("gmail");
        String raw_MaLop = request.getParameter("did");
        String raw_GioiTinh = request.getParameter("gender");

//        check 
        //validate inputs
        Student s = new Student();
        s.setMasv(raw_Masv);
        s.setName(raw_TenSV);
        s.setBirthday(Date.valueOf(raw_NgaySinh));
        s.setGmail(raw_gmail);
        s.setGender(raw_GioiTinh);
        Classs c = new Classs();
        c.setMalop(Integer.parseInt(raw_MaLop));
        s.setClasss(c);
        StudentDBcontext dbstudent = new StudentDBcontext();
//        Student acc = dbstudent.checkStudent(raw_Masv);
//        if (acc == null) {
//            request.setAttribute("exist", "\"Error ! This student ID already exists or is already in the class .\"\n" +//
//"                    + \" Please check ID student here of back insert\"");
//            request.getRequestDispatcher("admin/successfully.jsp").forward(request, response);
//       } else {
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

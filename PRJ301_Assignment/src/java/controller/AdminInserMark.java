/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DBcontext.MarkDBcontext;
import DBcontext.StudentDBcontext;
import Model.Student;
import Model.subjects;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author phung
 */
public class AdminInserMark extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet AdminInserMark</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminInserMark at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        SubjectsDBcontext dbSubjects = new SubjectsDBcontext();
        ArrayList<subjects> subjectss = dbSubjects.list();
        request.setAttribute("subjectss", subjectss);
         StudentDBcontext dbstudent = new StudentDBcontext();
        ArrayList<Student> students = dbstudent.list();
        request.setAttribute("students", students);
        request.getRequestDispatcher("admin/AdminInsertMark.jsp").forward(request, response);
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
         String raw_Masv = request.getParameter("MaSV");
         String raw_Mamh = request.getParameter("Mamh");
         String raw_mark1 = request.getParameter("Active");
//         String raw_Mark21 = request.getParameter("Exercise1");
//         String raw_Mark22 = request.getParameter("Exercise2");
//         String raw_Mark3 = request.getParameter("Presentation");
//         String raw_Mark4 = request.getParameter("Project");
//         String raw_Mark5 = request.getParameter("FinalExam");
//         String raw_Mark6 = request.getParameter("FinalExamResit");
         
         subjects s =new subjects();
         s.setMamh(raw_Mamh);
         Mark m =new Mark();
         m.setMasv(raw_Masv);
         m.setMark1(Integer.parseInt(raw_mark1));
//         m.setMark21(Integer.parseInt(raw_Mark21));
//         m.setMark22(Integer.parseInt(raw_Mark22));
//         m.setMark3(Integer.parseInt(raw_Mark3));
//         m.setMark4(Integer.parseInt(raw_Mark4));
//         m.setMark5(Integer.parseInt(raw_Mark5));
//         m.setMark6(Integer.parseInt(raw_Mark6));
         
         m.setSubjectss(s);
         MarkDBcontext dbmark =new MarkDBcontext();
         dbmark.insert(m);
         request.setAttribute("action", "Insert Successfully");
         request.getRequestDispatcher("admin/successfully.jsp").forward(request, response);

    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

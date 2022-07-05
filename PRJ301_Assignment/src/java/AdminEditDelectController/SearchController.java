/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminEditDelectController;

import DBcontext.AssignmentDBcontext;
import DBcontext.AssignmentStudentcontext;
import DBcontext.ClassDBcontext;
import DBcontext.StudentDBcontext;
import Model.Assignment;
import Model.Student;
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
public class SearchController extends HttpServlet {

    AssignmentDBcontext dbas = new AssignmentDBcontext();
    ClassDBcontext dbclass = new ClassDBcontext();
    AssignmentStudentcontext dbasidstudent = new AssignmentStudentcontext();
    StudentDBcontext dbstudent = new StudentDBcontext();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Student> students = dbstudent.list();
//        ArrayList<Assignment> Assignments = dbas.list();
        request.setAttribute("students", students);
//        request.setAttribute("Assignments", Assignments);
//        System.out.println(Assignments);
       // request.setAttribute("AssignmentIDSTUDENTs", dbasidstudent.getbymark(id));
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
        String idstudent = request.getParameter("searchsstudent");
        System.out.println(idstudent);
        ArrayList<Student> studentss = dbstudent.searchid(idstudent);
        request.setAttribute("students", studentss);

        request.getRequestDispatcher("admin/AdminSearch.jsp").forward(request, response);
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

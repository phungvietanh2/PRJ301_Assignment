/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminListController;

import DBcontext.AssignmentDBcontext;
import DBcontext.AssignmentStudentcontext;
import DBcontext.ClassDBcontext;
import DBcontext.StudentDBcontext;
import Model.Assignment;
import Model.AssignmentStudent;
import Model.Classs;
import Model.Student;
import Model.Subjects;
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
public class AdminListClassMark extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    AssignmentDBcontext dbas = new AssignmentDBcontext();
    ClassDBcontext dbclass = new ClassDBcontext();
    AssignmentStudentcontext dbasidstudent = new AssignmentStudentcontext();
    StudentDBcontext dbstudent = new StudentDBcontext();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("classs", dbclass.list());
        request.getRequestDispatcher("admin/AdminListClassMark.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        request.setAttribute("Assignments", dbas.SearchByclass(id));

        request.setAttribute("classs", dbclass.list());

        request.setAttribute("Students", dbstudent.SearchByidClass(id));
        
        request.setAttribute("AssignmentIDSTUDENTs", dbasidstudent.getbymark(id));

        request.getRequestDispatcher("admin/AdminListClassMark.jsp").forward(request, response);

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

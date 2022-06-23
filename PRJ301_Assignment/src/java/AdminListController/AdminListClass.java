/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminListController;

import DBcontext.ClassDBcontext;
import DBcontext.IOT102DBcontext;
import DBcontext.PRJ301DBcontext;
import DBcontext.StudentDBcontext;
import Model.Classs;
import Model.IOT102;
import Model.PRJ301;
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
public class AdminListClass extends HttpServlet {

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
            out.println("<title>Servlet AdminListClass</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminListClass at " + request.getContextPath() + "</h1>");
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

        request.getRequestDispatcher("admin/AdminListClass.jsp").forward(request, response);
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

        ClassDBcontext dbclass = new ClassDBcontext();
        ArrayList<Classs> classs = dbclass.list();
        request.setAttribute("classs", classs);

        StudentDBcontext dbstudent = new StudentDBcontext();
        ArrayList<Student> students = dbstudent.list();
        request.setAttribute("students", students);
        
        String id = request.getParameter("id");
        IOT102DBcontext dbIOT102s = new IOT102DBcontext();
       ArrayList<IOT102> IOT102s = dbIOT102s.SearchMarkClass(id);
       request.setAttribute("IOT102s", IOT102s);
        
       
        PRJ301DBcontext dbprj301 = new PRJ301DBcontext();
        ArrayList<PRJ301> prj301s = dbprj301.SearchMarkClass(id);
        request.setAttribute("prj301s", prj301s);
        request.getRequestDispatcher("admin/AdminListClass.jsp").forward(request, response);
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
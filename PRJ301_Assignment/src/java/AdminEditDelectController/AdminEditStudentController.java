/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminEditDelectController;

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
public class AdminEditStudentController extends HttpServlet {

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
            out.println("<title>Servlet AdminEditStudentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminEditStudentController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    StudentDBcontext dbstudent = new StudentDBcontext();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        String id = request.getParameter("id");
//       int id = Integer.parseInt("id");
        request.setAttribute("student", dbstudent.get(id));
        request.getRequestDispatcher("admin/AdminEditStudent.jsp").forward(request, response);
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

        String raw_Srollnumber = request.getParameter("Sid");
        String raw_Sname = request.getParameter("Sname");
        String raw_Sgender = request.getParameter("Sgender");
        String raw_Sdob = request.getParameter("Sdob");
        String raw_Sgmail = request.getParameter("Sgmail");
        String raw_Sstart = request.getParameter("Sstart");

        Student s = new Student();
        s.setSid(Integer.parseInt(raw_Srollnumber));
        s.setSname(raw_Sname);
        s.setSgender(raw_Sgender);
        s.setSdob(Date.valueOf(raw_Sdob));
        s.setSgmail(raw_Sgmail);
        s.setStart(raw_Sstart);

        dbstudent.update(s);

        request.setAttribute("student", s);

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

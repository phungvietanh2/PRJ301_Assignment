/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminInsertController;

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

        request.getRequestDispatcher("admin/AdminInsertStudent.jsp").forward(request, response);
    }

    StudentDBcontext dbstudent = new StudentDBcontext();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student s = new Student();

        s.setRollnumber(request.getParameter("Srollnumbers"));
        s.setSname(request.getParameter("Sname"));
        s.setSgender(request.getParameter("Sgender"));
        s.setSdob(Date.valueOf(request.getParameter("Sdob")));
        s.setSgmail(request.getParameter("Sgmail"));
        s.setStart(request.getParameter("Sstart"));
        s.setSk(Integer.parseInt(request.getParameter("Sk")));

//       String[] indexs = request.getParameterValues("index");
//        for (String index : indexs) {
//            s.setRollnumber(request.getParameter("Srollnumbers" + index));
//            s.setSname(request.getParameter("Sname" + index));
//            s.setSgender(request.getParameter("Sgender" + index));
//            s.setSdob(Date.valueOf(request.getParameter("Sdob" + index)));
//            s.setSgmail(request.getParameter("Sgmail" + index));
//            s.setStart(request.getParameter("Sstart" + index));
//            s.setSk(Integer.parseInt(request.getParameter("Sk" + index)));
//        }

        dbstudent.insert(s);

        response.getWriter().println("done!");
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

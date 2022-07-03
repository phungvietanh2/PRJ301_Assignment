package HomeSinhVienController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import DBcontext.AssignmentDBcontext;
import DBcontext.AssignmentIDSTUDENTDBcontext;
import DBcontext.ClassDBcontext;
import DBcontext.CourseDBcontext;
import DBcontext.StudentDBcontext;
import DBcontext.TermDBcontext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author phung
 */
public class MarkReport2Controller extends HttpServlet {

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
            out.println("<title>Servlet MarkReport2Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MarkReport2Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    TermDBcontext dbterm = new TermDBcontext();
    StudentDBcontext dbstudent = new StudentDBcontext();
    ClassDBcontext dbclass = new ClassDBcontext();
    CourseDBcontext dbcourse = new CourseDBcontext();
    AssignmentIDSTUDENTDBcontext dbass = new AssignmentIDSTUDENTDBcontext();
    AssignmentDBcontext dba = new AssignmentDBcontext();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String iduser = request.getParameter("iduser");
        String id = request.getParameter("id");
        String sid = request.getParameter("ssid");
        String ssid = request.getParameter("sssid");
        request.setAttribute("students", dbstudent.list());
        request.setAttribute("Terms", dbterm.getid(iduser));

        request.setAttribute("classs", dbclass.getid(id, iduser));
       request.setAttribute("assstudent", dbass.getidstudentmark(sid, iduser));
       
        request.setAttribute("as", dba.SearchBycours(ssid));
        System.out.println( dba.SearchBycours(ssid));
        request.getRequestDispatcher("Mark Report 2.jsp").forward(request, response);
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

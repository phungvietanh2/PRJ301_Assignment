package HomeSinhVienController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import DBcontext.AssignmentDBcontext;
import DBcontext.AssignmentStudentcontext;
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
public class MarkReport2Controller extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    TermDBcontext dbterm = new TermDBcontext();
    StudentDBcontext dbstudent = new StudentDBcontext();
    ClassDBcontext dbclass = new ClassDBcontext();
    CourseDBcontext dbcourse = new CourseDBcontext();
    AssignmentStudentcontext dbass = new AssignmentStudentcontext();
    AssignmentDBcontext dba = new AssignmentDBcontext();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String iduser = request.getParameter("iduser");
        String idterms = request.getParameter("idterms"); 
        String idclass  = request.getParameter("idclass");
        String idcounrse = request.getParameter("idcourse");
        
        request.setAttribute("students", dbstudent.list());
        request.setAttribute("Terms", dbterm.getid(iduser));

        request.setAttribute("classs", dbclass.getid_user(idterms, iduser));
        
       request.setAttribute("assidstudent", dbass.getid_class_user(idclass, iduser));
       
       
//       request.setAttribute("assstudent1", dbass.getidstudentmark1(sid, iduser));
       request.setAttribute("average", dbass.getid_average(idclass,iduser,idcounrse));
        request.setAttribute("asstudent", dba.getid_course(idcounrse));
       
        request.getRequestDispatcher("HomeSV/Mark Report 2.jsp").forward(request, response);
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

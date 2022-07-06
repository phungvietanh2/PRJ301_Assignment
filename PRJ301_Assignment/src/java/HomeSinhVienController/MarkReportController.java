package HomeSinhVienController;

import DBcontext.AssignmentStudentcontext;
import DBcontext.ClassDBcontext;
import DBcontext.CourseDBcontext;
import DBcontext.StudentDBcontext;
import DBcontext.TermDBcontext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MarkReportController extends HttpServlet {

    TermDBcontext dbterm = new TermDBcontext();
    StudentDBcontext dbstudent = new StudentDBcontext();
    ClassDBcontext dbclass = new ClassDBcontext();
    CourseDBcontext dbcourse = new CourseDBcontext();
    AssignmentStudentcontext dbass = new AssignmentStudentcontext();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String iduser = request.getParameter("iduser");
        String idterms = request.getParameter("idterms");
        
        request.setAttribute("students", dbstudent.list());
        request.setAttribute("Terms", dbterm.getid(iduser));

        request.setAttribute("classs", dbclass.getid_user(idterms, iduser));
        
        request.getRequestDispatcher("HomeSV/Mark Report.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}

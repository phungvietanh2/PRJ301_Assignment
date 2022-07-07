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
import Model.AssignmentStudent;
import Model.Student;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

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
        String idclass = request.getParameter("idclass");
        String idcounrse = request.getParameter("idcourse");

        request.setAttribute("Terms", dbterm.getid(iduser));
    
        request.setAttribute("classs", dbclass.getid_user(idterms, iduser));

        request.setAttribute("assidstudent", dbass.getid_class_user(idclass, iduser));
       
        ArrayList<Student> students = dbstudent.SearchByidStudent_user(iduser); 
        double avg = 0;
         for (Student student : students) {
            boolean check = true;
            ArrayList<AssignmentStudent> asidstudent = dbass.countAvgSV( iduser , idcounrse);
            System.out.println(student);
             System.out.println(asidstudent);
            for (AssignmentStudent o : asidstudent) {
                if ((o.getAssignments().getAweight() == 40 && o.getAsmarkk() < 4)
                        || (o.getAssignments().getAweight() == 50 && o.getAsmarkk() < 4)
                        || (o.getAssignments().getAweight() == 35 && o.getAsmarkk() < 4)) {
                    check = false;
                    student.setStatus(0);
                }
                avg += o.getAsmarkk() * o.getAssignments().getAweight() / 100;
            }
            if (avg >= 5 && check == true) {  
                student.setStatus(1);
            } else {
                student.setStatus(0);
            }
        }
       
        request.setAttribute("as", students);
        
          System.out.println(avg);
//       request.setAttribute("assstudent1", dbass.getidstudentmark1(sid, iduser));
        request.setAttribute("average", dbass.getid_average(idclass, iduser, idcounrse));
        request.setAttribute("asstudent", dba.getid_course(idcounrse));
        request.getRequestDispatcher("HomeSV/Mark Report 2.jsp").forward(request, response);
    }

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

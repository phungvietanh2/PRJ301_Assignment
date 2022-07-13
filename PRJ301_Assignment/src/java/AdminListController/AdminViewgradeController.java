/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminListController;

import DBcontext.AssignmentDBcontext;
import DBcontext.AssignmentStudentcontext;
import DBcontext.ClassDBcontext;
import DBcontext.CourseDBcontext;
import DBcontext.StudentDBcontext;
import DBcontext.TermDBcontext;
import Model.AssignmentStudent;
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
public class AdminViewgradeController extends HttpServlet {

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
        request.getRequestDispatcher("admin/adminViewgrade.jsp").forward(request, response);
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
        String idstudent = request.getParameter("idstudent");
        String idterms = request.getParameter("idterms");
        String idclass = request.getParameter("idclass");
        String idcounrse = request.getParameter("idcourse");
         
        request.setAttribute("assignment", dba.getid_class(idstudent, idclass));

        request.setAttribute("classs", dbclass.getid_user(idterms, iduser));

        request.setAttribute("assidstudent", dbass.getid_class_student(idclass, idstudent));
        System.out.println( dbass.getid_class_user(idclass, iduser));
        ArrayList<Student> students = dbstudent.SearchByidStudent_student(idstudent);
        double avg = 0;
        for (Student student : students) {
            boolean check = true;
            ArrayList<AssignmentStudent> asidstudent = dbass.avg_sv_view(idstudent, idcounrse);
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
        request.setAttribute("average", dbass.getid_average_student(idclass, idstudent, idcounrse));
     //   request.setAttribute("asstudent", dba.getid_course(idcounrse));
        request.getRequestDispatcher("admin/adminViewgrade.jsp").forward(request, response);
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

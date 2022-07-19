/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package HomeSinhVienController;

import DBcontext.AssignmentDBcontext;
import DBcontext.AssignmentStudentcontext;
import DBcontext.ClassDBcontext;
import DBcontext.CourseDBcontext;
import DBcontext.StudentDBcontext;
import DBcontext.TermDBcontext;
import Model.AssignmentStudent;
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
public class AcademicTranscriptController extends HttpServlet {

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
        ArrayList<Subjects> courses = dbcourse.getidcourse_user(iduser); 
         int pass = 0;
        double avg = 0;

        // float avg1 = 0;
        for (Subjects o : courses) {
            boolean check = true;        
            ArrayList<AssignmentStudent> asidstudent = dbass.countAvg1(iduser , o.getSuid()); 
            for (AssignmentStudent oo : asidstudent) {
                System.out.println(oo);
                if ((oo.getAssignments().getAweight() == 40 && oo.getAsmarkk() < 4)
                        || (oo.getAssignments().getAweight() == 50 && oo.getAsmarkk() < 4)
                        || (oo.getAssignments().getAweight() == 35 && oo.getAsmarkk() < 4)) {
                    check = false;
                    o.setStatus(0);          
                }           
                avg += oo.getAsmarkk() * oo.getAssignments().getAweight() / 100;
                System.out.println(avg);
            }

            if (avg >= 5 &&  avg <= 10  && check == true || 
                avg >= 750 && check == true ) {
                o.setStatus(1);
            } else {
                o.setStatus(0);
            }
        }
        
       // request.setAttribute("a", dbass.getid_average1(iduser, idcourse));
       
       //request.setAttribute("courses", avg1);
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("HomeSV/Academic Transcript.jsp").forward(request, response);
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

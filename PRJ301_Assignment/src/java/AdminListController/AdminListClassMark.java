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
import Model.Mark;
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
        String[] sub = id.split("_");
        
        request.setAttribute("Assignments", dbas.SearchByclass(sub[0]));

        request.setAttribute("classs", dbclass.list());

        ArrayList<Student> listS = dbstudent.SearchByidClass(sub[0]);
        int pass = 0;
        for (Student student : listS) {

            ArrayList<Mark> listMark = new ArrayList<>(dbstudent.countAvg(student.getSid(),sub[1]));
            double avg = 0;

            for (Mark mark : listMark) {
                if ((mark.getWeight() == 30 && mark.getMark() < 4) || (mark.getWeight() == 40 && mark.getMark() < 4) || (mark.getWeight() == 50 && mark.getMark() < 4) ) {
                    
                    student.setStatus(0);
                }
                avg += mark.getMark() * mark.getWeight() / 100;
            }
            if (avg >= 5) {
                pass++;
                student.setStatus(1);
            } else {
                student.setStatus(0);
            }
        }
        request.setAttribute("pass", pass);
        request.setAttribute("fail", listS.size() - pass);
        request.setAttribute("Students", listS);

        request.setAttribute("AssignmentIDSTUDENTs", dbasidstudent.getbymark(sub[0]));

        request.getRequestDispatcher("admin/AdminListClassMark.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

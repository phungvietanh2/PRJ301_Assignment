/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminListController;

import DBcontext.AssignmentStudentcontext;
import DBcontext.ClassDBcontext;
import DBcontext.CourseDBcontext;
import DBcontext.StudentDBcontext;
import DBcontext.TermDBcontext;
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
public class AdminListStudent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    TermDBcontext dbterm = new TermDBcontext();
    ClassDBcontext dbclass = new ClassDBcontext();
    CourseDBcontext dbcourse = new CourseDBcontext();
    AssignmentStudentcontext dbass = new AssignmentStudentcontext();
    StudentDBcontext dbstudent = new StudentDBcontext();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //String iduser = request.getParameter("iduser");
        String idterms = request.getParameter("idterms");
        String idcourse = request.getParameter("idcourse");
        String idclass = request.getParameter("idclass");
        System.out.println(idclass);
        request.setAttribute("students", dbstudent.getid_list(idcourse,idterms,idclass));
        request.setAttribute("Terms", dbterm.list());
        request.setAttribute("course", dbcourse.getid_course(idterms));
       
        request.setAttribute("classs", dbclass.getid_course(idcourse ,idterms));
        
           System.out.println(  dbstudent.getid_list(idcourse,idterms,idclass));
          
          
          
        // request.setAttribute("classs", dbclass.getid_user(idterms, iduser));
//        String raw_page = request.getParameter("page");
//
//        if (raw_page == null) {
//            raw_page = "1";
//        }
//
//        int pageindex = Integer.parseInt(raw_page);
//        int pagesize = Integer.parseInt(getServletContext().getInitParameter("pagesize"));
//        ArrayList<Student> students = dbstudent.Pagination(pageindex, pagesize);
//        int totalRecords = dbstudent.count();
//        int totalpage = (totalRecords % pagesize == 0) ? totalRecords / pagesize
//                : (totalRecords / pagesize) + 1;
//        request.setAttribute("pageindex", pageindex);
//        request.setAttribute("totalpage", totalpage);
//        request.setAttribute("students", students);
        request.getRequestDispatcher("admin/AdminListStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("admin/successfully.jsp").forward(request, response);
    }
}

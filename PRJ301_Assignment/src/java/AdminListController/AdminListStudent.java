/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminListController;

import DBcontext.ClassDBcontext;
import DBcontext.StudentDBcontext;
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
      StudentDBcontext dbstudent = new StudentDBcontext();
     String raw_page = request.getParameter("page");
   
       if(raw_page ==null)
       {
           raw_page = "1";
       }
        
        int pageindex = Integer.parseInt(raw_page);
        int pagesize =  Integer.parseInt(getServletContext().getInitParameter("pagesize"));
         ArrayList<Student> students = dbstudent.Pagination(pageindex, pagesize);
        int totalRecords = dbstudent.count();
        int totalpage = (totalRecords%pagesize==0)?totalRecords/pagesize
                                :(totalRecords/pagesize)+1;
       request.setAttribute("pageindex", pageindex);
       request.setAttribute("totalpage", totalpage);
       request.setAttribute("students", students);
       request.getRequestDispatcher("admin/AdminListStudent.jsp").forward(request, response);
    } 
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}



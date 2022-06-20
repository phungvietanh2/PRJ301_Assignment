/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package AdminInsertController;

import DBcontext.ClassDBcontext;
import DBcontext.CourseDBcontext;
import DBcontext.IOT102DBcontext;
import DBcontext.StudentDBcontext;
import Model.Classs;
import Model.Subjects;
import Model.MarkIot102;
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
public class AdminInsertMarkIot102 extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminInsertMarkIot102</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminInsertMarkIot102 at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ClassDBcontext dbclass = new ClassDBcontext();
        ArrayList<Classs> classs = dbclass.list();
        request.setAttribute("classs", classs);

        String id = request.getParameter("id");
        StudentDBcontext dbstudent = new StudentDBcontext();
        ArrayList<Student> students = dbstudent.getMarkclass();
        request.setAttribute("students", students);
       
        
       request.getRequestDispatcher("admin/AdminInsertMarkIot102.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String raw_Id = request.getParameter("ID");
        String raw_Activelearning = request.getParameter("Active");
        String raw_Exercise1 = request.getParameter("Exercise1");
        String raw_Exercise2 = request.getParameter("Exercise2");
        String raw_Presentation = request.getParameter("Presentation");
        String raw_Project = request.getParameter("Project");
        String raw_FinalExam = request.getParameter("FinalExam");
        String raw_FinalExamResit = request.getParameter("FinalExamResit");
        
         //validate inputs
         
         
        Student s = new Student();
        s.setSid(Integer.parseInt(raw_Id));
        MarkIot102 m= new MarkIot102();
        m.setActivelearning(Integer.parseInt(raw_Activelearning));
        m.setExercise1(Integer.parseInt(raw_Exercise1));
        m.setExercise2(Integer.parseInt(raw_Exercise2));
        m.setPresentation(Integer.parseInt(raw_Presentation));
        m.setProject(Integer.parseInt(raw_Project));
        m.setFinalExam(Integer.parseInt(raw_FinalExam));
        m.setFinalExamResit(Integer.parseInt(raw_FinalExamResit));
        m.setStudents(s);
        
        IOT102DBcontext dbiot102 = new IOT102DBcontext();
        
        
        dbiot102.insert(m);
       
request.setAttribute("action", "Insert Successfully");
        request.getRequestDispatcher("admin/successfully.jsp").forward(request, response);    
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminInsertController;

import DBcontext.AssignmentStudentcontext;
import Model.Assignment;
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
import sun.security.util.Length;

/**
 *
 * @author phung
 */
public class insertMark extends HttpServlet {

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
            out.println("<title>Servlet insertMark</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet insertMark at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    AssignmentStudentcontext dbass = new AssignmentStudentcontext();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] components = request.getParameterValues("component");
        ArrayList<AssignmentStudent> AssignmentIDSTUDENTs = new ArrayList<>();
        for (String component : components) {
            int sid =Integer.parseInt(component.split("_")[0]);
            int  aid = Integer.parseInt(component.split("_")[1]);
            AssignmentStudent as = new AssignmentStudent();
            String eid = request.getParameter("eid"+sid+"_"+aid);
            System.out.println(sid);
            if (eid.length() > 0) 
                as.setAsid(Integer.parseInt(eid));
             else 
                as.setAsid(-1);           
            String score = request.getParameter("score" + sid + "_" + aid);
            if (score.length() > 0) 
                as.setAsmarkk(Float.parseFloat(score));
             else 
                as.setAsmarkk(-1);    
            Student s = new Student();
            s.setSid(sid);
            Assignment a = new Assignment();
            a.setAid(aid);
            as.setAssignments(a);
            as.setStudents(s);
            AssignmentIDSTUDENTs.add(as);
        }
        dbass.save(AssignmentIDSTUDENTs);
        request.getRequestDispatcher("AdminInsertMarkController").forward(request, response);
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

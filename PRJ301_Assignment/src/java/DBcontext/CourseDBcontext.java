/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Course;
import Model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phung
 */
public class CourseDBcontext extends DBcontext<Course>{

    @Override
    public ArrayList<Course> list() {
       ArrayList<Course> courses=new ArrayList<>();
         try {
             String sql="select Coid , Coname ,Cosession  from Course";
             PreparedStatement stm = connection.prepareStatement(sql);
             ResultSet rs = stm.executeQuery();
             while (rs.next()) {
                 Course C = new Course();
                 C.setId(rs.getInt("Coid"));
                 C.setName(rs.getString("Coname"));
                 C.setSession(rs.getInt("Cosession"));
                 courses.add(C);
             }
         } catch (SQLException ex) {
             Logger.getLogger(CourseDBcontext.class.getName()).log(Level.SEVERE, null, ex);
         }
         return courses;
    }
public static void main(String[] args) {
       CourseDBcontext dao = new CourseDBcontext();
        List<Course> a  = dao.list();
        for (Course o : a) {
            System.out.println(o);
        }
    }
    @Override
    public Course get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

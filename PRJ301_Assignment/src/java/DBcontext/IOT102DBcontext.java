/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.MarkIot102;
import Model.Student;
import Model.subjects;
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
public class IOT102DBcontext extends DBcontext<MarkIot102>{

    @Override
    public ArrayList<MarkIot102> list() {
      ArrayList<MarkIot102> markIot102s = new ArrayList<>();
     
        try {
             String sql ="select s.Scode , s.Clname ,m.Cocode , m.[Active learning],m.[Exercise 1],m.[Exercise 2],m.Presentation,m.Project,"
                     + "m.[Final Exam],m.[Final Exam Resit]\n" +
" from Student s INNER JOIN MarkIot102 m on s.Sid = m.Sid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs= stm.executeQuery();
            while (rs.next()) {
           Student s = new Student();
            s.setMasv(rs.getString("Scode"));
           s.setName(rs.getString("Clname"));
            subjects su = new subjects();
           su.setMamh(rs.getString("Cocode"));
            MarkIot102 m = new MarkIot102();
            m.setActivelearning(rs.getInt("Active learning"));
            m.setExercise1(rs.getInt("Exercise 1"));
            m.setExercise2(rs.getInt("Exercise 2"));
            m.setPresentation(rs.getInt("Presentation"));
            m.setProject(rs.getInt("Project"));
            m.setFinalExam(rs.getInt("Final Exam"));
            m.setFinalExamResit(rs.getInt("Final Exam Resit"));
           m.setStudents(s);
           m.setSubjectss(su);
            markIot102s.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IOT102DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return markIot102s;
    }
  public static void main(String[] args) {
        IOT102DBcontext dao = new IOT102DBcontext();
        List<MarkIot102> a = dao.list();
       // System.out.println(a);
        for (MarkIot102 O : a) {
           System.out.println(a);
        }
    }
    @Override
    public MarkIot102 get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(MarkIot102 model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(MarkIot102 model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(MarkIot102 model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

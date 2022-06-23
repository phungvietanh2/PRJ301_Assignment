/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.IOT102;
import Model.Student;
import Model.Subjects;
import java.util.ArrayList;
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
public class IOT102DBcontext extends DBcontext<IOT102> {

    @Override
    public ArrayList<IOT102> list() {
        ArrayList<IOT102> IOT102S = new ArrayList<>();

        try {
            String sql = "";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setRollnumber(rs.getString("Srollnumber"));
                Subjects su = new Subjects();
                su.setSuid(rs.getString("Coid"));
                IOT102 m = new IOT102();
                m.setActivelearning(rs.getInt("Active learning"));
                m.setExercise1(rs.getInt("Exercise 1"));
                m.setExercise2(rs.getInt("Exercise 2"));
                m.setPresentation(rs.getInt("Presentation"));
                m.setProject(rs.getInt("Project"));
                m.setFinalExam(rs.getInt("Final Exam"));
                m.setFinalExamResit(rs.getInt("Final Exam Resit"));
                m.setStudents(s);
                m.setSubjectss(su);
                IOT102S.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IOT102DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IOT102S;
    }

    public ArrayList<IOT102> SearchMarkClass(String id) {
        ArrayList<IOT102> IOT102S = new ArrayList<>();

        try {
            String sql = " WITH R AS (SELECT L.Coid , L.Clid FROM Course C INNER JOIN Class L  ON C.Coid = L.Coid )\n" +
"	 SELECT * FROM IOT102 I INNER JOIN R ON I.Coid = R.Coid WHERE R.Clid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setRollnumber(rs.getString("Srollnumber"));
                Subjects su = new Subjects();
                su.setSuid(rs.getString("Coid"));
                IOT102 m = new IOT102();
                m.setActivelearning(rs.getInt("Active learning"));
                m.setExercise1(rs.getInt("Exercise 1"));
                m.setExercise2(rs.getInt("Exercise 2"));
                m.setPresentation(rs.getInt("Presentation"));
                m.setProject(rs.getInt("Project"));
                m.setFinalExam(rs.getInt("Final Exam"));
                m.setFinalExamResit(rs.getInt("Final Exam Resit"));
                m.setStudents(s);

                m.setSubjectss(su);
                IOT102S.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IOT102DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IOT102S;
    }

    public static void main(String[] args) {
        IOT102DBcontext dao = new IOT102DBcontext();
        ArrayList<IOT102> a = dao.SearchMarkClass("SE1092");
        //System.out.println(a);
        //  for (Student student : a) {
        System.out.println(a);
        //  }
    }

    @Override
    public IOT102 get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(IOT102 model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(IOT102 model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(IOT102 model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import java.util.ArrayList;
import Model.PRJ301;
import Model.Student;
import Model.Subjects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author phung
 */
public class PRJ301DBcontext extends DBcontext<PRJ301>{

    public ArrayList<PRJ301> SearchMarkClass(String id) {
        ArrayList<PRJ301> PRJ301s = new ArrayList<>();

        try {
            String sql = " 	 WITH R AS (SELECT L.Coid , L.Clid FROM Course C INNER JOIN Class L  ON C.Coid = L.Coid )\n" +
"	 SELECT * FROM PRJ301 I INNER JOIN R ON I.Coid = R.Coid WHERE R.Clid= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setRollnumber(rs.getString("Srollnumber"));
                Subjects su = new Subjects();
                su.setSuid(rs.getString("Coid"));
                PRJ301 m = new PRJ301();
                m.setProgresstest1(rs.getInt("Progress test 1"));
                m.setProgresstest2(rs.getInt("Progress test 2"));
                m.setWorkshop1(rs.getInt("Workshop 1"));
                m.setWorkshop2(rs.getInt("Workshop 2"));
                m.setProject(rs.getInt("Project"));
                m.setPracticalExam(rs.getInt("Practical Exam"));
                m.setFinalExam(rs.getInt("Final Exam"));
                m.setFinalExamResit(rs.getInt("Final Exam Resit"));
                m.setStudents(s);
                m.setSubjectss(su);
                PRJ301s.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PRJ301DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PRJ301s;
    }

    public static void main(String[] args) {
        PRJ301DBcontext dao = new PRJ301DBcontext();
        ArrayList<PRJ301> a = dao.SearchMarkClass("SE1532");
        //System.out.println(a);
        //  for (Student student : a) {
        System.out.println(a);
        //  }
    }
    @Override
    public ArrayList<PRJ301> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PRJ301 get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(PRJ301 model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(PRJ301 model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(PRJ301 model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

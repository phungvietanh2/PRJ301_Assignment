/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Classs;
import Model.Subjects;
import Model.Term;
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
public class CourseDBcontext extends DBcontext<Subjects> {

    @Override
    public ArrayList<Subjects> list() {
        ArrayList<Subjects> subjectss = new ArrayList<>();
        try {
            String sql = "select Coid , Coname , Cocredit   from Course";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subjects s = new Subjects();
                s.setSuid(rs.getString("Coid"));
                s.setSuname(rs.getString("Coname"));
                s.setCredit(rs.getInt("Cocredit"));

                subjectss.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectss;
    }

    public ArrayList<Subjects> getidcourse_user(String user) {
        ArrayList<Subjects> subjectss = new ArrayList<>();
        try {
            String sql = "select   ROW_NUMBER() OVER (ORDER BY t.Tname ) AS [NO] , t.Tname , c.Coid , c.Coname ,c.Cocredit from Term t  left join Course c  on t.Tid = c.Tid \n"
                    + "								 left join [Group] g on c.Coid = g.Coid \n"
                    + "								  left join GroupStudent gs on gs.Gid = g.Gid\n"
                    + "								  left join Student s on s.Sid = gs.Sid \n"
                    + "								  left join Account ac on ac.Sid = s.Sid \n"
                    + "								  where ac.username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subjects s = new Subjects();
                s.setSuid(rs.getString("Coid"));
                s.setSuname(rs.getString("Coname"));
                s.setCredit(rs.getInt("Cocredit"));
                Term t = new Term();
                t.setTname(rs.getString("Tname"));
                s.setTerms(t);
                subjectss.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectss;
    }

    public static void main(String[] args) {
        CourseDBcontext dao = new CourseDBcontext();
        ArrayList<Subjects> a = dao.getid_course("Summer2022");
        System.out.println(a);
//      for (Subjects student : a) {
//           System.out.println(a);
//        }
    }

    public ArrayList<Subjects> getid_course(String id) {
        ArrayList<Subjects> subjectss = new ArrayList<>();
        try {
            String sql = " select t.Tname, c.Coid , c.Coname from Course c left join Term t on c.Tid = t.Tid where t.Tname = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Term t = new Term();
                t.setTname(rs.getString("Tname"));
                Subjects s = new Subjects();
                s.setSuid(rs.getString("Coid"));
                s.setSuname(rs.getString("Coname"));
                s.setTerms(t);
                subjectss.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectss;
    }

    @Override
    public Subjects get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Subjects model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Subjects model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Subjects model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

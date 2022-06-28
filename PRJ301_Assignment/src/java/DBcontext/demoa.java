/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Assignment;
import Model.AssignmentIDSTUDENT;
import Model.Student;
import Model.demo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phung
 */
public class demoa extends DBcontext<demo> {

    public void a() {

    }

    @Override
    public ArrayList<demo> list() {
        ArrayList<demo> demos = new ArrayList<>();
        try {
            String sql = " select a.* from \n"
                    + "					(select * from AssessmentIDStudent) a \n"
                    + "					INNER JOIN\n"
                    + "					 ( select Srollnumber , Aid , MAX(Asdate) as Asdate from AssessmentIDStudent  group by Aid ,Srollnumber) b  on a.Srollnumber = b.Srollnumber and a.Aid=b.Aid and a.Asdate = b.Asdate  ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Student s = new Student();
                s.setRollnumber(rs.getString("Srollnumber"));
                Assignment a = new Assignment();
                a.setAid(rs.getInt("Aid"));
                demo c = new demo();
                c.setAsmarkk(rs.getFloat("Mark"));
                c.setAsdate(rs.getDate("Asdate"));
                c.setStudents(s);
                c.setAssignments(a);
                demos.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(demoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return demos;
    }

    public static void main(String[] args) {
        demoa dao = new demoa();
        ArrayList<demo> a = dao.list();
        //System.out.println(a);
        for (demo student : a) {
            System.out.println(a);
        }
    }

    @Override
    public demo get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(demo model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(demo model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(demo model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Assignment;
import Model.AssignmentIDSTUDENT;
import Model.Student;
import Model.Subjects;
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
public class AssignmentIDSTUDENTDBcontext extends DBcontext<AssignmentIDSTUDENT> {

    public ArrayList<AssignmentIDSTUDENT> getbymark(String id) {
        ArrayList<AssignmentIDSTUDENT> AssignmentIDSTUDENTs = new ArrayList<>();
        try {
            String sql = " 					 select a.* from \n"
                    + "					(select * from AssessmentIDStudent) a \n"
                    + "					INNER JOIN\n"
                    + "					 ( select Srollnumber , Aid , MAX(Asdate) as Asdate from AssessmentIDStudent  group by Aid ,Srollnumber) b  on a.Srollnumber = b.Srollnumber and a.Aid=b.Aid and a.Asdate = b.Asdate  \n"
                    + "					left JOIN Student s on s.Srollnumber = b.Srollnumber\n"
                    + "				    left JOIN  GroupClass g on g.Srollnumber = s.Srollnumber \n"
                    + "				    left JOIN Class cl on g.Clid = cl.Clid where cl.Clid = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setRollnumber(rs.getString("Srollnumber"));
                Assignment a = new Assignment();
                a.setAid(rs.getInt("Aid"));
                AssignmentIDSTUDENT as = new AssignmentIDSTUDENT();
                as.setAsmarkk(rs.getFloat("Mark"));
                as.setAsdate(rs.getDate("Asdate"));
                as.setStudents(s);
                as.setAssignments(a);
                AssignmentIDSTUDENTs.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentIDSTUDENTDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AssignmentIDSTUDENTs;
    }

    public static void main(String[] args) {
        AssignmentIDSTUDENTDBcontext dao = new AssignmentIDSTUDENTDBcontext();
        ArrayList<AssignmentIDSTUDENT> a = dao.getbymark("SE1501");
        //System.out.println(a);
        for (AssignmentIDSTUDENT student : a) {
            System.out.println(a);
        }
    }

    @Override
    public ArrayList<AssignmentIDSTUDENT> list() {

        return null;
    }

    @Override
    public AssignmentIDSTUDENT get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(AssignmentIDSTUDENT model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(AssignmentIDSTUDENT model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(AssignmentIDSTUDENT model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

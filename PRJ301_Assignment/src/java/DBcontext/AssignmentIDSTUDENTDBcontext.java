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
                as.setAsid(rs.getInt("Asid"));
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

    public void save(ArrayList<AssignmentIDSTUDENT> AssignmentIDSTUDENTs) {

        try {
            connection.setAutoCommit(false);
            for (AssignmentIDSTUDENT o : AssignmentIDSTUDENTs) {
                //insert 
                if (o.getAsid() == -1 && o.getAsmarkk() != -1) {
                    String insert = "INSERT INTO [AssessmentIDStudent]\n"
                            + "           ([Aid]\n"
                            + "           ,[Srollnumber]\n"
                            + "           ,[Mark]\n"
                            + "           ,[Asdate])\n"
                            + "     VALUES\n"
                            + "           (?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,GETDATE())";
                    PreparedStatement stm = connection.prepareStatement(insert);
                    stm.setInt(1,o.getAssignments().getAid() );
                    stm.setString(2, o.getStudents().getRollnumber());
                    stm.setFloat(3,o.getAsmarkk() );
                    stm.executeUpdate();
                }
                //update 
                if (o.getAsid() != -1 && o.getAsmarkk() != -1) {
                    String update = "UPDATE [AssessmentIDStudent]\n"
                            + "   SET [Mark] =?\n"
                            + "   \n"
                            + " WHERE Asid = ?";
                     PreparedStatement stm = connection.prepareStatement(update);
                     stm.setFloat(1,o.getAsmarkk());
                     stm.setInt(2,o.getAsid() );
                     stm.executeUpdate();
                }
                //delete 
                if (o.getAsid() != -1 && o.getAsmarkk() == -1) {
                    String delete = "DELETE [AssessmentIDStudent] WHERE Asid = ? ";
                     PreparedStatement stm = connection.prepareStatement(delete);
                     stm.setInt(1,o.getAsid() );
                     stm.executeUpdate();
                }
            }
            
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

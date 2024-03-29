/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Assignment;
import Model.AssignmentStudent;
import Model.Student;
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
public class AssignmentStudentcontext extends DBcontext<AssignmentStudent> {

    public ArrayList<AssignmentStudent> getbymark(String id) {
        ArrayList<AssignmentStudent> AssignmentIDSTUDENTs = new ArrayList<>();
        try {
            String sql = "select s.Sname, a.* from \n"
                    + "(select * from AssessmentIDStudent) a \n"
                    + "INNER JOIN\n"
                    + " ( select Sid , Aid , MAX(Asdate) as Asdate from AssessmentIDStudent  group by Aid ,Sid) b  on a.Sid = b.Sid and a.Aid=b.Aid and a.Asdate = b.Asdate  \n"
                    + " left JOIN Student s on s.Sid = b.Sid\n"
                    + " left JOIN  GroupStudent g on g.Sid = s.Sid \n"
                    + "  left JOIN [Group] gr on gr.Gid = g.Gid where gr.Gid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("Sid"));
                s.setSname(rs.getString("Sname"));
                Assignment a = new Assignment();
                a.setAid(rs.getInt("Aid"));
                AssignmentStudent as = new AssignmentStudent();
                as.setAsid(rs.getInt("Asid"));
                as.setAsmarkk(rs.getFloat("Mark"));
                as.setAsdate(rs.getDate("Asdate"));
                as.setStudents(s);
                as.setAssignments(a);
                AssignmentIDSTUDENTs.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentStudentcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AssignmentIDSTUDENTs;
    }

    public ArrayList<AssignmentStudent> getid_class_user(String id, String userid) {
        ArrayList<AssignmentStudent> AssignmentIDSTUDENTs = new ArrayList<>();
        try {
            String sql = " select a.Aid,a.Aweight,a.Aname, ass.Mark ,sum(a.Aweight *ass.Mark)/100 as [total] from  Course c \n"
                    + "        left JOIN   [Group] cl on c.Coid = cl.Coid\n"
                    + "      left JOIN GroupStudent g on cl.Gid = g.Gid\n"
                    + "         left JOIN   Student s on s.Sid = g.Sid \n"
                    + "           left join AssessmentIDStudent ass on ass.Sid = s.Sid \n"
                    + "             left join Assessment a on a.Aid = ass.Aid\n"
                    + "          left join Account ac on ac.Sid = s.Sid\n"
                    + "       where cl.Gid = ? and  ac.username= ?\n"
                    + "	    group by a.Aid,a.Aweight,a.Aname, ass.Mark";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, userid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assignment a = new Assignment();
                a.setAid(rs.getInt("Aid"));
                a.setAweight(rs.getInt("Aweight"));
                a.setAname(rs.getString("Aname"));
                AssignmentStudent as = new AssignmentStudent();
                as.setAsmarkk(rs.getFloat("Mark"));
                as.setTotal(rs.getFloat("total"));
                as.setAssignments(a);
                AssignmentIDSTUDENTs.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentStudentcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AssignmentIDSTUDENTs;
    }

    public ArrayList<AssignmentStudent> getid_class_student(String id, String idstudent) {
        ArrayList<AssignmentStudent> AssignmentIDSTUDENTs = new ArrayList<>();
        try {
            String sql = "select a.Aid,a.Aweight,a.Aname, ass.Mark ,sum(a.Aweight *ass.Mark)/100 as [total] from  Course c \n"
                    + "                            left JOIN   [Group] cl on c.Coid = cl.Coid\n"
                    + "                          left JOIN GroupStudent g on cl.Gid = g.Gid\n"
                    + "                             left JOIN   Student s on s.Sid = g.Sid \n"
                    + "                              left join AssessmentIDStudent ass on ass.Sid = s.Sid \n"
                    + "                                 left join Assessment a on a.Aid = ass.Aid\n"
                    + "                             left join Account ac on ac.Sid = s.Sid\n"
                    + "                          where cl.Gid = ? and  s.Sid=?\n"
                    + "                        group by a.Aid,a.Aweight,a.Aname, ass.Mark";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, idstudent);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assignment a = new Assignment();
                a.setAid(rs.getInt("Aid"));
                a.setAweight(rs.getInt("Aweight"));
                a.setAname(rs.getString("Aname"));
                AssignmentStudent as = new AssignmentStudent();
                as.setAsmarkk(rs.getFloat("Mark"));
                as.setTotal(rs.getFloat("total"));
                as.setAssignments(a);
                AssignmentIDSTUDENTs.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentStudentcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AssignmentIDSTUDENTs;
    }

    public ArrayList<AssignmentStudent> getid_average(String id, String userid, String coid) {
        ArrayList<AssignmentStudent> AssignmentIDSTUDENTs = new ArrayList<>();
        try {
            String sql = " select  sum(a.summ) as [AVERAGE] from \n"
                    + "  ( select  a.Aid, a.Aweight , a.Aname ,ass.Mark, cl.Gid,\n"
                    + "    a.Coid, ac.username, sum(a.Aweight *ass.Mark)/100 as summ  from  Course c \n"
                    + "   left JOIN   [Group] cl on c.Coid = cl.Coid\n"
                    + "   left JOIN GroupStudent g on cl.Gid = g.Gid\n"
                    + "   left JOIN   Student s on s.Sid = g.Sid \n"
                    + "   left join AssessmentIDStudent ass on ass.Sid = s.Sid \n"
                    + "   left join Assessment a on a.Aid = ass.Aid\n"
                    + "   left join Account ac on ac.Sid = s.Sid\n"
                    + "   group by a.Aid, a.Aweight , a.Aname ,ass.Mark,cl.Gid,\n"
                    + "    a.Coid, ac.username) a  where a.Gid = ? and a.username=? and a.Coid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, userid);
            stm.setString(3, coid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                AssignmentStudent as = new AssignmentStudent();
                as.setAverage(rs.getFloat("AVERAGE"));
                AssignmentIDSTUDENTs.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentStudentcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AssignmentIDSTUDENTs;
    }

    

    public ArrayList<AssignmentStudent> getid_average_student(String id, String userid, String coid) {
        ArrayList<AssignmentStudent> AssignmentIDSTUDENTs = new ArrayList<>();
        try {
            String sql = " select  sum(a.summ) as [AVERAGE] from \n"
                    + "                      ( select  a.Aid, a.Aweight , a.Aname ,ass.Mark, cl.Gid,\n"
                    + "                       a.Coid, ac.Sid, sum(a.Aweight *ass.Mark)/100 as summ  from  Course c\n"
                    + "                       left JOIN   [Group] cl on c.Coid = cl.Coid\n"
                    + "                       left JOIN GroupStudent g on cl.Gid = g.Gid\n"
                    + "                       left JOIN   Student s on s.Sid = g.Sid \n"
                    + "                       left join AssessmentIDStudent ass on ass.Sid = s.Sid \n"
                    + "                      left join Assessment a on a.Aid = ass.Aid\n"
                    + "                       left join Account ac on ac.Sid = s.Sid\n"
                    + "                       group by a.Aid, a.Aweight , a.Aname ,ass.Mark,cl.Gid,\n"
                    + "                        a.Coid, ac.Sid) a  where a.Gid = ? and a.Sid=? and a.Coid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, userid);
            stm.setString(3, coid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                AssignmentStudent as = new AssignmentStudent();
                as.setAverage(rs.getFloat("AVERAGE"));
                AssignmentIDSTUDENTs.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentStudentcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AssignmentIDSTUDENTs;
    }

    public ArrayList<AssignmentStudent> countAvg(int id, String className) {
        ArrayList<AssignmentStudent> assignmentStudents = new ArrayList<>();
        try {
            String sql = "select  ad.Mark ,a.Aweight from AssessmentIDStudent ad\n"
                    + "inner join \n"
                    + "Assessment a on  a.Aid = ad.Aid \n"
                    + "where ad.Sid = ? and a.Coid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, className);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assignment S = new Assignment();
                S.setAweight(rs.getFloat("Aweight"));
                AssignmentStudent as = new AssignmentStudent();
                as.setAsmarkk(rs.getFloat("Mark"));
                as.setAssignments(S);
                assignmentStudents.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentStudentcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assignmentStudents;
    }

    public ArrayList<AssignmentStudent> countAvg1(String id, String className) {
        ArrayList<AssignmentStudent> assignmentStudents = new ArrayList<>();
        try {
            String sql = "select  ad.Mark ,a.Aweight from AssessmentIDStudent ad\n"
                    + "inner join \n"
                    + "Assessment a on  a.Aid = ad.Aid \n"
                    + "where ad.Sid = ? and a.Coid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, className);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assignment S = new Assignment();
                S.setAweight(rs.getFloat("Aweight"));
                AssignmentStudent as = new AssignmentStudent();
                as.setAsmarkk(rs.getFloat("Mark"));
                as.setAssignments(S);
                assignmentStudents.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentStudentcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assignmentStudents;
    }

    public ArrayList<AssignmentStudent> countAvgSV(String id, String className) {
        ArrayList<AssignmentStudent> assignmentStudents = new ArrayList<>();
        try {
            String sql = "select  ad.Mark ,a.Aweight from AssessmentIDStudent ad\n"
                    + "inner join \n"
                    + "Assessment a on  a.Aid = ad.Aid  inner join Student s on s.Sid = ad.Sid inner join Account ac on ac.Sid = s.Sid\n"
                    + "where ac.username =? and a.Coid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, className);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assignment S = new Assignment();
                S.setAweight(rs.getFloat("Aweight"));
                AssignmentStudent as = new AssignmentStudent();
                as.setAsmarkk(rs.getFloat("Mark"));
                as.setAssignments(S);
                assignmentStudents.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentStudentcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assignmentStudents;
    }

    public ArrayList<AssignmentStudent> countAvgSV1(String id) {
        ArrayList<AssignmentStudent> assignmentStudents = new ArrayList<>();
        try {
            String sql = "select  ad.Mark ,a.Aweight from AssessmentIDStudent ad\n"
                    + "inner join \n"
                    + "Assessment a on  a.Aid = ad.Aid  inner join Student s on s.Sid = ad.Sid inner join Account ac on ac.Sid = s.Sid\n"
                    + "where ac.username =? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assignment S = new Assignment();
                S.setAweight(rs.getFloat("Aweight"));
                AssignmentStudent as = new AssignmentStudent();
                as.setAsmarkk(rs.getFloat("Mark"));
                as.setAssignments(S);
                assignmentStudents.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentStudentcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assignmentStudents;
    }

    public ArrayList<AssignmentStudent> avg_sv_view(String id, String idco) {
        ArrayList<AssignmentStudent> assignmentStudents = new ArrayList<>();
        try {
            String sql = "select  ad.Mark ,a.Aweight from AssessmentIDStudent ad\n"
                    + "                    inner join \n"
                    + "                    Assessment a on  a.Aid = ad.Aid \n"
                    + "                     where ad.Sid =? and a.Coid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, idco);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assignment S = new Assignment();
                S.setAweight(rs.getFloat("Aweight"));
                AssignmentStudent as = new AssignmentStudent();
                as.setAsmarkk(rs.getFloat("Mark"));
                as.setAssignments(S);
                assignmentStudents.add(as);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentStudentcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assignmentStudents;
    }

    public static void main(String[] args) {
       // AssignmentStudentcontext dao = new AssignmentStudentcontext();
       // ArrayList<AssignmentStudent> a = dao.getid_average1("1", "iot102");
      //  System.out.println(a);

    }

    @Override
    public ArrayList<AssignmentStudent> list() {

        return null;
    }

    @Override
    public AssignmentStudent get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(AssignmentStudent model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(AssignmentStudent model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(AssignmentStudent model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void save(ArrayList<AssignmentStudent> AssignmentIDSTUDENTs) {

        try {
            connection.setAutoCommit(false);
            for (AssignmentStudent o : AssignmentIDSTUDENTs) {
                //insert 
                if (o.getAsid() == -1 && o.getAsmarkk() != -1) {
                    String insert = "INSERT INTO [AssessmentIDStudent]\n"
                            + "           ([Aid]\n"
                            + "           ,[Sid]\n"
                            + "           ,[Mark]\n"
                            + "           ,[Asdate])\n"
                            + "     VALUES\n"
                            + "           (?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,GETDATE())";
                    PreparedStatement stm = connection.prepareStatement(insert);
                    stm.setInt(1, o.getAssignments().getAid());
                    stm.setInt(2, o.getStudents().getSid());
                    stm.setFloat(3, o.getAsmarkk());
                    stm.executeUpdate();
                }
                //update 
                if (o.getAsid() != -1 && o.getAsmarkk() != -1) {
                    String update = "UPDATE [AssessmentIDStudent]\n"
                            + "   SET [Mark] =?\n"
                            + "   \n"
                            + " WHERE Asid = ?";
                    PreparedStatement stm = connection.prepareStatement(update);
                    stm.setFloat(1, o.getAsmarkk());
                    stm.setInt(2, o.getAsid());
                    stm.executeUpdate();
                }
                //delete 
                if (o.getAsid() != -1 && o.getAsmarkk() == -1) {
                    String delete = "DELETE [AssessmentIDStudent] WHERE Asid = ? ";
                    PreparedStatement stm = connection.prepareStatement(delete);
                    stm.setInt(1, o.getAsid());
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

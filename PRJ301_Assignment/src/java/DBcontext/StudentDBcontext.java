/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Classs;
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
public class StudentDBcontext extends DBcontext<Student> {

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = " select Sid , Sname , Sgender ,Sdob, Sgmail , Sstart from Student  ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                S.setSname(rs.getString("Sname"));
                S.setSgender(rs.getString("Sgender"));
                S.setSdob(rs.getDate("Sdob"));
                S.setSgmail(rs.getString("Sgmail"));
                S.setStart(rs.getString("Sstart"));
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public ArrayList<Student> list_viewmark() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select  s.Sid ,g.Gname , c.Coid from Student  s  \n"
                    + "				 left join GroupStudent gs on s.Sid = gs.Sid\n"
                    + "				 left join [Group] g on g.Gid = gs.Gid\n"
                    + "				 left join Course c on c.Coid = g.Coid ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Classs cl = new Classs();
                cl.setCname(rs.getString("Gname"));
                Subjects s = new Subjects();
                s.setSuid(rs.getString("Coid"));
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                S.setSubjectss(s);
                S.setClassss(cl);
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

//    public ArrayList<Student> getlist_dssv() {
//        ArrayList<Student> students = new ArrayList<>();
//        try {
//            String sql = "select s.Sid , c.Coid from Student s inner join\n"
//                    + "					GroupStudent gs on s.Sid = gs.Sid inner join\n"
//                    + "					[Group] g on g.Gid = gs.Gid\n"
//                    + "					inner join Course c on g.Coid = c.Coid ";
//            PreparedStatement stm = connection.prepareStatement(sql);
//      
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                Subjects s = new Subjects();
//                s.setSuid(rs.getString("Coid"));
//                Student S = new Student();
//                S.setSid(rs.getInt("Sid"));
//                S.setSubjectss(s);
//                students.add(S);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return students;
//    }

    public ArrayList<Student> getid_list(String idcourse, String idterm, String idclass) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select ROW_NUMBER() OVER (ORDER BY t.Tname ) AS [NO] ,g.Gname ,g.Gid , s.Sid , s.Sname ,c.Coid from Course c\n"
                    + "	 left join Term t on c.Tid=t.Tid\n"
                    + "	left join [Group] g on c.Coid = g.Coid\n"
                    + "	  left join GroupStudent gs on gs.Gid = g.Gid\n"
                    + "	left join Student s on s.Sid = gs.Sid\n"
                    + "  where c.Coid = ? and t.Tname=? and g.Gid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, idcourse);
            stm.setString(2, idterm);
            stm.setString(3, idclass);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subjects s = new Subjects();
                s.setSuid(rs.getString("Coid"));
                Classs cl = new Classs();
                cl.setCname(rs.getString("Gname"));
                cl.setCid(rs.getInt("Gid"));
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                S.setSname(rs.getString("Sname"));
                S.setNo(rs.getInt("NO"));
                S.setClassss(cl);
                S.setSubjectss(s);
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public ArrayList<Student> SearchByidStudent_Class(String id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "  select s.Sid   from Student s  left JOIN  GroupStudent g on g.Sid = s.Sid \n"
                    + " left JOIN [Group] cl on g.Gid = cl.Gid where g.Gid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public ArrayList<Student> SearchByidStudent_user(String id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = " select s.Sid   from Student s  left JOIN  Account ac on ac.Sid = s.Sid  where ac.username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public ArrayList<Student> SearchByidStudent_student(String id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select Sid from Student where Sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public static void main(String[] args) {
        StudentDBcontext dao = new StudentDBcontext();
        ArrayList<Student> a = dao.getid_list("iot102", "Summer2021", "1");
        System.out.println(a);
        for (Student student : a) {
            System.out.println(a);
        }
    }

    public Student get(String id) {
        try {
            String sql = "  select Sid  , Sname , Sgender, Sdob , Sgmail ,Sstart  from Student  where Sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                S.setSname(rs.getString("Sname"));
                S.setSgender(rs.getString("Sgender"));
                S.setSdob(rs.getDate("Sdob"));
                S.setSgmail(rs.getString("Sgmail"));
                S.setStart(rs.getString("Sstart"));
                return S;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Student> searchid(String id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "   select * from Student WHERE Sid like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + id + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                S.setSname(rs.getString("Sname"));
                S.setSgender(rs.getString("Sgender"));
                S.setSdob(rs.getDate("Sdob"));
                S.setSgmail(rs.getString("Sgmail"));
                S.setStart(rs.getString("Sstart"));
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    @Override
    public Student get(int id) {
        try {
            String sql = "  select Sid  , Sname , Sgender, Sdob , Sgmail ,Sstart  from Student  where Sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                S.setSname(rs.getString("Sname"));
                S.setSgender(rs.getString("Sgender"));
                S.setSdob(rs.getDate("Sdob"));
                S.setSgmail(rs.getString("Sgmail"));
                S.setStart(rs.getString("Sstart"));
                return S;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Student model) {

        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [Student]\n"
                    + "           ([Sid]\n"
                    + "           ,[Sname]\n"
                    + "           ,[Sgender]\n"
                    + "           ,[Sdob]\n"
                    + "           ,[Sgmail]\n"
                    + "           ,[Sstart])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getSid());
            stm.setString(2, model.getSname());
            stm.setString(3, model.getSgender());
            stm.setDate(4, model.getSdob());
            stm.setString(5, model.getSgmail());
            stm.setString(6, model.getStart());

            stm.executeUpdate();

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

    @Override
    public void update(Student model) {
        try {
            String sql = "UPDATE [Student]\n"
                    + "     SET [Sname] = ?\n"
                    + "      ,[Sgender] = ?\n"
                    + "      ,[Sdob] = ?\n"
                    + "      ,[Sgmail] = ?\n"
                    + "      ,[Sstart]  = ?\n"
                    + " WHERE [Sid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getSname());
            stm.setString(2, model.getSgender());
            stm.setDate(3, model.getSdob());
            stm.setString(4, model.getSgmail());
            stm.setString(5, model.getStart());
            stm.setInt(6, model.getSid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Student model) {
        try {
            String sql = "DELETE Student"
                    + " WHERE [Sid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getSid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Basic Pagination : Phân trang cơ bản 
    public int count() {

        try {
            String sql = "SELECT COUNT(*) as [sum] FROM Student";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt("sum");

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public ArrayList<Student> Pagination(int pageindex, int pagesize) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select  Sid, Sname , Sgender , Sdob, Sgmail, Sstart  from Student "
                    + "ORDER BY Sid OFFSET (?-1)* ? ROWS \n"
                    + "FETCH NEXT ? ROWS ONLY;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                S.setSname(rs.getString("Sname"));
                S.setSgender(rs.getString("Sgender"));
                S.setSdob(rs.getDate("Sdob"));
                S.setSgmail(rs.getString("Sgmail"));
                S.setStart(rs.getString("Sstart"));

                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

}

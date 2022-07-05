/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.AssignmentStudent;
import Model.Classs;
import Model.Student;
import Model.Subjects;
import jakarta.servlet.jsp.jstl.sql.Result;
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

    public ArrayList<Student> SearchByidClass(String id) {
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

    public static void main(String[] args) {
        StudentDBcontext dao = new StudentDBcontext();
        ArrayList<Student> a = dao.searchid("anh");
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

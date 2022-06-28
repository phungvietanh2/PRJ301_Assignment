/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.AssignmentIDSTUDENT;
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
            String sql = " select * from Student ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setRollnumber(rs.getString("Srollnumber"));
              
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public ArrayList<Student> SearchByid(String id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "  select s.Srollnumber  from Student s  left JOIN  GroupClass g on g.Srollnumber = s.Srollnumber \n" +
"				    left JOIN Class cl on g.Clid = cl.Clid where cl.Clid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setRollnumber(rs.getString("Srollnumber")); 
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }


    public static void main(String[] args) {
        StudentDBcontext dao = new StudentDBcontext();
        ArrayList<Student> a = dao.list();
        //System.out.println(a);
        //  for (Student student : a) {
        System.out.println(a);
        //  }
    }

    @Override
    public Student get(int id) {
        return null;
    }

    @Override
    public void insert(Student model) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "INSERT INTO [Student]\n"
                    + "           ([Scode]\n"
                    + "           ,[Sname]\n"
                    + "           ,[Sgender]\n"
                    + "           ,[Sdob]\n"
                    + "           ,[Sgmail]\n"
                    + "           ,[Clname])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getMasv());
            stm.setString(2, model.getName());
            stm.setString(3, model.getGender());
            stm.setDate(4, model.getDob());
            stm.setString(5, model.getGmail());
            stm.setString(6, model.getClasss().getTenlop());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        try {
            String sql = "DELETE Student"
                    + " WHERE [Srollnumber] = ?";
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
            String sql = "select Srollnumber , Sname , Sgender , Sdob, Sgmail, Sstart, Sk  from Student "
                    + "ORDER BY Srollnumber OFFSET (?-1)* ? ROWS \n"
                    + "FETCH NEXT ? ROWS ONLY;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student S = new Student();
                S.setRollnumber(rs.getString("Srollnumber"));
                S.setSname(rs.getString("Sname"));
                S.setSgender(rs.getString("Sgender"));
                S.setSdob(rs.getDate("Sdob"));
                S.setSgmail(rs.getString("Sgmail"));
                S.setStart(rs.getDate("Sstart"));
                S.setSk(rs.getInt("Sk"));
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

}

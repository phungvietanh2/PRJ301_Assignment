/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

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
            String sql = "select s.Sid,s.Scode,s.Sgender,s.Sname,s.Sdob,s.Sgmail,c.Clname "
                    + "from Student s INNER JOIN Class c on s.Clname = c.Clname";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Classs cl = new Classs();
                cl.setTenlop(rs.getString("Clname"));
                Student S = new Student();
                S.setSid(rs.getInt("Sid"));
                S.setMasv(rs.getString("Scode"));
                S.setName(rs.getString("Sname"));
                S.setGender(rs.getString("Sgender"));
                S.setDob(rs.getDate("Sdob"));
                S.setGmail(rs.getString("Sgmail"));
                S.setClasss(cl);
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
            String sql = " select cl.Clname , c.Scode , c.Sname  from Class cl INNER JOIN  Student c"
                    + " on  cl.Clname = c.Clname where cl.Clname =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Classs cl = new Classs();
                cl.setTenlop(rs.getString("Clname"));
                Student s = new Student();
                s.setMasv(rs.getString("Scode"));
                s.setName(rs.getString("Sname"));
                s.setClasss(cl);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public static void main(String[] args) {
        StudentDBcontext dao = new StudentDBcontext();
       ArrayList<Student>  a = dao.getMarkclass();
        //System.out.println(a);
        for (Student student : a) {
        System.out.println(a);
         }
    }

    @Override
    public Student get(int id) {
        try {
            String sql = " select s.Sid, s.Scode,s.Sgender,s.Sname,s.Sdob,s.Sgmail,c.Clname \n"
                    + "                    from Student s INNER JOIN Class c on s.Clname = c.Clname where s.Sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Classs cl = new Classs();
                cl.setTenlop(rs.getString("Clname"));
                Student s = new Student();
                s.setSid(rs.getInt("Sid"));
                s.setMasv(rs.getString("Scode"));
                s.setName(rs.getString("Sname"));
                s.setClasss(cl);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Student>  getMarkclass() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = " select s.Sid ,s.Scode from Class m INNER JOIN Student s on m.Clname = s.Clname where m.Cocode = 'IOT102'  ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("Sid"));
                s.setMasv(rs.getString("Scode"));
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
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
            String sql = "select s.Sid, s.Scode,s.Sgender,s.Sname,s.Sdob,s.Sgmail,c.Clname\n"
                    + "from Student s INNER JOIN Class c on s.Clname = c.Clname\n"
                    + "ORDER BY Sid OFFSET (?-1)* ? ROWS \n"
                    + "FETCH NEXT ? ROWS ONLY;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Classs cl = new Classs();
                cl.setTenlop(rs.getString("Clname"));
                Student S = new Student();
                 S.setSid(rs.getInt("Sid"));
                S.setMasv(rs.getString("Scode"));
                S.setName(rs.getString("Sname"));
                S.setGender(rs.getString("Sgender"));
                S.setDob(rs.getDate("Sdob"));
                S.setGmail(rs.getString("Sgmail"));
                S.setClasss(cl);
                students.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
}

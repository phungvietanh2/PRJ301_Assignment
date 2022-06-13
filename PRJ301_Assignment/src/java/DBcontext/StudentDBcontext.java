/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Classs;
import Model.Student;
import Model.subjects;
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
public class StudentDBcontext extends DBcontext<Student>{

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> students=new ArrayList<>();
         try {
             String sql="select MaSV , TenSV , GioiTinh , NgaySinh, gmail ,MaLop from  Student";
             PreparedStatement stm = connection.prepareStatement(sql);
             ResultSet rs = stm.executeQuery();
             while (rs.next()) {
                 Student S = new Student(); 
                 S.setMasv(rs.getInt("MaSV"));
                 S.setName(rs.getString("TenSV"));
                 S.setGender(rs.getString("GioiTinh"));   
                 S.setBirthday(rs.getDate("NgaySinh"));
                 S.setGmail(rs.getString("gmail"));
                 Classs cl = new Classs();
                 cl.setMalop(rs.getInt("MaLop"));
                 students.add(S);
             }
         } catch (SQLException ex) {
             Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
         }
         return students;
    }
    public static void main(String[] args) {
       StudentDBcontext dao = new StudentDBcontext();
        List<Student> a  = dao.list();
        for (Student o : a) {
            System.out.println(o);
        }
    }
    @Override
    public Student get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

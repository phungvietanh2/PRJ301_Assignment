/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Student;
import Model.Classs;
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
public class SearchListClassDBconstext extends DBcontext<Student>{
 
     public ArrayList<Student> SearchByid(int id){
         ArrayList<Student> students = new ArrayList<>();
         try {
             String sql = " select s.MaSV , s.TenSV ,c.MaLop,c.TenLop   from Student s \n" +
" INNER JOIN Class c  on s.MaLop = c.MaLop where  c.MaLop = ?";
             PreparedStatement stm= connection.prepareStatement(sql);
             stm.setInt(1, id);
             ResultSet rs = stm.executeQuery();
             while (rs.next()) {
                 Classs d= new Classs();
                 d.setMalop(rs.getInt("MaLop"));
                 d.setTenlop(rs.getString("TenLop"));
                 Student e = new Student();
                 e.setMasv(rs.getString("MaSV"));
                 e.setName(rs.getString("TenSV"));
                 e.setClasss(d);
                 students.add(e);
   
             }
         } catch (SQLException ex) {
            Logger.getLogger(SearchListClassDBconstext.class.getName()).log(Level.SEVERE, null, ex);
        }
         return students;
     }            
            
                
        
    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

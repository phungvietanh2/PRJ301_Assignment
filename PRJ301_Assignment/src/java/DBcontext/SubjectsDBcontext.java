/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Classs;
import Model.Student;
import Model.subjects;
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
public class SubjectsDBcontext extends DBcontext<subjects>{

    @Override
    public ArrayList<subjects> list() {
    ArrayList<subjects> subjectss=new ArrayList<>();
         try {
             String sql="select MaMH,TenMH from subjects";
             PreparedStatement stm = connection.prepareStatement(sql);
             ResultSet rs = stm.executeQuery();
             while (rs.next()) {
                 subjects S = new subjects(); 
                 S.setId(rs.getString("MaMH"));
                 S.setNameMh(rs.getString("TenMH"));
                 subjectss.add(S);
             }
         } catch (SQLException ex) {
             Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
         }
         return subjectss;    
    }
  public static void main(String[] args) {
       SubjectsDBcontext dao = new SubjectsDBcontext();
        List<subjects> a  = dao.list();
        for (subjects o : a) {
            System.out.println(o);
        }
    }
    @Override
    public subjects get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(subjects model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(subjects model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(subjects model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

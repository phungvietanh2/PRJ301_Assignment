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
             String sql="select id, MaMH,TenMH from subjects";
             PreparedStatement stm = connection.prepareStatement(sql);
             ResultSet rs = stm.executeQuery();
             while (rs.next()) {
                 subjects S = new subjects(); 
                 S.setId(rs.getInt("id"));
                 S.setMamh(rs.getString("MaMH"));
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
      //  List<subjects> a  = dao.list();
      //  for (subjects o : a) {
      //      System.out.println(o);
      //  }
      subjects acc = dao.get(10);
      System.out.println(acc);
    }
    @Override
    public subjects get(int id) {
     try {
             String sql="select id, MaMH,TenMH from subjects where id=?";
             PreparedStatement stm = connection.prepareStatement(sql);
              stm.setInt(1, id);
             ResultSet rs = stm.executeQuery();
             while (rs.next()) {
                 subjects S = new subjects(); 
                 S.setId(rs.getInt("id"));
                 S.setMamh(rs.getString("MaMH"));
                 S.setNameMh(rs.getString("TenMH"));
                 return S;
             }
         } catch (SQLException ex) {
             Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;    
    
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.ListLoginStudent;
import jakarta.servlet.jsp.jstl.sql.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**

 * @author phung
 */
public class ListLoginStudentDBcontext extends DBcontext<ListLoginStudent>{

    @Override
    public ArrayList<ListLoginStudent> list() {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 
    }  

    @Override
    public ListLoginStudent get(int id) {
        try {
           String sql = "select a.id ,a.username , s.Semail , s.Sfullname from Student s\n" +
"INNER JOIN  Account a on s.Smasv = a.username where a.id= ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(id,1);
        ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                 ListLoginStudent li = new ListLoginStudent();
                 li.setUsername(rs.getString("username"));
                 li.setFullname(rs.getString("Sfullname"));
                li.setEmail(rs.getString("Semail"));
               return li;
            }
        } catch (SQLException ex) {
             Logger.getLogger(ListLoginStudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;   }

    @Override
    public void insert(ListLoginStudent model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ListLoginStudent model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ListLoginStudent model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

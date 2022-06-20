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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phung
 */
public class ClassDBcontext extends DBcontext<Classs>{
    
    @Override
    public ArrayList<Classs> list() {
     ArrayList<Classs> classes = new ArrayList<>();
        try {
            String sql = "select cl.Clname , c.Cocode ,c.Coname from Class cl INNER JOIN  Course c on  cl.Cocode = c.Cocode ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            Classs cl = new Classs();
            cl.setTenlop(rs.getString("Clname"));
            Subjects s = new Subjects();
            s.setConame(rs.getString("Cocode"));
            s.setConame(rs.getString("Coname"));
            cl.setSubjectss(s);
            classes.add(cl);
            }
        } catch (SQLException ex) {
             Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
         }
         return classes;
    }
    public static void main(String[] args) {
       ClassDBcontext dao = new ClassDBcontext();
        List<Classs> a  = dao.list();
        for (Classs o : a) {
            System.out.println(o);
        }
    }

    @Override
    public Classs get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Classs model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Classs model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Classs model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

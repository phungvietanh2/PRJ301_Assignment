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
public class ClassDBcontext extends DBcontext<Classs> {

    @Override
    public ArrayList<Classs> list() {
        ArrayList<Classs> classes = new ArrayList<>();
        try {
            String sql = "select Clid , Coid, Clstart,Clend from Class";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subjects s = new Subjects();
                s.setSuid(rs.getString("Coid"));
                Classs cl = new Classs();
                cl.setCid(rs.getString("Clid"));
                cl.setClstart(rs.getDate("Clstart"));
                cl.setClend(rs.getDate("Clend"));
                cl.setSubjectss(s);
                classes.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }

    public ArrayList<Classs> listclass() {
        ArrayList<Classs> classes = new ArrayList<>();
        try {
            String sql = "select c.Coname ,cl.Clstart,cl.Clend ,cl.Clid ,s.Srollnumber from Term t  left JOIN Course c on t.Tid = c.Tid\n"
                    + "					                      left JOIN   Class cl on c.Coid = cl.Coid\n"
                    + "										  left JOIN GroupClass g on cl.Clid = g.Clid\n"
                    + "										  left JOIN   Student s on s.Srollnumber = g.Srollnumber where s.Srollnumber = 'HE153712'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subjects s = new Subjects();
                s.setSuname(rs.getString("Coname"));
                Classs cl = new Classs();
                cl.setCid(rs.getString("Clid"));
                cl.setClstart(rs.getDate("Clstart"));
                cl.setClend(rs.getDate("Clend"));
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
        List<Classs> a = dao.listclass();
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Student;
import Model.Term;
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
public class TermDBcontext extends DBcontext<Term> {

    @Override
    public ArrayList<Term> list() {
        ArrayList<Term> Terms = new ArrayList<>();
        try {
            String sql = "Select Tid , Tname from Term";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Term t = new Term();
                t.setTid(rs.getInt("Tid"));
                t.setTname(rs.getString("Tname"));
                Terms.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TermDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Terms;
    }

    public ArrayList<Term> getid(String userid) {
        try {
            ArrayList<Term> Terms = new ArrayList<>();
            String sql = " select t.Tid, t.Tname from Term t  \n"
                    + "  left JOIN Course c on t.Tid = c.Tid\n"
                    + "  left JOIN   [Group] cl on c.Coid = cl.Coid\n"
                    + "   left JOIN GroupStudent g on cl.Gid = g.Gid\n"
                    + "   left JOIN   Student s on s.Sid = g.Sid \n"
                    + "   left join Account a on a.Sid = s.Sid \n"
                    + "   where a.username =? group by t.Tname  , T.Tid";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userid);
         
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Term t = new Term();
                t.setTid(rs.getInt("Tid"));
                t.setTname(rs.getString("Tname"));
                Terms.add(t);
            }
            return Terms;
        } catch (SQLException ex) {
            Logger.getLogger(TermDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Term get(int id) {
        try {
            String sql = "select t.Tid from Term t  \n"
                    + "  left JOIN Course c on t.Tid = c.Tid\n"
                    + "  left JOIN   [Group] cl on c.Coid = cl.Coid\n"
                    + "   left JOIN GroupStudent g on cl.Gid = g.Gid\n"
                    + "   left JOIN   Student s on s.Sid = g.Sid \n"
                    + "   left join Account a on a.Sid = s.Sid \n"
                    + "   where t.Tid =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Term t = new Term();
                t.setTid(rs.getInt("Tid"));
                return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TermDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        TermDBcontext dao = new TermDBcontext();
      //  ArrayList<Term> a = dao.getid("anh", "1");
  //      System.out.println(a);
//        //for (Student student : a) {
//        System.out.println(a);
//        //}
    }

    @Override
    public void insert(Term model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Term model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Term model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

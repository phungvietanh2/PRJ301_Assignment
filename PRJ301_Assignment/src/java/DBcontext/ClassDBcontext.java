package DBcontext;

import Model.Classs;
import Model.Subjects;
import Model.Teacher;
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
public class ClassDBcontext extends DBcontext<Classs> {

    @Override
    public ArrayList<Classs> list() {
        ArrayList<Classs> classes = new ArrayList<>();
        try {
            String sql = "select Gid, Coid , Teid , Gstart , Gend from [Group]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Teacher t = new Teacher();
                t.setTeid(rs.getInt("Teid"));
                Subjects s = new Subjects();
                s.setSuid(rs.getString("Coid"));
                Classs cl = new Classs();
                cl.setCid(rs.getString("Gid"));
                cl.setClstart(rs.getDate("Gstart"));
                cl.setClend(rs.getDate("Gend"));
                cl.setSubjectss(s);
                cl.setTeachers(t);
                classes.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }

    public ArrayList<Classs> getid_user(String id, String userid) {
        try {
            ArrayList<Classs> classes = new ArrayList<>();
            String sql = "  select c.Coid, c.Coname, g.Gid,cl.Gstart,cl.Gend from Term t  \n"
                    + "  left JOIN Course c on t.Tid = c.Tid\n"
                    + "  left JOIN   [Group] cl on c.Coid = cl.Coid\n"
                    + "   left JOIN GroupStudent g on cl.Gid = g.Gid\n"
                    + "   left JOIN   Student s on s.Sid = g.Sid \n"
                    + "   left join Account a on a.Sid = s.Sid \n"
                    + "   where t.Tid =? and a.username=? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, userid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subjects s = new Subjects();
                s.setSuid(rs.getString("Coid"));
                s.setSuname(rs.getString("Coname"));
                Classs c = new Classs();
                c.setCid(rs.getString("Gid"));
                c.setClstart(rs.getDate("Gstart"));
                c.setClend(rs.getDate("Gend"));
                c.setSubjectss(s);
                classes.add(c);
            }
            return classes;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Classs> getid_course(String id , String idterm) {
        try {
            ArrayList<Classs> classes = new ArrayList<>();
            String sql = "  select t.Tname, c.coid, g.Gid from Course c\n"
                    + "	left join Term t on c.Tid=t.Tid\n"
                    + "	left join [Group] g on c.Coid = g.Coid"
                    + " where c.Coid = ? and t.Tname=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, idterm);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Term t = new Term();
                t.setTname(rs.getString("Tname"));
                Subjects s = new Subjects();
                s.setSuid(rs.getString("coid"));
                Classs c = new Classs();
                c.setCid(rs.getString("Gid"));
                c.setSubjectss(s);
                c.setTerms(t);
                classes.add(c);
            }
            return classes;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
       ClassDBcontext dao = new ClassDBcontext();
       ArrayList<Classs> a = dao.getid_course("IOT102","Summer2022");
//        //    for (Classs o : a) {
       System.out.println(a);
//        //  }
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

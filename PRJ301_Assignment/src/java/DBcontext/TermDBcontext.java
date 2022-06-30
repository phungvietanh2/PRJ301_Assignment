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
            String sql = " select DISTINCT t.Tname  from Term t  left JOIN Course c on t.Tid = c.Tid\n"
                    + "					                      left JOIN   Class cl on c.Coid = cl.Coid\n"
                    + "										  left JOIN GroupClass g on cl.Clid = g.Clid\n"
                    + "										  left JOIN   Student s on s.Srollnumber = g.Srollnumber ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Term t = new Term();
                t.setTname(rs.getString("Tname"));
                Terms.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TermDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Terms;
    }

    @Override
    public Term get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

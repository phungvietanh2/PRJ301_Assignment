/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Assignment;
import Model.Subjects;
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
public class AssignmentDBcontext extends DBcontext<Assignment> {

    public ArrayList<Assignment> SearchByclass(String id) {
        ArrayList<Assignment> Assignments = new ArrayList<>();
        try {
            String sql = "select a.Aname , a.Aid from Assessment a left join Course c on  a.Coid = c.Coid\n"
                    + "	 left join [Group] g on g.Coid= c.Coid\n"
                    + "		where g.Gid= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assignment S = new Assignment();
                S.setAid(rs.getInt("Aid"));
                S.setAname(rs.getString("Aname"));
                Assignments.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Assignments;
    }

    public ArrayList<Assignment> SearchBycours(String id) {
        ArrayList<Assignment> Assignments = new ArrayList<>();
        try {
            String sql = " select a.Aname , a.Aid from Assessment a left join Course c on  a.Coid = c.Coid\n"
                    + "	 left join [Group] g on g.Coid= c.Coid\n"
                    + "	where g.Coid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assignment S = new Assignment();
                S.setAid(rs.getInt("Aid"));
                S.setAname(rs.getString("Aname"));
                Assignments.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Assignments;
    }

    @Override
    public ArrayList<Assignment> list() {
        ArrayList<Assignment> Assignments = new ArrayList<>();
        try {
            String sql = "select * from Assessment";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assignment S = new Assignment();
                S.setAname(rs.getString("Aname"));
                S.setAid(rs.getInt("Aid"));
                Assignments.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Assignments;

    }

    public static void main(String[] args) {
        AssignmentDBcontext dao = new AssignmentDBcontext();
        ArrayList<Assignment> a = dao.SearchBycours("IOT102");

        //System.out.println(a);
        //  for (Assignment student : a) {
        System.out.println(a);
    }

    @Override
    public Assignment get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Assignment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Assignment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Assignment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

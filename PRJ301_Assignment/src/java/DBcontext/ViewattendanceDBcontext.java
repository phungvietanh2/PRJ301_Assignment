/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Account;
import Model.Course;
import Model.Viewattendance;
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
public class ViewattendanceDBcontext extends DBcontext<Viewattendance> {

    public ArrayList<Viewattendance> searchByDid(int did) {
        ArrayList<Viewattendance> viewattendances = new ArrayList<>();
        try {
            String sql = "with r as (select sc.id , att.attendence ,att.note ,sc.startDate,sc.endDate ,sc.teacherId\n"
                    + "from Schedule sc INNER JOIN  Attendences att  \n"
                    + "on sc.id= att.id )\n"
                    + "select m.id, cl.Clslot , cl.Clroom ,cl.Clname,m.attendence,m.note from Class cl INNER JOIN r m on cl.Clid= m.id\n"
                    + "where m.id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, did);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Viewattendance a = new Viewattendance();
                a.setId(rs.getInt("id"));
                a.setSlot(rs.getInt("Clslot"));
                a.setName(rs.getString("Clname"));
                a.setAttendencee(rs.getString("attendence"));
                a.setNotee(rs.getString("note"));
                a.setRoom(rs.getString("Clroom"));
                viewattendances.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewattendanceDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return viewattendances;
    }

    @Override
    public ArrayList<Viewattendance> list() {
        ArrayList<Viewattendance> Viewattendances = new ArrayList<>();
        try {
            String sql = "with r as (select sc.id , att.attendence ,att.note ,sc.startDate,sc.endDate ,sc.teacherId\n"
                    + "from Schedule sc INNER JOIN  Attendences att  \n"
                    + "on sc.id= att.id )\n"
                    + "select cl.Clslot , cl.Clroom ,cl.Clname,m.attendence,m.note from Class cl INNER JOIN r m on cl.Clid= m.id\n";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Viewattendance a = new Viewattendance();
                a.setSlot(rs.getInt("Clslot"));
                a.setName(rs.getString("Clname"));
                a.setAttendencee(rs.getString("attendence"));
                a.setNotee(rs.getString("note"));
                a.setRoom(rs.getString("Clroom"));
                Viewattendances.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewattendanceDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Viewattendances;
    }

    @Override
    public Viewattendance get(int id) {
       try {
            String sql = "with r as (select sc.id , att.attendence ,att.note ,sc.startDate,sc.endDate ,sc.teacherId\n"
                    + "from Schedule sc INNER JOIN  Attendences att  \n"
                    + "on sc.id= att.id )\n"
                    + "select m.id, cl.Clslot , cl.Clroom ,cl.Clname,m.attendence,m.note from Class cl INNER JOIN r m on cl.Clid= m.id\n"
                    + "where m.id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Viewattendance a = new Viewattendance();
                a.setId(rs.getInt("id"));
                a.setSlot(rs.getInt("Clslot"));
                a.setName(rs.getString("Clname"));
                a.setAttendencee(rs.getString("attendence"));
                a.setNotee(rs.getString("note"));
                a.setRoom(rs.getString("Clroom"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewattendanceDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }

    @Override
    public void insert(Viewattendance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Viewattendance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Viewattendance model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Classs;
import Model.Mark;
import Model.Student;
import Model.subjects;
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
public class AdminListMarkDBcontext extends DBcontext<Mark> {

    public ArrayList<Mark> SearchByid(String id) {
        ArrayList<Mark> marks = new ArrayList<>();
        try {
            String sql = "select m.MaMH , m.DiemLan1 , m.DiemLan21 , m.DiemLan22 , m.DiemLan3\n"
                    + ",m.DiemLan4,m.DiemLan5,m.DiemLan6 ,m.MaSV\n"
                    + "from Mark m INNER JOIN subjects s on m.MaMH = s.MaMH  where m.MaMH = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                subjects d = new subjects();
                d.setId(rs.getString("MaMH"));
                Mark e = new Mark();
                e.setMasv(rs.getInt("MaSV"));
                e.setMark1(rs.getInt("DiemLan1"));
                e.setMark21(rs.getInt("DiemLan21"));
                e.setMark22(rs.getInt("DiemLan22"));
                e.setMark3(rs.getInt("DiemLan3"));
                e.setMark4(rs.getInt("DiemLan4"));
                e.setMark5(rs.getInt("DiemLan5"));
                e.setMark6(rs.getInt("DiemLan6"));  
                e.setSubjectss(d);
                marks.add(e);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchListClassDBconstext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marks;
    }

    @Override
    public ArrayList<Mark> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Mark get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Mark model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Mark model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Mark model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

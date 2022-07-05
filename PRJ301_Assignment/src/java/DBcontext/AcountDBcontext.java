/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import Model.Account;
import Model.Feature;
import Model.Role;
import Model.Student;
import com.sun.xml.internal.fastinfoset.sax.Features;
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
public class AcountDBcontext extends DBcontext<Account> {
    
    public Account getAccountbyuserpass(String user, String Pass) {
        try {
            String sql = "select a.username,a.Arole , a.sid , a.password , a.displayname , ISNULL (r.Rid,-1) as Rid,r.Rname, ISNULL(f.Fid,-1) as Fid , f.Fname ,f.Furl\n"
                    + "from Account a left join [Role Acount ] ra on a.username = ra.username\n"
                    + "                       left join Role r on ra.Rid = r.Rid\n"
                    + "					   left join [Role Feature ] rf on rf.Rid = r.Rid \n"
                    + "	                    left join Feature f on f.Fid = rf.Fid where a.username = ? and a.password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, Pass);
            ResultSet rs = stm.executeQuery();
            Account account = null;
            Role roles = new Role();
            roles.setRid(-1);
            Feature features = new Feature();
            features.setFid(-1);
            while (rs.next()) {
                if (account == null  ) {
                    account = new Account();
                    account.setRoless(rs.getInt("Arole"));
                    account.setUser(rs.getString("username"));
                    account.setPass(rs.getString("password"));
                    account.setDisplayname(rs.getString("displayname")); 
                    account.setStudents(rs.getInt("sid")); 
                }
                int rid = rs.getInt("Rid");
                if (rid != -1) {
                    if (roles.getRid() != rid) {
                        roles = new Role();
                        roles.setRid(rid);
                        roles.setRname(rs.getString("Rname"));
                        account.getRoles().add(roles);
                    }
                }
                
                int fid = rs.getInt("Fid");
                if (fid != -1) {
                    if (features.getFid()!= fid) {
                        features = new Feature();
                        features.setFid(fid);
                        features.setFname(rs.getString("Fname"));
                        features.setFurl(rs.getString("Furl"));
                        roles.getFeatures().add(features);
                    }
                }
            }
             return account;
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ArrayList<Account> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
    
    public static void main(String[] args) {
        AcountDBcontext dao = new AcountDBcontext();
         Account a = dao.getAccountbyuserpass("admin", "admin");
      //  for (Account o : a) {
           System.out.println(0);
       //}
    }
    
    @Override
    public Account get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void insert(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void update(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void delete(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

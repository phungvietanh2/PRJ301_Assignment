/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author phung
 */
public class Account {
    private String user;
    private String pass;
    private String displayname;
    ArrayList<Role> Roles = new ArrayList<>();

    public ArrayList<Role> getRoles() {
        return Roles;
    }

    public void setRoles(ArrayList<Role> Roles) {
        this.Roles = Roles;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    @Override
    public String toString() {
        return "Account{" + "user=" + user + ", pass=" + pass + ", displayname=" + displayname + ", Roles=" + Roles + '}';
    }

   
    
}

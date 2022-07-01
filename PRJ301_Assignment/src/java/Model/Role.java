/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import AccountController.AcountController;
import java.util.ArrayList;

/**
 *
 * @author phung
 */
public class Role {
    private int rid;
    private String rname ;
    ArrayList<Account> Accounts = new ArrayList<>();
    ArrayList<Feature> Features = new ArrayList<>();

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public ArrayList<Account> getAccounts() {
        return Accounts;
    }

    public void setAccounts(ArrayList<Account> Accounts) {
        this.Accounts = Accounts;
    }

    public ArrayList<Feature> getFeatures() {
        return Features;
    }

    public void setFeatures(ArrayList<Feature> Features) {
        this.Features = Features;
    }

    @Override
    public String toString() {
        return "Role{" + "rid=" + rid + ", rname=" + rname + ", Accounts=" + Accounts + ", Features=" + Features + '}';
    }


}

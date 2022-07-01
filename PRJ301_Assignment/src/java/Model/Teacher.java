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
public class Teacher {
    private  int Teid ;
    private String Tename;
    ArrayList<Subjects> Subjectss = new ArrayList<>();
    ArrayList<Classs> Classss = new ArrayList<>();
    ArrayList<Account> Accounts = new ArrayList<>();

    public int getTeid() {
        return Teid;
    }

    public void setTeid(int Teid) {
        this.Teid = Teid;
    }

    public String getTename() {
        return Tename;
    }

    public void setTename(String Tename) {
        this.Tename = Tename;
    }

    public ArrayList<Subjects> getSubjectss() {
        return Subjectss;
    }

    public void setSubjectss(ArrayList<Subjects> Subjectss) {
        this.Subjectss = Subjectss;
    }

    public ArrayList<Classs> getClassss() {
        return Classss;
    }

    public void setClassss(ArrayList<Classs> Classss) {
        this.Classss = Classss;
    }

    public ArrayList<Account> getAccounts() {
        return Accounts;
    }

    public void setAccounts(ArrayList<Account> Accounts) {
        this.Accounts = Accounts;
    }

    @Override
    public String toString() {
        return "Teacher{" + "Teid=" + Teid + ", Tename=" + Tename + ", Subjectss=" + Subjectss + ", Classss=" + Classss + ", Accounts=" + Accounts + '}';
    }
    
}

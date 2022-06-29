/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author phung
 */
public class Student {

    private String rollnumber;
    private String sname;
    private String sgender;
    private Date sdob;
    private String sgmail;
    private String start;
    private int sk;
    private Classs Clas;
    private ArrayList<demo> demos = new ArrayList<>();

    public ArrayList<demo> getDemos() {
        return demos;
    }

    public void setDemos(ArrayList<demo> demos) {
        this.demos = demos;
    }
    private ArrayList<AssignmentIDSTUDENT> AssignmentIDSTUDENTs = new ArrayList<>();

    public ArrayList<AssignmentIDSTUDENT> getAssignmentIDSTUDENTs() {
        return AssignmentIDSTUDENTs;
    }

    public void setAssignmentIDSTUDENTs(ArrayList<AssignmentIDSTUDENT> AssignmentIDSTUDENTs) {
        this.AssignmentIDSTUDENTs = AssignmentIDSTUDENTs;
    }
  
    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public Date getSdob() {
        return sdob;
    }

    public void setSdob(Date sdob) {
        this.sdob = sdob;
    }

    public String getSgmail() {
        return sgmail;
    }

    public void setSgmail(String sgmail) {
        this.sgmail = sgmail;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

   

    public int getSk() {
        return sk;
    }

    public void setSk(int sk) {
        this.sk = sk;
    }

    public Classs getClas() {
        return Clas;
    }

    public void setClas(Classs Clas) {
        this.Clas = Clas;
    }

    @Override
    public String toString() {
        return "Student{" + "rollnumber=" + rollnumber + ", sname=" + sname + ", sgender=" + sgender + ", sdob=" + sdob + ", sgmail=" + sgmail + ", start=" + start + ", sk=" + sk + ", Clas=" + Clas + ", demos=" + demos + ", AssignmentIDSTUDENTs=" + AssignmentIDSTUDENTs + '}';
    }
    
}

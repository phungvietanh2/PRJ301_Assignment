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
    private Date start;
    private int sk;
    private Classs Clas;
    ArrayList<IOT102> IOT102S = new ArrayList<>();
    ArrayList<PRJ301> PRJ301S = new ArrayList<>();

    public ArrayList<PRJ301> getPRJ301S() {
        return PRJ301S;
    }

    public void setPRJ301S(ArrayList<PRJ301> PRJ301S) {
        this.PRJ301S = PRJ301S;
    }

    public Classs getClas() {
        return Clas;
    }

    public void setClas(Classs Clas) {
        this.Clas = Clas;
    }

    
    

    public ArrayList<IOT102> getIOT102S() {
        return IOT102S;
    }

    public void setIOT102S(ArrayList<IOT102> IOT102S) {
        this.IOT102S = IOT102S;
    }
    

    

    public ArrayList<IOT102> getAssessmentIDStudents() {
        return IOT102S;
    }

    public void setAssessmentIDStudents(ArrayList<IOT102> AssessmentIDStudents) {
        this.IOT102S = AssessmentIDStudents;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public int getSk() {
        return sk;
    }

    public void setSk(int sk) {
        this.sk = sk;
    }

}

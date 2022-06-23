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
public class Subjects {

    private String suid;
    private String suname;
    private int credit;
    private int term;
    ArrayList<IOT102> IOT102S = new ArrayList<>();
    ArrayList<Classs> Classss = new ArrayList<>();
    ArrayList<PRJ301> PRJ301S = new ArrayList<>();

    public ArrayList<IOT102> getIOT102S() {
        return IOT102S;
    }

    public void setIOT102S(ArrayList<IOT102> IOT102S) {
        this.IOT102S = IOT102S;
    }

    public ArrayList<PRJ301> getPRJ301S() {
        return PRJ301S;
    }

    public void setPRJ301S(ArrayList<PRJ301> PRJ301S) {
        this.PRJ301S = PRJ301S;
    }

    public ArrayList<Classs> getClassss() {
        return Classss;
    }

    public void setClassss(ArrayList<Classs> Classss) {
        this.Classss = Classss;
    }

    public ArrayList<IOT102> getAssessments() {
        return IOT102S;
    }

    public void setAssessments(ArrayList<IOT102> Assessments) {
        this.IOT102S = Assessments;
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public String getSuname() {
        return suname;
    }

    public void setSuname(String suname) {
        this.suname = suname;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

}

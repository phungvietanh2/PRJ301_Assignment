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
    private Term terms;
     ArrayList<Student> Students = new ArrayList<>();
    ArrayList<Assignment> Assignments = new ArrayList<>();
    ArrayList<Classs> Classsss = new ArrayList<>();

    public ArrayList<Assignment> getAssignments() {
        return Assignments;
    }

    public void setAssignments(ArrayList<Assignment> Assignments) {
        this.Assignments = Assignments;
    }

    public ArrayList<Student> getStudents() {
        return Students;
    }

    public void setStudents(ArrayList<Student> Students) {
        this.Students = Students;
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

    public Term getTerms() {
        return terms;
    }

    public void setTerms(Term terms) {
        this.terms = terms;
    }

    public ArrayList<Classs> getClasssss() {
        return Classsss;
    }

    public void setClasssss(ArrayList<Classs> Classsss) {
        this.Classsss = Classsss;
    }

    @Override
    public String toString() {
        return "Subjects{" + "suid=" + suid + ", suname=" + suname + ", credit=" + credit + ", terms=" + terms + ", Assignments=" + Assignments + '}';
    }

}

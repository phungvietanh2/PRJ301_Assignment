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
    private String no;
    private String suname;
    private int credit;
    private Term terms;
    private int Status;

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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Subjects{" + "suid=" + suid + ", suname=" + suname + ", credit=" + credit + ", terms=" + terms + ", Status=" + Status + ", Students=" + Students + ", Assignments=" + Assignments + ", Classsss=" + Classsss + '}';
    }

}

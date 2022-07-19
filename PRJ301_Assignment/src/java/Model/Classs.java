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
public class Classs {

    private int cid;
    private String cname;
    private Date clstart;
    private Date clend;
    private Subjects subjectss;
    private Term Terms;
    private ArrayList<Student> students = new ArrayList<>();

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Date getClstart() {
        return clstart;
    }

    public void setClstart(Date clstart) {
        this.clstart = clstart;
    }

    public Date getClend() {
        return clend;
    }

    public void setClend(Date clend) {
        this.clend = clend;
    }

    public Subjects getSubjectss() {
        return subjectss;
    }

    public void setSubjectss(Subjects subjectss) {
        this.subjectss = subjectss;
    }

    public Term getTerms() {
        return Terms;
    }

    public void setTerms(Term Terms) {
        this.Terms = Terms;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Classs{" + "cid=" + cid + ", cname=" + cname + ", clstart=" + clstart + ", clend=" + clend + ", subjectss=" + subjectss + ", Terms=" + Terms + ", students=" + students + '}';
    }

 

}

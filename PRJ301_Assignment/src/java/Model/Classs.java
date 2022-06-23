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

    private String cid;
    private Date clstart;
    private Date clend;
    private Subjects subjectss;
    ArrayList<Student> Students = new ArrayList<>();

    public ArrayList<Student> getGroupClasss() {
        return Students;
    }

    public void setGroupClasss(ArrayList<Student> GroupClasss) {
        this.Students = GroupClasss;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

}

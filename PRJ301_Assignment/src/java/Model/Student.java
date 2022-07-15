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

    private int sid;
    private int no;
    private String simg;
    private String sname;
    private String sgender;
    private Date sdob;
    private String sgmail;
    private String start;
    private int status;
    private Classs classss;
    private Subjects Subjectss;

    public String getSimg() {
        return simg;
    }

    public void setSimg(String simg) {
        this.simg = simg;
    }

    public Classs getClassss() {
        return classss;
    }

    public void setClassss(Classs classss) {
        this.classss = classss;
    }
    private ArrayList<Assignment> Assignments = new ArrayList<>();

    public ArrayList<Assignment> getAssignments() {
        return Assignments;
    }

    public void setAssignments(ArrayList<Assignment> Assignments) {
        this.Assignments = Assignments;
    }

    public Subjects getSubjectss() {
        return Subjectss;
    }

    public void setSubjectss(Subjects Subjectss) {
        this.Subjectss = Subjectss;
    }

    private ArrayList<AssignmentStudent> AssignmentIDSTUDENTs = new ArrayList<>();

    public ArrayList<AssignmentStudent> getAssignmentIDSTUDENTs() {
        return AssignmentIDSTUDENTs;
    }

    public void setAssignmentIDSTUDENTs(ArrayList<AssignmentStudent> AssignmentIDSTUDENTs) {
        this.AssignmentIDSTUDENTs = AssignmentIDSTUDENTs;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    @Override
    public String toString() {
        return "Student{" + "sid=" + sid + ", classss=" + classss + '}';
    }

}

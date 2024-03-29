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
public class Assignment {
    private int aid ;
    private String aname;
    private float aweight;
    private Subjects Subjectss ;
   // private Student Students ;
    private ArrayList<Student>students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    
    private ArrayList<AssignmentStudent> assignmentIDSTUDENTs=new ArrayList<>();
    public ArrayList<AssignmentStudent> getAssignmentIDSTUDENTs() {
        return assignmentIDSTUDENTs;
    }
    public void setAssignmentIDSTUDENTs(ArrayList<AssignmentStudent> assignmentIDSTUDENTs) {
        this.assignmentIDSTUDENTs = assignmentIDSTUDENTs;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Subjects getSubjectss() {
        return Subjectss;
    }

    public void setSubjectss(Subjects Subjectss) {
        this.Subjectss = Subjectss;
    }
    public float getAweight() {
        return aweight;
    }

    public void setAweight(float aweight) {
        this.aweight = aweight;
    }

    @Override
    public String toString() {
        return "Assignment{" + "aid=" + aid + ", aname=" + aname + ", aweight=" + aweight + ", Subjectss=" + Subjectss + ", assignmentIDSTUDENTs=" + assignmentIDSTUDENTs + '}';
    }
    
}

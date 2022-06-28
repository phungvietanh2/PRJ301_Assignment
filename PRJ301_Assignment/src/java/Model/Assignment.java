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
    private ArrayList<demo> demos=new ArrayList<>();

    public ArrayList<demo> getDemos() {
        return demos;
    }

    public void setDemos(ArrayList<demo> demos) {
        this.demos = demos;
    }

   private ArrayList<AssignmentIDSTUDENT> assignmentIDSTUDENTs=new ArrayList<>();

    

    public ArrayList<AssignmentIDSTUDENT> getAssignmentIDSTUDENTs() {
        return assignmentIDSTUDENTs;
    }

    public void setAssignmentIDSTUDENTs(ArrayList<AssignmentIDSTUDENT> assignmentIDSTUDENTs) {
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
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author phung
 */
public class AssignmentStudent {
    private int asid;
    private float asmarkk;
    private float asmarkk1;
    private float asmarkk2;
    private Date asdate;
    private Student Students ;
    private Assignment Assignments ;

    public int getAsid() {
        return asid;
    }
  public float getAsmarkk() {
        return asmarkk;
    }

    public void setAsmarkk(float asmarkk) {
        this.asmarkk = asmarkk;
    }
    public void setAsid(int asid) {
        this.asid = asid;
    }

    public float getAsmarkk1() {
        return asmarkk1;
    }

    public void setAsmarkk1(float asmarkk1) {
        this.asmarkk1 = asmarkk1;
    }

    public float getAsmarkk2() {
        return asmarkk2;
    }

    public void setAsmarkk2(float asmarkk2) {
        this.asmarkk2 = asmarkk2;
    }

  

    public Date getAsdate() {
        return asdate;
    }

    public void setAsdate(Date asdate) {
        this.asdate = asdate;
    }

    public Student getStudents() {
        return Students;
    }

    public void setStudents(Student Students) {
        this.Students = Students;
    }

    public Assignment getAssignments() {
        return Assignments;
    }

    public void setAssignments(Assignment Assignments) {
        this.Assignments = Assignments;
    }

    @Override
    public String toString() {
        return "AssignmentIDSTUDENT{" + "asid=" + asid + ", asmarkk=" + asmarkk + ", asmarkk1=" + asmarkk1 + ", asdate=" + asdate + ", Students=" + Students + ", Assignments=" + Assignments + '}';
    }

  
    
}

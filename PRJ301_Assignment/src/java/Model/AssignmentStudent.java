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
    private float  average;
    private float Total;
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

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    
    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
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
        return "AssignmentStudent{" + "asid=" + asid + ", asmarkk=" + asmarkk + ", average=" + average + ", Total=" + Total + ", asdate=" + asdate + ", Students=" + Students + ", Assignments=" + Assignments + '}';
    }

   
    
}

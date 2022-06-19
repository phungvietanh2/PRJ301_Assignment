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
public class Classs {
  private String tenlop; 
  private subjects subjectss;
   ArrayList<Student> students = new ArrayList<>();

    public subjects getSubjectss() {
        return subjectss;
    }

    public void setSubjectss(subjects subjectss) {
        this.subjectss = subjectss;
    }


    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}

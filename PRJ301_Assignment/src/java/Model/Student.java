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
    private int Sid;
    private String Masv;
    private String name;
    private String gender;
    private Date dob;
    private String gmail;
    private Classs classs;
    ArrayList<MarkIot102> markIot102s = new ArrayList<>();
    ArrayList<Markjpd123> markjpd123s = new ArrayList<>();

    public ArrayList<Markjpd123> getMarkjpd123s() {
        return markjpd123s;
    }

    public void setMarkjpd123s(ArrayList<Markjpd123> markjpd123s) {
        this.markjpd123s = markjpd123s;
    }
    
    public ArrayList<MarkIot102> getMarkIot102s() {
        return markIot102s;
    }

    public void setMarkIot102s(ArrayList<MarkIot102> markIot102s) {
        this.markIot102s = markIot102s;
    }

    public int getSid() {
        return Sid;
    }

    public void setSid(int Sid) {
        this.Sid = Sid;
    }

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String Masv) {
        this.Masv = Masv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
    }

 

    
}

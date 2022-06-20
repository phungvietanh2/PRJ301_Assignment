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
    private String id;
    private String coname;
    private int credit;
    private int term;
    ArrayList<Classs>classses=new ArrayList<>();
    ArrayList<MarkIot102> markIot102s = new ArrayList<>();

    public ArrayList<MarkIot102> getMarkIot102s() {
        return markIot102s;
    }

    public void setMarkIot102s(ArrayList<MarkIot102> markIot102s) {
        this.markIot102s = markIot102s;
    }

    public ArrayList<Classs> getClassses() {
        return classses;
    }

    public void setClassses(ArrayList<Classs> classses) {
        this.classses = classses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    



   
    
    
}

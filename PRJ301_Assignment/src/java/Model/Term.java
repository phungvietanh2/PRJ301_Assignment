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
public class Term {

    private int tid;
    private String tname;
    private ArrayList<Classs> Classss = new ArrayList<>();

    public ArrayList<Classs> getClassss() {
        return Classss;
    }

    public void setClassss(ArrayList<Classs> Classss) {
        this.Classss = Classss;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Term{" + "tid=" + tid + ", tname=" + tname + '}';
    }

}

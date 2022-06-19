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
public class subjects {
    private int id;
    private String Mamh;
    private String Namemh;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMamh() {
        return Mamh;
    }

    public void setMamh(String Mamh) {
        this.Mamh = Mamh;
    }

    public String getNamemh() {
        return Namemh;
    }

    public void setNamemh(String Namemh) {
        this.Namemh = Namemh;
    }




   
    
    
}

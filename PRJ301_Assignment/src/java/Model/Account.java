/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author phung
 */
public class Account {
    private int Acid;
    private String Acuser;
    private String Acpass;
    private int AcisSell;
    private int AcisAdmin;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAcid() {
        return Acid;
    }

    public void setAcid(int Acid) {
        this.Acid = Acid;
    }

    public String getAcuser() {
        return Acuser;
    }

    public void setAcuser(String Acuser) {
        this.Acuser = Acuser;
    }

    public String getAcpass() {
        return Acpass;
    }

    public void setAcpass(String Acpass) {
        this.Acpass = Acpass;
    }

    public int getAcisSell() {
        return AcisSell;
    }

    public void setAcisSell(int AcisSell) {
        this.AcisSell = AcisSell;
    }

    public int getAcisAdmin() {
        return AcisAdmin;
    }

    public void setAcisAdmin(int AcisAdmin) {
        this.AcisAdmin = AcisAdmin;
    }
    
}

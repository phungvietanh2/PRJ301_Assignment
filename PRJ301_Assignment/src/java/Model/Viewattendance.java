/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author phung
 */
public class Viewattendance {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String name;
    private int slot;
    private String room;
    private String attendencee;
    private String notee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getAttendencee() {
        return attendencee;
    }

    public void setAttendencee(String attendencee) {
        this.attendencee = attendencee;
    }

    public String getNotee() {
        return notee;
    }

    public void setNotee(String notee) {
        this.notee = notee;
    }

}

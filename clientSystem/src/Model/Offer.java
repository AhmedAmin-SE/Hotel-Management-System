/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Offer {

    public String description;
    public String start_date;
    public String end_date;
    String ID;

    public Offer(String id, String description, String start_date, String end_date) {
        ID = id;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

}

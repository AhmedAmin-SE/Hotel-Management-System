/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public  class Accomodation {

    private String State;
    private String ID;
    private String location;
    private String description;
    private String first_available_date;
    private String offer_description;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Accomodation(String ID, String location, String description, String first_available_date, String offer_description) {
        this.ID = ID;
        this.location = location;
        this.description = description;
        this.first_available_date = first_available_date;
        this.offer_description = offer_description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirst_available_date() {
        return first_available_date;
    }

    public void setFirst_available_date(String first_available_date) {
        this.first_available_date = first_available_date;
    }

    public String getOffer_description() {
        return offer_description;
    }

    public void setOffer_description(String offer_description) {
        this.offer_description = offer_description;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getState() {
        return State;
    }
}

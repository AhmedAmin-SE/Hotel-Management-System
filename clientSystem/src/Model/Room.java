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
public class Room extends Accomodation {

    private String roomType;

    public Room(String ID, String location, String description, String first_available_date, String offer_description, String roomType) {
        super(ID, location, description, first_available_date, offer_description);
        this.roomType = roomType;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    

}

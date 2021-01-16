/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DELL
 */
public class Rated_Accomodation {

    private String CustomerUsername;
    private String RoomID;
    private int Rating;

    public Rated_Accomodation(String CustomerUsername, String RoomID, int Rating) {
        this.CustomerUsername = CustomerUsername;
        this.RoomID = RoomID;
        this.Rating = Rating;
    }

    public String getCustomerUsername() {
        return CustomerUsername;
    }

    public void setCustomerUsername(String CustomerUsername) {
        this.CustomerUsername = CustomerUsername;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

}

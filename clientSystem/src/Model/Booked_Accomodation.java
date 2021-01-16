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
public class Booked_Accomodation extends Accomodation {

    private String Username;
    private String start_date;
    private String end_date;
    private String Type;
    //private String roomType;
    //private int numberOfRooms;
    //private int numberOfBathRooms;
    //private int numberOfJacuzzi;

    public Booked_Accomodation(String Type,String Username, String start_date, String end_date, String ID, String location, String description, String first_available_date, String offer_description) {
        super(ID, location, description, first_available_date, offer_description);
        this.Username = Username;
        this.start_date = start_date;
        this.end_date = end_date;
        this.Type = Type;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

}

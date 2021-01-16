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
public class Suit extends Accomodation {

    private int numberOfJacuzzi;

    public Suit(int numberOfJacuzzi, String ID, String location, String description, String first_available_date, String offer_description) {
        super(ID, location, description, first_available_date, offer_description);
        this.numberOfJacuzzi = numberOfJacuzzi;
    }

    public int getNumberOfJacuzzi() {
        return numberOfJacuzzi;
    }

    public void setNumberOfJacuzzi(int numberOfJacuzzi) {
        this.numberOfJacuzzi = numberOfJacuzzi;
    }

}

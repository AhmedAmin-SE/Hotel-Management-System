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
    public String dexription;
    public String start_date;
    public String end_date;

    public Offer(String dexription, String start_date, String end_date) {
        this.dexription = dexription;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
}

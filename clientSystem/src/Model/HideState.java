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
public class HideState implements State{

    @Override
    public void Tafkeaction(Accomodation context) {
        context.setState("Hide");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Offer;
import View.addOffer;
import database.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.Admin_order_food_matrial;
import Model.required_raw_matrial;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Admin_oder_food_controller {

    Admin_order_food_matrial gui;

    // The constructor takes the gui and the rmi registry as paramaters
    public Admin_oder_food_controller(Admin_order_food_matrial gui) {
        this.gui = gui;

        // This registers the button with our action listener below (the inner class)
        gui.getjButton1().addActionListener(new Admin_oder_food_controller.GetAction());

    }

    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {

            String required_matrial = gui.getjTextField1().getText();
            String arriving_date = gui.getjTextField2().getText();

            if (required_matrial.isEmpty() || arriving_date.isEmpty()) {
                JOptionPane.showMessageDialog(null, "please fill the fields", null, JOptionPane.ERROR_MESSAGE);
            } else {
                required_raw_matrial rm = new required_raw_matrial(required_matrial, arriving_date);
                DB d = new DB();
                d.add_order_required_matrial(rm);
            }

        }

    }
}

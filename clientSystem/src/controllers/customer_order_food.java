/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Offer;
import Model.User;
import View.ReserveEntertainment;
import View.gui_Customer_order_food;
import database.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class customer_order_food {

    gui_Customer_order_food gui;
    DB database = new DB();
    User user;

    public customer_order_food(gui_Customer_order_food gui, User user) {
        this.gui = gui;
        this.user = user;
        gui.getjButton1().addActionListener(new customer_order_food.GetAction());
    }

    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {

            String desc = gui.getjTextField1().getText();

            if (desc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "please fill the fields", null, JOptionPane.ERROR_MESSAGE);
            } else {
                DB d = new DB();
                d.order_food(user.Username, desc);
            }

        }

    }
}

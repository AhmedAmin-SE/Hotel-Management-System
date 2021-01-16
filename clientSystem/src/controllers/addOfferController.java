/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Lenovo
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.DB;
import View.addOffer;

import Model.Offer;
import javax.swing.JOptionPane;

public class addOfferController {

    addOffer gui;

    // The constructor takes the gui and the rmi registry as paramaters
    public addOfferController(addOffer gui) {
        this.gui = gui;

        // This registers the button with our action listener below (the inner class)
        gui.getjButton1().addActionListener(new GetAction());

    }

    // This class is responsible for handling the button click
    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {

            String id = gui.getjTextField1().getText();
            String desc = gui.getjTextField4().getText();
            String start_date = gui.getjTextField5().getText();
            String end_date = gui.getjTextField6().getText();
            Offer offer = new Offer(id, desc, start_date, end_date);
            if (gui.getjTextField1().getText().isEmpty() || desc.isEmpty() || start_date.isEmpty() || end_date.isEmpty()) {
                JOptionPane.showMessageDialog(null, "please fill the fields", null, JOptionPane.ERROR_MESSAGE);
            } else {
                DB d = new DB();
                d.addoffer(offer);
            }

        }

    }

}

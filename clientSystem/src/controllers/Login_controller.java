/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Admin;
import Model.Offer;
import Model.User;
import View.addOffer;
import View.adminInterface;
import database.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.login;
import View.userinterface;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Login_controller {

    login gui;

    // The constructor takes the gui and the rmi registry as paramaters
    public Login_controller(login gui) {
        this.gui = gui;

        // This registers the button with our action listener below (the inner class)
        gui.getjButton1().addActionListener(new GetAction());

    }

    // This class is responsible for handling the button click
    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {

            if(gui.getjTextField1().getText().isEmpty()||gui.getjTextField2().getText().isEmpty()){ JOptionPane.showMessageDialog(null, "please fill the fields", null, JOptionPane.ERROR_MESSAGE);}
           else if (!gui.getjTextField1().getText().isEmpty() && !gui.getjTextField2().getText().isEmpty() && gui.getjComboBox1().getSelectedIndex() == 1) {
                String username = gui.getjTextField1().getText();
                String password = gui.getjTextField2().getText();
                DB d = new DB();
                User us = d.loginuser(username, password);
                if (us != null) {
                    System.out.println("yes");
                    userinterface ui = new userinterface();
                    ui.setVisible(true);
                    userInterfaceController uic = new userInterfaceController(ui, us);
                } else {
                   JOptionPane.showMessageDialog(null, "wrong password or username", null, JOptionPane.ERROR_MESSAGE);
                }

            } else if (!gui.getjTextField1().getText().isEmpty() && !gui.getjTextField2().getText().isEmpty() && gui.getjComboBox1().getSelectedIndex() == 0) {
                String username = gui.getjTextField1().getText();
                String password = gui.getjTextField2().getText();
                DB d = new DB();
                Admin us = d.loginadmin(username, password);
                if (us != null) {
                    adminInterface ui = new adminInterface();
                    ui.setVisible(true);
                    adminInterfaceController ain = new adminInterfaceController(ui);
                    gui.setVisible(false);
                } else {
                  JOptionPane.showMessageDialog(null, "wrong password or username", null, JOptionPane.ERROR_MESSAGE);
                }

            }

        }

    }
}

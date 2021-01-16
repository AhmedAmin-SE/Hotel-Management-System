/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.signupInterface;
import rmi.SignUp;
import controllers.addOfferController;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class signupController {

    SignUp gui;
    Registry r;

    // The constructor takes the gui and the rmi registry as paramaters
    public signupController(SignUp gui, Registry r) {
        this.gui = gui;
        this.r = r;
        // This registers the button with our action listener below (the inner class)
        gui.getjButton2().addActionListener(new GetAction());

        gui.getjButton4().addActionListener(new login());
    }

    // This class is responsible for handling the button click
    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                signupInterface ai = (signupInterface) r.lookup("signup");
                String Fname = gui.getjTextField1().getText();
                String Lname = gui.getjTextField2().getText();
                String PhoneNumber = gui.getjTextField3().getText();
                String Email = gui.getjTextField4().getText();
                String username = gui.getjTextField5().getText();
                String password = gui.getjTextField6().getText();
                if (Fname.isEmpty() || Lname.isEmpty() || PhoneNumber.isEmpty() || Email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "please fill the fields", null, JOptionPane.ERROR_MESSAGE);
                } else {
                    ai.SignUp(Fname, Lname, PhoneNumber, Email, username, password);
                    gui.setVisible(false);
                }
            } catch (RemoteException ex) {
                Logger.getLogger(signupController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(signupController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class addoffer implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent ae) {

            View.addOffer g = new View.addOffer();
            addOfferController gui_controller = new addOfferController(g);
            g.setVisible(true);

        }
    }

    class require_data implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent ae) {

            View.Admin_order_food_matrial g = new View.Admin_order_food_matrial();
            controllers.Admin_oder_food_controller gui_controller = new controllers.Admin_oder_food_controller(g);
            g.setVisible(true);

        }
    }

    class login implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent ae) {
            gui.setVisible(false);
            View.login g = new View.login();
            controllers.Login_controller gui_controller = new controllers.Login_controller(g);
            g.setVisible(true);

        }
    }
}

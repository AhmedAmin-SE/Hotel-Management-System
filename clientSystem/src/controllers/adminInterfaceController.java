/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.required_raw_matrial;
import View.adminInterface;
import database.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lenovo
 */
public class adminInterfaceController {

    adminInterface gui;

    // The constructor takes the gui and the rmi registry as paramaters
    public adminInterfaceController(adminInterface gui) {
        this.gui = gui;

        // This registers the button with our action listener below (the inner class)
        gui.getjButton1().addActionListener(new adminInterfaceController.GetAction());
        gui.getjButton2().addActionListener(new adminInterfaceController.ordermaterial());
        gui.getjButton3().addActionListener(new adminInterfaceController.deleteAccomdation());
        gui.getjButton4().addActionListener(new adminInterfaceController.deleteEntertanment());
        gui.getjButton5().addActionListener(new adminInterfaceController.delete_offer());
        gui.getjButton6().addActionListener(new adminInterfaceController.addoffer());

        gui.getjButton7().addActionListener(new adminInterfaceController.add_event());
    }

    class add_event implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent ae) {

            View.add_event g = new View.add_event();
            Add_entertanment_event gui_controller = new Add_entertanment_event(g);
            g.setVisible(true);

        }
    }

    class delete_offer implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent ae) {

            View.DeleteOffer g = new View.DeleteOffer();
            DeleteOfferController gui_controller = new DeleteOfferController(g);
            g.setVisible(true);

        }
    }

    class deleteEntertanment implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent ae) {

            View.DeleteEntertainmentEvent g = new View.DeleteEntertainmentEvent();
            DeleteEntertainmentEventController gui_controller = new DeleteEntertainmentEventController(g);
            g.setVisible(true);

        }
    }

    class deleteAccomdation implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent ae) {

            View.DeleteAccomodation g = new View.DeleteAccomodation();
            DeleteAccomodationController gui_controller = new DeleteAccomodationController(g);
            g.setVisible(true);

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

    class ordermaterial implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            View.Admin_order_food_matrial ac = new View.Admin_order_food_matrial();
            ac.setVisible(true);
            Admin_oder_food_controller acc = new Admin_oder_food_controller(ac);
        }
    }

    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            gui.setVisible(false);
            View.AddAccomodation ac = new View.AddAccomodation();
            ac.setVisible(true);
            AddAccomodationController acc = new AddAccomodationController(ac);

        }

    }
}

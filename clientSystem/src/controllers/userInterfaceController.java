/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.User;
import View.CancelReservation;
import View.RateAccomodation;
import View.ReserveAccomodation;
import View.ReserveEntertainment;
import View.UpdateReservation;
import View.gui_Customer_order_food;
import View.userinterface;
import database.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lenovo
 */
public class userInterfaceController {

    ReserveAccomodation ReserveAccomodation_gui = new ReserveAccomodation();
    RateAccomodation RateRoom_gui = new RateAccomodation();
    CancelReservation CancelReservation_gui = new CancelReservation();
    ReserveEntertainment ReserveEntertainment_gui = new ReserveEntertainment();
    UpdateReservation UpdateReservation_gui = new UpdateReservation();
    userinterface gui;
    DB database = new DB();
    User user;

    public userInterfaceController(userinterface gui, User user) {
        this.gui = gui;
        this.user = user;
        gui.getjButton1().addActionListener(new Reserve_Accomodation());
        gui.getjButton2().addActionListener(new Cancel_Reservation());
        gui.getjButton3().addActionListener(new Rate_Room());
        gui.getjButton4().addActionListener(new Reserve_Entertainment());
        gui.getjButton5().addActionListener(new Update_Reservation());
        gui.getjButton6().addActionListener(new order_food());
    }

    class order_food implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {

            View.gui_Customer_order_food gu = new gui_Customer_order_food();
            gu.setVisible(true);

            customer_order_food rac = new customer_order_food(gu, user);
        }
    }

    // This class is responsible for handling the button click
    class Reserve_Accomodation implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {

            ReserveAccomodation_gui.setVisible(true);
            ReserveAccomodation_gui.setLocationRelativeTo(null);
            ReserveAccomodationController rac = new ReserveAccomodationController(ReserveAccomodation_gui, user);
        }
    }

    class Cancel_Reservation implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            CancelReservation_gui.setVisible(true);
            CancelReservation_gui.setLocationRelativeTo(null);
            CancelReservationController crc = new CancelReservationController(CancelReservation_gui, user);
        }
    }

    class Rate_Room implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            RateRoom_gui.setVisible(true);
            RateRoom_gui.setLocationRelativeTo(null);
            RateAccomodationController rrc = new RateAccomodationController(RateRoom_gui, user);
        }
    }

    class Reserve_Entertainment implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            ReserveEntertainment_gui.setVisible(true);
            ReserveEntertainment_gui.setLocationRelativeTo(null);
            ReserveEntertainmentController rec = new ReserveEntertainmentController(ReserveEntertainment_gui, user);
        }
    }

    class Update_Reservation implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            UpdateReservation_gui.setVisible(true);
            UpdateReservation_gui.setLocationRelativeTo(null);
            updateReservationController urc = new updateReservationController(UpdateReservation_gui, user);
        }
    }
}

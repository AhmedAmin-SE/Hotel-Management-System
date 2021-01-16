/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import View.AddAccomodation;
import View.AddRoom;
import View.AddVilla;
import View.AddSuit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import database.DB;
import Model.Room;
import Model.Suit;
import Model.Villa;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class AddAccomodationController {

    AddRoom Add_Room_GUI = new AddRoom();
    AddVilla Add_Villa_GUI = new AddVilla();
    AddSuit Add_Suit_GUI = new AddSuit();
    AddAccomodation gui;
    DB database = new DB();

    public AddAccomodationController(AddAccomodation gui) {
        //this.gui = gui;
        gui.getjButton1().addActionListener(new Add_Room());
        gui.getjButton2().addActionListener(new Add_Villa());
        gui.getjButton3().addActionListener(new Add_Suit());
    }

    // This class is responsible for handling the button click
    class Add_Room implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {

            Add_Room_GUI.setVisible(true);
            Add_Room_GUI.setLocationRelativeTo(null);
            Add_Room_GUI.getjButton().addActionListener(new addRoom());
        }
    }

    class addRoom implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String id = Add_Room_GUI.get_ID().getText();
            String location = Add_Room_GUI.get_Location().getText();
            String description = Add_Room_GUI.get_Description().getText();
            String first_available_date = Add_Room_GUI.getFirstAvailableDate().getText();
            String offer_description = Add_Room_GUI.getOfferDescription().getText();
            String room_type = Add_Room_GUI.getRoomType().getText();
            if (id.isEmpty() || location.isEmpty() || description.isEmpty() || first_available_date.isEmpty() || offer_description.isEmpty() || room_type.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields !", null, JOptionPane.ERROR_MESSAGE);
            } else if (!database.searchAccomodationById(id)) {
                database.addRoom(new Room(id, location, description, first_available_date, offer_description, room_type));
                JOptionPane.showMessageDialog(null, "The Room is successfully added to the Hotel !", null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "This ID already exists !", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class Add_Villa implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            Add_Villa_GUI.setVisible(true);
            Add_Villa_GUI.setLocationRelativeTo(null);
            Add_Villa_GUI.getjButton().addActionListener(new addVilla());
        }
    }

    class addVilla implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String id = Add_Villa_GUI.get_ID().getText();
            String location = Add_Villa_GUI.get_Location().getText();
            String description = Add_Villa_GUI.get_Description().getText();
            String first_available_date = Add_Villa_GUI.getFirstAvailableDate().getText();
            String offer_description = Add_Villa_GUI.getOfferDescription().getText();
            int number_of_rooms = parseInt(Add_Villa_GUI.getNumberOfRooms().getText());
            int number_of_bathrooms = parseInt(Add_Villa_GUI.getNumberOfBathrooms().getText());
            if (id.isEmpty() || location.isEmpty() || description.isEmpty() || first_available_date.isEmpty() || offer_description.isEmpty() || Add_Villa_GUI.getNumberOfRooms().getText().isEmpty() || Add_Villa_GUI.getNumberOfBathrooms().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields !", null, JOptionPane.ERROR_MESSAGE);
            } else if (!database.searchAccomodationById(id)) {
                database.addVilla(new Villa(number_of_rooms, number_of_bathrooms, id, location, description, first_available_date, offer_description));
                JOptionPane.showMessageDialog(null, "The Villa is successfully added to the Hotel !", null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "This ID already exists !", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class Add_Suit implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            Add_Suit_GUI.setVisible(true);
            Add_Suit_GUI.setLocationRelativeTo(null);
            Add_Suit_GUI.getjButton().addActionListener(new addSuit());
        }
    }

    class addSuit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String id = Add_Suit_GUI.get_ID().getText();
            String location = Add_Suit_GUI.get_Location().getText();
            String description = Add_Suit_GUI.get_Description().getText();
            String first_available_date = Add_Suit_GUI.getFirstAvailableDate().getText();
            String offer_description = Add_Suit_GUI.getOfferDescription().getText();
            int number_of_jacuzzi = parseInt(Add_Suit_GUI.getNumberOfJacuzzi().getText());
            if (id.isEmpty() || location.isEmpty() || description.isEmpty() || first_available_date.isEmpty() || offer_description.isEmpty() || Add_Suit_GUI.getNumberOfJacuzzi().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields !", null, JOptionPane.ERROR_MESSAGE);
            } else if (!database.searchAccomodationById(id)) {
                database.addSuit(new Suit(number_of_jacuzzi, id, location, description, first_available_date, offer_description));
                JOptionPane.showMessageDialog(null, "The Suit is successfully added to the Hotel !", null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "This ID already exists !", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

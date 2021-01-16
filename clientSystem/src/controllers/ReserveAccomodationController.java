/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Accomodation;
import Model.Booked_Accomodation;
import Model.Room;
import Model.Suit;
import Model.User;
import Model.Villa;
import View.ReserveAccomodation;
import database.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ReserveAccomodationController {

    ReserveAccomodation gui;
    DB database = new DB();
    User user;

    public void RetrieveAccomodations() {
        int RowsUsed = 0;
        DefaultTableModel model = (DefaultTableModel) gui.getjTable().getModel();
        ArrayList<Room> Rooms = database.getAllRooms();
        ArrayList<Villa> Villas = database.getAllVillas();
        ArrayList<Suit> Suits = database.getAllSuits();
        model.setRowCount(Rooms.size() + Villas.size() + Suits.size());
        int row = 0;
        int col;
        for (int i = 0; i < Rooms.size(); i++) {
            col = 0;
            Room r = Rooms.get(i);
            model.setValueAt("Room", row, col++);
            model.setValueAt(r.getID(), row, col++);
            model.setValueAt(r.getLocation(), row, col++);
            model.setValueAt(r.getDescription(), row, col++);
            model.setValueAt(r.getFirst_available_date(), row, col++);
            model.setValueAt(r.getOffer_description(), row, col++);
            model.setValueAt(r.getRoomType(), row, col);
            row++;
            RowsUsed++;
        }
        for (int i = 0; i < Villas.size(); i++) {
            col = 0;
            Villa v = Villas.get(i);
            model.setValueAt("Villa", row, col++);
            model.setValueAt(v.getID(), row, col++);
            model.setValueAt(v.getLocation(), row, col++);
            model.setValueAt(v.getDescription(), row, col++);
            model.setValueAt(v.getFirst_available_date(), row, col++);
            model.setValueAt(v.getOffer_description(), row, col);
            col += 2;
            model.setValueAt(v.getNumberOfRooms(), row, col++);
            model.setValueAt(v.getNumberOfBathRooms(), row, col);
            row++;
            RowsUsed++;
        }
        for (int i = 0; i < Suits.size(); i++) {
            col = 0;
            Suit s = Suits.get(i);
            model.setValueAt("Suit", row, col++);
            model.setValueAt(s.getID(), row, col++);
            model.setValueAt(s.getLocation(), row, col++);
            model.setValueAt(s.getDescription(), row, col++);
            model.setValueAt(s.getFirst_available_date(), row, col++);
            model.setValueAt(s.getOffer_description(), row, col);
            col += 4;
            model.setValueAt(s.getNumberOfJacuzzi(), row, col);
            row++;
            RowsUsed++;
        }
    }

    public ReserveAccomodationController(ReserveAccomodation gui, User user) {
        this.gui = gui;
        this.user = user;
        RetrieveAccomodations();
        gui.getjButton().addActionListener(new GetAction());
    }

    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            String id = gui.getID().getText();
            String startDate = gui.getStartDate().getText();
            String endDate = gui.getEndDate().getText();
            if (id.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Empty fields !", null, JOptionPane.ERROR_MESSAGE);
            } else {
                boolean result = database.searchAccomodationById(id);
                if (result) {
                    Accomodation a = database.getAccomodationByID(id);
                    database.ReserveAccomodation(new Booked_Accomodation(database.getAccomodationType(id),user.Username, startDate, endDate, id, a.getLocation(), a.getDescription(), a.getFirst_available_date(), a.getOffer_description()));
                    JOptionPane.showMessageDialog(null, "You are successfully reserved this accomodation !", null, JOptionPane.INFORMATION_MESSAGE);
                    RetrieveAccomodations();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong ID !", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

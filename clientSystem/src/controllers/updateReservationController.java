/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Booked_Accomodation;
import Model.User;
import View.CancelReservation;
import View.UpdateReservation;
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
public class updateReservationController {

    UpdateReservation gui;
    DB database = new DB();
    User user;

    public void RetrieveBookedAccomodations() {
        int RowsUsed = 0;
        DefaultTableModel model = (DefaultTableModel) gui.getjTable().getModel();
        ArrayList<Booked_Accomodation> BookedAccomodations = database.getAllBookedAccomodations();
        int row = 0;
        int col;
        model.setRowCount(BookedAccomodations.size());
        for (int i = 0; i < BookedAccomodations.size(); i++) {
            if (BookedAccomodations.get(i).getUsername().equals(user.Username)) {
                col = 0;
                Booked_Accomodation ba = BookedAccomodations.get(i);
                model.setValueAt(ba.getID(), row, col++);
                model.setValueAt(ba.getLocation(), row, col++);
                model.setValueAt(ba.getDescription(), row, col++);
                model.setValueAt(ba.getOffer_description(), row, col++);
                model.setValueAt(ba.getStart_date(), row, col++);
                model.setValueAt(ba.getEnd_date(), row, col);
                row++;
                RowsUsed++;
            }
        }
        model.setRowCount(RowsUsed);
    }

    public updateReservationController(UpdateReservation gui, User user) {
        this.gui = gui;
        this.user = user;
        RetrieveBookedAccomodations();
        gui.getjButton().addActionListener(new GetAction());
    }

    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            String id = gui.getAccomodationID().getText();
            String startdate = gui.getNewStartDate().getText();
            String enddate = gui.getNewEndDate().getText();
            if (id.isEmpty() || startdate.isEmpty() || enddate.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Empty fields !", null, JOptionPane.ERROR_MESSAGE);
            } else {
                if (!database.searchForBookedAccomodation(id)) {
                    JOptionPane.showMessageDialog(null, "Wrong ID !", null, JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean result = database.searchBookedAccomodation(user.Username, id);
                    if (result) {
                        database.UpdateReservation(id, startdate, enddate);
                        JOptionPane.showMessageDialog(null, "You are successfully updated your reservation !", null, JOptionPane.INFORMATION_MESSAGE);
                        RetrieveBookedAccomodations();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong ID !", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Entertainment_Event;
import Model.User;
import View.ReserveEntertainment;
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
public class ReserveEntertainmentController {
    
    ReserveEntertainment gui;
    DB database = new DB();
    User user;
    
    public void RetrieveEvents() {
        int RowsUsed = 0;
        DefaultTableModel model = (DefaultTableModel) gui.getjTable().getModel();
        ArrayList<Entertainment_Event> Events = database.getAllEntertainmentEvents();
        model.setRowCount(Events.size());
        int row = 0;
        int col;
        for (int i = 0; i < Events.size(); i++) {
            col = 0;
            Entertainment_Event e = Events.get(i);
            model.setValueAt(e.getID(), row, col++);
            model.setValueAt(e.getTitle(), row, col++);
            model.setValueAt(e.getAvailable_places(), row, col++);
            model.setValueAt(e.getDescription(), row, col++);
            model.setValueAt(e.getStart_date(), row, col++);
            model.setValueAt(e.getEnd_date(), row, col);
            row++;
            RowsUsed++;
        }
    }
    
    public ReserveEntertainmentController(ReserveEntertainment gui, User user) {
        this.gui = gui;
        this.user = user;
        RetrieveEvents();
        gui.getjButton().addActionListener(new GetAction());
    }
    
    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            String id = gui.getEventID().getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Event ID !", null, JOptionPane.ERROR_MESSAGE);
            } else {
                Entertainment_Event event = database.searchEventByID(id);
                if (event != null) {
                    if (event.getAvailable_places() == 0) {
                        JOptionPane.showMessageDialog(null, "No Available places in this Event !", null, JOptionPane.ERROR_MESSAGE);
                    } else {
                        database.ReserveEvent(id, event);
                        JOptionPane.showMessageDialog(null, "You successfully reserved a place in this Event !", null, JOptionPane.INFORMATION_MESSAGE);
                        RetrieveEvents();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong ID !", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

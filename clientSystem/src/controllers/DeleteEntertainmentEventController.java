/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.DB;
import Model.Entertainment_Event;
import View.DeleteEntertainmentEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class DeleteEntertainmentEventController {

    DeleteEntertainmentEvent gui;
    DB database = new DB();

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

    public DeleteEntertainmentEventController(DeleteEntertainmentEvent gui) {
        this.gui = gui;
        RetrieveEvents();
        gui.getjButton().addActionListener(new GetAction());
    }
    // This class is responsible for handling the button click

    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            String id = gui.getID().getText();
            boolean result = database.deleteDocumentById("Entertainment_Event", id);
            if (result) {
                JOptionPane.showMessageDialog(null, "The Offer is successfully deleted !", null, JOptionPane.INFORMATION_MESSAGE);
                RetrieveEvents();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong ID !", null, JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}

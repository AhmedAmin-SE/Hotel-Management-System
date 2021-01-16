/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.DB;
import Model.Offer;
import View.DeleteOffer;
import com.mongodb.client.MongoCollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author DELL
 */
public class DeleteOfferController {

    DeleteOffer gui;
    DB database = new DB();

    public void RetrieveOffers() {
        int RowsUsed = 0;
        DefaultTableModel model = (DefaultTableModel) gui.getjTable().getModel();
        ArrayList<Offer> Offers = database.getAllOffers();
        model.setRowCount(Offers.size());
        int row = 0;
        int col;
        for (int i = 0; i < Offers.size(); i++) {
            col = 0;
            Offer o = Offers.get(i);
            model.setValueAt(o.getID(), row, col++);
            model.setValueAt(o.getDescription(), row, col++);
            model.setValueAt(o.getStart_date(), row, col++);
            model.setValueAt(o.getEnd_date(), row, col);
            row++;
            RowsUsed++;
        }
    }

    public DeleteOfferController(DeleteOffer gui) {
        this.gui = gui;
        RetrieveOffers();
        gui.getjButton().addActionListener(new GetAction());
    }
    // This class is responsible for handling the button click

    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            String id = gui.getID().getText();
            boolean result = database.deleteDocumentById("Offer", id);
            if (result) {
                JOptionPane.showMessageDialog(null, "The Offer is successfully deleted !", null, JOptionPane.INFORMATION_MESSAGE);
                RetrieveOffers();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong ID !", null, JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}

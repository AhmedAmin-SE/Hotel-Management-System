/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.required_raw_matrial;
import database.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.add_event;
import Model.Entertainment_Event;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Add_entertanment_event {

    add_event gui;

    // The constructor takes the gui and the rmi registry as paramaters
    public Add_entertanment_event(add_event gui) {
        this.gui = gui;

        // This registers the button with our action listener below (the inner class)
        gui.getjButton1().addActionListener(new Add_entertanment_event.GetAction());

    }

    class GetAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            String id = gui.getjTextField6().getText();
            String title = gui.getjTextField1().getText();
            int number_available_places = Integer.parseInt(gui.getjTextField2().getText());
            String desc = gui.getjTextField3().getText();
            String start_date = gui.getjTextField4().getText();
            String end_date = gui.getjTextField5().getText();
            if (id.isEmpty() || title.isEmpty() || gui.getjTextField2().getText().isEmpty() || desc.isEmpty() || start_date.isEmpty() || end_date.isEmpty()) {
                JOptionPane.showMessageDialog(null, "please fill the fields", null, JOptionPane.ERROR_MESSAGE);
            } else {
                Entertainment_Event ee = new Entertainment_Event(id, title, number_available_places, desc, start_date, end_date);
                DB d = new DB();
                d.add_entertanment_Event(ee);
            }

        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsystem;

import controllers.signupController;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.SignUp;
import View.addOffer;
import controllers.addOfferController;
import Model.Admin;
import com.sun.net.httpserver.Authenticator.Failure;
import database.DB;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;


/**
 *
 * @author DELL
 */
public class ClientSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
       SignUp gui = new SignUp();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        Registry r = LocateRegistry.getRegistry(1099);
        signupController gui_controller = new signupController(gui, r);
       
       Admin a1=new Admin("kareem","medhat","123456","kareemmedhat",0123,"kareem169877@bue.edu");
       Admin a2=new Admin("ahmed","amin","123457","ahmedamin",0123,"ahmed172970@bue.edu");
       DB d=new DB();
       d.insertadmin(a1);
       d.insertadmin(a2);
       
      
    }

}

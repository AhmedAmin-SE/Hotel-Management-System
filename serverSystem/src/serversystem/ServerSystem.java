/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversystem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import rmi.signup;
import rmi.signupInterface;
import rmi.addOfferInterface;
import rmi.addoffer;
/**
 *
 * @author DELL
 */
public class ServerSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        // TODO code application logic here
        signupInterface ai = new signup();
         addOfferInterface ad = new addoffer();
        // An RMI Registry initialized on port 1099
        Registry r = LocateRegistry.createRegistry(1099);
        
        // Our remote object g is binded to the name "grade"
        r.bind("signup",ai);
        r.bind("offer", ad);
        
        // Outputs that the server is ready
        System.out.println("The server is ready");
        
    }

}

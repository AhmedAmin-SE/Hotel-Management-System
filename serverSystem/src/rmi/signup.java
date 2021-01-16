/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author DELL
 */
public class signup extends UnicastRemoteObject implements signupInterface {

    public signup() throws RemoteException {
    }

    @Override
    public void SignUp(String Fname, String Lname, String PhoneNumber, String Email,String username,String password) throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongoClient = new MongoClient();
        MongoDatabase ICS = mongoClient.getDatabase("Hotel");
        MongoCollection<Document> collection = ICS.getCollection("user");
        Document Doc1 = new Document("Fname", Fname).append("Lname", Lname).append("phone_number", PhoneNumber).append("Email", Email).append("Username", username).append("password", password);
        collection.insertOne(Doc1);
    }
}

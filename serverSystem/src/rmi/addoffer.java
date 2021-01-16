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

import Model.Offer;
/**
 *
 * @author Lenovo
 */
public class addoffer extends UnicastRemoteObject implements addOfferInterface{
      public addoffer() throws RemoteException {
    }

    @Override
     
    public void addOffer(String d,String s,String e) throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongoClient = new MongoClient();
        MongoDatabase ICS = mongoClient.getDatabase("project");
        MongoCollection<Document> collection = ICS.getCollection("Offer");
        Document Doc2 = new Document("description", d).append("offer.start_date",s).append("end_date", e);
        collection.insertOne(Doc2);
    }
}

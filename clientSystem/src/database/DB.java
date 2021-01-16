/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Model.Accomodation;
import Model.Admin;
import Model.Booked_Accomodation;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import Model.Offer;
import Model.Room;
import Model.Suit;
import Model.Entertainment_Event;
import Model.Rated_Accomodation;
import Model.required_raw_matrial;
import Model.User;
import Model.Villa;
import com.mongodb.client.model.Updates;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class DB {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    MongoCollection<Document> collection2;
    MongoCollection<Document> collection3;
    private Gson gson = new Gson();

    public DB() {
        client = new MongoClient();
        database = client.getDatabase("Hotel");
        // collection.insertOne(Document.parse(gson.toJson(new Room("1", "2", "3", "4", "5", "6"))));
    }

    public void addoffer(Offer offer) {
        collection = database.getCollection("Offer");
        collection.insertOne(Document.parse(gson.toJson(offer)));
    }

    public void insertadmin(Admin ad) {
        collection = database.getCollection("Admin");
        collection.insertOne(Document.parse(gson.toJson(ad)));
    }

    public void add_order_required_matrial(required_raw_matrial r) {
        collection = database.getCollection("require_matrial");
        collection.insertOne(Document.parse(gson.toJson(r)));
    }

    public void add_entertanment_Event(Entertainment_Event r) {
        collection = database.getCollection("Entertainment_Event");
        collection.insertOne(Document.parse(gson.toJson(r)));
    }

    public User loginuser(String username, String password) {
        collection = database.getCollection("user");
        Document doc = collection.find(Filters.eq("Username", username)).first();
       
        if (doc != null) {
             User result = gson.fromJson(doc.toJson(), User.class);
            if (result.password.equals(password)) {
                return result;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Admin loginadmin(String username, String password) {
        collection = database.getCollection("Admin");
        Document doc = collection.find(Filters.eq("Username", username)).first();
       
        if (doc != null) {
             Admin result = gson.fromJson(doc.toJson(), Admin.class);
            if (result.password.equals(password)) {
               
                return result;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void addRoom(Room room) {
        collection = database.getCollection("Room");
        collection.insertOne(Document.parse(gson.toJson(room)));
    }

    public void addVilla(Villa villa) {
        collection = database.getCollection("Villa");
        collection.insertOne(Document.parse(gson.toJson(villa)));
    }

    public void addSuit(Suit suit) {
        collection = database.getCollection("Suit");
        collection.insertOne(Document.parse(gson.toJson(suit)));
    }

    public ArrayList<Entertainment_Event> getAllEntertainmentEvents() {
        collection = database.getCollection("Entertainment_Event");
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        ArrayList<Entertainment_Event> result = new ArrayList<>();
        docs.stream().map(doc -> gson.fromJson(doc.toJson(), Entertainment_Event.class)).forEachOrdered(e -> {
            result.add(e);
        });
        return result;
    }

    public ArrayList<Offer> getAllOffers() {
        collection = database.getCollection("Offer");
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        ArrayList<Offer> result = new ArrayList<>();
        docs.stream().map(doc -> gson.fromJson(doc.toJson(), Offer.class)).forEachOrdered(o -> {
            result.add(o);
        });
        return result;
    }

    public boolean searchDocumentById(String collectionName, String id) {
        collection = database.getCollection(collectionName);
        Document Result = collection.find(Filters.all("ID", id)).first();
        if (Result == null) {
            return false;
        }
        return true;
    }

    public boolean deleteDocumentById(String collectionName, String id) {
        if (searchDocumentById(collectionName, id)) {
            collection = database.getCollection(collectionName);
            collection.deleteOne(Filters.eq("ID", id));
            return true;
        }
        return false;
    }

    public ArrayList<Room> getAllRooms() {
        collection = database.getCollection("Room");
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        ArrayList<Room> result = new ArrayList<>();
        docs.stream().map(doc -> gson.fromJson(doc.toJson(), Room.class)).forEachOrdered(r -> {
            result.add(r);
        });
        return result;
    }

    public ArrayList<Villa> getAllVillas() {
        collection = database.getCollection("Villa");
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        ArrayList<Villa> result = new ArrayList<>();
        docs.stream().map(doc -> gson.fromJson(doc.toJson(), Villa.class)).forEachOrdered(v -> {
            result.add(v);
        });
        return result;
    }

    public ArrayList<Suit> getAllSuits() {
        collection = database.getCollection("Suit");
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        ArrayList<Suit> result = new ArrayList<>();
        docs.stream().map(doc -> gson.fromJson(doc.toJson(), Suit.class)).forEachOrdered(s -> {
            result.add(s);
        });
        return result;
    }

    public boolean searchAccomodationById(String id) {
        collection = database.getCollection("Room");
        MongoCollection<Document> collection2 = database.getCollection("Villa");
        MongoCollection<Document> collection3 = database.getCollection("Suit");
        Document Result = collection.find(Filters.all("ID", id)).first();
        Document Result2 = collection2.find(Filters.all("ID", id)).first();
        Document Result3 = collection3.find(Filters.all("ID", id)).first();
        return !(Result == null && Result2 == null && Result3 == null);
    }

    public boolean deleteAccomodationById(String id) {
        if (searchAccomodationById(id)) {
            collection = database.getCollection("Room");
            MongoCollection<Document> collection2 = database.getCollection("Villa");
            MongoCollection<Document> collection3 = database.getCollection("Suit");
            collection.deleteOne(Filters.eq("ID", id));
            collection2.deleteOne(Filters.eq("ID", id));
            collection3.deleteOne(Filters.eq("ID", id));
            return true;
        }
        return false;
    }

    public ArrayList<Booked_Accomodation> getAllBookedAccomodations() {
        collection = database.getCollection("Booked_Accomodation");
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        ArrayList<Booked_Accomodation> result = new ArrayList<>();
        docs.stream().map(doc -> gson.fromJson(doc.toJson(), Booked_Accomodation.class)).forEachOrdered(a -> {
            result.add(a);
        });
        return result;
    }

    public Accomodation getAccomodationByID(String id) {
        Accomodation a;
        collection = database.getCollection("Room");
        MongoCollection<Document> collection2 = database.getCollection("Villa");
        MongoCollection<Document> collection3 = database.getCollection("Suit");
        Document Result = collection.find(Filters.all("ID", id)).first();
        Document Result2 = collection2.find(Filters.all("ID", id)).first();
        Document Result3 = collection3.find(Filters.all("ID", id)).first();
        if (Result != null) {
            a = gson.fromJson(Result.toJson(), Accomodation.class);
        } else if (Result2 != null) {
            a = gson.fromJson(Result2.toJson(), Accomodation.class);
        } else {
            a = gson.fromJson(Result3.toJson(), Accomodation.class);
        }
        return a;
    }

    public Room getRoomByID(String id) {
        Room room;
        collection = database.getCollection("Room");
        Document Result = collection.find(Filters.all("ID", id)).first();
        room = gson.fromJson(Result.toJson(), Room.class);
        return room;
    }

    public String getAccomodationType(String id) {
        collection = database.getCollection("Room");
        MongoCollection<Document> collection2 = database.getCollection("Villa");
        MongoCollection<Document> collection3 = database.getCollection("Suit");
        Document Result = collection.find(Filters.all("ID", id)).first();
        Document Result2 = collection2.find(Filters.all("ID", id)).first();
        Document Result3 = collection3.find(Filters.all("ID", id)).first();
        if (Result != null) {
            return "Room";
        } else if (Result2 != null) {
            return "Villa";
        }
        return "Suit";
    }

    public void ReserveAccomodation(Booked_Accomodation booked_accomodation) {
        deleteAccomodationById(booked_accomodation.getID());
        collection = database.getCollection("Booked_Accomodation");
        collection.insertOne(Document.parse(gson.toJson(booked_accomodation)));
    }

    public boolean searchBookedAccomodation(String Username, String id) {
        Booked_Accomodation ba;
        collection = database.getCollection("Booked_Accomodation");
        Document Result = collection.find(Filters.all("ID", id)).first();
        ba = gson.fromJson(Result.toJson(), Booked_Accomodation.class);
        return ba.getUsername().equals(Username);
    }

    public boolean searchForBookedAccomodation(String id) {
        Booked_Accomodation ba;
        collection = database.getCollection("Booked_Accomodation");
        Document Result = collection.find(Filters.all("ID", id)).first();
        return Result != null;
    }

    public Booked_Accomodation getBookedAccomodationByID(String ID) {
        Booked_Accomodation ba;
        collection = database.getCollection("Booked_Accomodation");
        Document Result = collection.find(Filters.all("ID", ID)).first();
        ba = gson.fromJson(Result.toJson(), Booked_Accomodation.class);
        return ba;
    }

    public void CancelReservation(String id) {
        Booked_Accomodation ba = getBookedAccomodationByID(id);
        collection = database.getCollection(ba.getType());
        collection.insertOne(Document.parse(gson.toJson(ba)));
        collection = database.getCollection("Booked_Accomodation");
        collection.deleteOne(Filters.eq("ID", id));
    }

    public void RateAccomodation(Rated_Accomodation ra) {
        collection = database.getCollection("Rated_Accomodation");
        collection.insertOne(Document.parse(gson.toJson(ra)));
    }

    public Entertainment_Event searchEventByID(String id) {
        Entertainment_Event event;
        collection = database.getCollection("Entertainment_Event");
        Document Result = collection.find(Filters.all("ID", id)).first();
        event = gson.fromJson(Result.toJson(), Entertainment_Event.class);
        return event;
    }

    public void ReserveEvent(String EventID, Entertainment_Event event) {
        collection = database.getCollection("Entertainment_Event");
        collection.updateOne(Filters.eq("ID", EventID), Updates.set("available_places", event.getAvailable_places() - 1));
    }

    public void UpdateReservation(String ID, String newStartDate, String newEndDate) {
        collection = database.getCollection("Booked_Accomodation");
        collection.updateOne(Filters.eq("ID", ID), Updates.set("start_date", newStartDate));
        collection.updateOne(Filters.eq("ID", ID), Updates.set("end_date", newEndDate));
    }
    public void order_food(String user_name,String desc){
    
     collection = database.getCollection("customer_order_food");
        Document Doc1 = new Document("Customer user name", user_name).append("description", desc);
        collection.insertOne(Doc1);
    }
}

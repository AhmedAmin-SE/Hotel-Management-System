/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Model.Accomodation;
import Model.Admin;
import Model.Booked_Accomodation;
import Model.Entertainment_Event;
import Model.Offer;
import Model.Rated_Accomodation;
import Model.Room;
import Model.Suit;
import Model.User;
import Model.Villa;
import database.DB;
import Model.required_raw_matrial;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertNotEquals;

/**
 *
 * @author DELL
 */
public class DBTest {

    DB db = new DB();

    public DBTest() {
    }

    /**
     * Test of addRoom method, of class DB.
     */
    @Test
    public void testaddRoom() {
        Room room = new Room("1211", "First Floor", "38 square meters", "1/15/2021", "10% discount", "Double");
        db.addRoom(room);
        ArrayList<Room> rooms = db.getAllRooms();
        int roomsSize = rooms.size();
        assertNotEquals(0, roomsSize);
    }

    /**
     * Test of ReserveAccomodation method, of class DB.
     */
    @Test
    public void testReserveAccomodation() {
        Room room = db.getRoomByID("1211");
        boolean isDeleted = db.deleteAccomodationById(room.getID());
        assertEquals(true, isDeleted);
        db.ReserveAccomodation(new Booked_Accomodation("Room", "Ahmed", "1/16/2021", "1/20/2021", room.getID(), room.getLocation(), room.getDescription(), room.getFirst_available_date(), room.getOffer_description()));
        ArrayList<Booked_Accomodation> Booked_Accomodations = db.getAllBookedAccomodations();
        int result = Booked_Accomodations.size();
        assertNotEquals(0, result);
    }

    /**
     * Test of UpdateReservation method, of class DB.
     */
    @Test
    public void UpdateReservation() {
        Room room = new Room("1290", "Ground", "40 square meters", "1/20/2021", "5% discount", "Trible");
        db.ReserveAccomodation(new Booked_Accomodation("Room", "Ahmed", "1/24/2021", "1/28/2021", room.getID(), room.getLocation(), room.getDescription(), room.getFirst_available_date(), room.getOffer_description()));
        Booked_Accomodation BookedAccomodation = db.getBookedAccomodationByID(room.getID());
        System.out.println(BookedAccomodation.getID());
        BookedAccomodation.setStart_date("2/4/2021");
        BookedAccomodation.setEnd_date("2/8/2021");
        db.UpdateReservation(BookedAccomodation.getID(), BookedAccomodation.getStart_date(), BookedAccomodation.getEnd_date());
        Booked_Accomodation newBookedAccomodation = db.getBookedAccomodationByID(room.getID());
        String StartDate = newBookedAccomodation.getStart_date();
        String EndDate = newBookedAccomodation.getEnd_date();
        String ExpectedStartDate = "2/4/2021";
        String ExpectedEndDate = "2/8/2021";
        assertEquals(ExpectedStartDate, StartDate);
        assertEquals(ExpectedEndDate, EndDate);
    }

    /**
     * Test of CancelReservation method, of class DB.
     */
    @Test
    public void testCancelReservation() {
        db.CancelReservation("1211");
        ArrayList<Room> Rooms = db.getAllRooms();
        ArrayList<Booked_Accomodation> Booked_Accomodations = db.getAllBookedAccomodations();
        int RoomsNo = Rooms.size();
        int ReservedNo = Booked_Accomodations.size();
        boolean isStillReserved = db.searchForBookedAccomodation("1211");
        boolean isBecomesAvailable = db.searchAccomodationById("1211");
        assertEquals(false, isStillReserved);
        assertEquals(true, isBecomesAvailable);
    }

    @Test
    public void testAddoffer() {
        System.out.println("addoffer");
        Offer offer = new Offer("1", "this is a new offer", "1/5/2021", "1/7/2020");
        DB d = new DB();
        d.addoffer(offer);
        ArrayList<Offer> offers = d.getAllOffers();
        // TODO review the generated test code and remove the default call to fail.
        int Result = offers.size();
        assertNotEquals(0, Result);

    }

    /**
     * Test of add_entertanment_Event method, of class DB.
     */
    @Test
    public void testAdd_entertanment_Event() {

        Entertainment_Event r = new Entertainment_Event("2", "concert", 5, "concert now", "1/6/2026", "1/6/2026");
        DB d = new DB();
        d.add_entertanment_Event(r);
        ArrayList<Entertainment_Event> events = d.getAllEntertainmentEvents();
        // TODO review the generated test code and remove the default call to fail.
        int Result = events.size();
        assertNotEquals(0, Result);
    }
}

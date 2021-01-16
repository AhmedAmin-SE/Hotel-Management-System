package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Model.Offer;

/**
 *
 * @author DELL
 */
public interface addOfferInterface extends Remote {

    void addOffer(String d,String s,String e) throws RemoteException;
}

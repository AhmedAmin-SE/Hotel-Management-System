/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DELL
 */
public interface signupInterface extends Remote {

    void SignUp(String Fname,String Lname,String PhoneNumber,String Email,String username,String password) throws RemoteException;
}

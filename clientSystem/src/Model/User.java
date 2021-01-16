/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class User {
   public String Fname;
     public String Lname;
   public String password;
   public String Username;
   public int phonenumber;
   public String Email;

    public User(String Fname, String Lname, String password, String Username, int phonenumber, String Email) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.password = password;
        this.Username = Username;
        this.phonenumber = phonenumber;
        this.Email = Email;
    }
    
}

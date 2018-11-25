/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.ContactUser;
import BL.Users;
import java.util.List;

/**
 *
 * @author dell
 */
public interface ContactUserInterface {
    
    void create(ContactUser contactUser) throws ContactUserException;
    void edit (ContactUser contactUser) throws ContactUserException;
    void remove(ContactUser contactUser) throws ContactUserException;
    List<ContactUser> findAll();
    ContactUser findById(int contactUserID) throws ContactUserException;
    public ContactUser finnByUserID(Users userID);
}

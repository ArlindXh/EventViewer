package DAL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BL.Users;
import DAL.UserException;
import java.util.List;

public interface UserInterface {
    
    void create(Users users) throws UserException;
    void edit (Users users) throws UserException;
    void remove(Users users) throws UserException;
    List<Users> findAll();
    Users findById(int Users) throws UserException;
}


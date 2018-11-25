/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


 import BL.Role;
import DAL.RoleException;
import java.util.List;

public interface RoleInterface {
    
     void create(Role role) throws RoleException;
    void edit (Role role) throws RoleException;
    void remove(Role role) throws RoleException;
    List<Role> findAll();
    Role findById(int RoleID) throws RoleException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Event;
import BL.EventUsers;
import BL.Role;
import java.util.List;

/**
 *
 * @author darda
 */
public interface EventUserInterface 
{
    void create(EventUsers eu) throws RoleException;
    void edit (EventUsers eu) throws RoleException;
    void remove(EventUsers eu) throws RoleException;
    List<EventUsers> findAll();
    List<EventUsers> findAllByUserRole(Role r , Event e);
    EventUsers findById(int eu) throws RoleException;
    
}

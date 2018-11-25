/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BL.Event;
import java.util.List;
/**
 *
 * @author user
 */
public interface EventInterface {
    void create (Event e) throws EventException;
    void edit (Event e ) throws EventException;
    void remove (Event e) throws EventException;
    List<Event> findAll();
    Event findById(int id) throws EventException;
    
}

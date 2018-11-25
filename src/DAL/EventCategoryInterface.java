/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BL.EventCategory;
import java.util.List;
/**
 *
 * @author user
 */
public interface EventCategoryInterface {
    void create (EventCategory e) throws EventCategoryException;
    void edit (EventCategory e ) throws EventCategoryException;
    void remove (EventCategory e) throws EventCategoryException;
    List<EventCategory> findAll();
    EventCategory findById(int id) throws EventCategoryException;
    
}


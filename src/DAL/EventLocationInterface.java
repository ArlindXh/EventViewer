/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EventLocation;
import java.util.List;

/**
 *
 * @author dell
 */
public interface EventLocationInterface {
    
    void create(EventLocation eventLocation) throws EventLocationException;
    void edit (EventLocation eventLocation) throws EventLocationException;
    void remove(EventLocation eventLocation) throws EventLocationException;
    List<EventLocation> findAll();
    EventLocation findById(int eventLocationID) throws EventLocationException;
    
}

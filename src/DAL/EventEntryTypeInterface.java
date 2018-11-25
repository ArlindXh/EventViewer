/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EventLocation;
import BL.EventEntryType;
import java.util.List;

/**
 *
 * @author dell
 */
public interface EventEntryTypeInterface {
    
    void create(EventEntryType eventType) throws EventEntryTypeException;
    void edit (EventEntryType eventType) throws EventEntryTypeException;
    void remove(EventEntryType eventType) throws EventEntryTypeException;
    List<EventEntryType> findAll();
    EventEntryType findById(int eventTypeID) throws EventEntryTypeException;
}

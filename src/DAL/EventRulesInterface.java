/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EventEntryType;
import BL.EventRules;
import java.util.List;

/**
 *
 * @author darda
 */
public interface EventRulesInterface 
{
    void create (EventRules e) throws EventRulesException;
    void edit (EventRules e ) throws EventRulesException;
    void remove (EventRules e) throws EventRulesException;
    List<EventRules> findAll();
    EventRules findById(int id) throws EventRulesException;
    public EventRules findEventEntry(EventEntryType categoryID);
}

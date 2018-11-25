/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BL.Event;
import BL.EventSchedule;
import java.util.List;

/**
 *
 * @author dell
 */
public interface EventScheduleInterface {
    
    
    void create(EventSchedule eventSchedule) throws EventScheduleException;
    void edit (EventSchedule eventSchedule) throws EventScheduleException;
    void remove(EventSchedule eventSchedule) throws EventScheduleException;
    List<EventSchedule> findAll();
    EventSchedule findById(int scheduleID) throws EventScheduleException;
    public EventSchedule findByEvent(Event event);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BL.Event;
import BL.EventSchedule;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
public class EventScheduleRepository extends EntMngClass implements EventScheduleInterface{
    
    public void create(EventSchedule eventSchedule) throws EventScheduleException {
        try{
            em.getTransaction().begin();
            em.persist(eventSchedule);
            em.getTransaction().commit();
        }
         catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new EventScheduleException("E dhëna egziston !");
            }
        else{
                throw new EventScheduleException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
    }
    public void edit(EventSchedule eventSchedule) throws EventScheduleException {
        try{
            em.getTransaction().begin();
            em.merge(eventSchedule);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new EventScheduleException("E dhëna egziston");
            }
            else{
                throw new EventScheduleException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(EventSchedule eventSchedule) throws EventScheduleException 
    {
        try{
            em.getTransaction().begin();
            em.remove(eventSchedule);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new EventScheduleException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new EventScheduleException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <EventSchedule> findAll() {
        return em.createNamedQuery("EventSchedule.findAll").getResultList();
    }
      
    public EventSchedule findById(int scheduleID) throws EventScheduleException
    {
        Query query = em.createQuery("SELECT p FROM EventSchedule p WHERE p.scheduleID = :scheduleID");
        query.setParameter("scheduleID", scheduleID);
        try
        {
            return (EventSchedule)query.getSingleResult();
        } 
        catch (NoResultException nre) 
        {
              throw new EventScheduleException("E dhëna nuk egziston!");
        }
    }
    
    public EventSchedule findByEvent(Event event)
    {
        Query query = em.createQuery("SELECT p FROM EventSchedule p WHERE p.eventID = :scheduleID");
        query.setParameter("scheduleID", event);
        
        return (EventSchedule)query.getSingleResult();
            
    }
       
    
}

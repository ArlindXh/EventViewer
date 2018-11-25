/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Event;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class EventRepository extends EntMngClass implements EventInterface {
    
    public EventRepository()
    {   
    }
    
    
    public void create (Event eventE) throws EventException 
    {
        
        try {
            em.getTransaction().begin();
            em.persist(eventE);
            em.getTransaction().commit();
        }catch (Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new EventException("E dhena ekziston");
            else
                throw new EventException("Create : " +tr.getClass()+ " - " +tr.getMessage());
        }
        
        
        
    }
    
    public void edit (Event eventE) throws EventException
    {
        try
        {
            em.getTransaction().begin();
            em.merge(eventE);
            em.getTransaction().commit();
            
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new EventException("E dhena ekziston");
            else
                throw new EventException("Update : " + tr.getClass()+ " - "+tr.getMessage());
        }
          
    }
    public void remove (Event eventE) throws EventException
    {
        try
        {
            em.getTransaction().begin();
            em.merge(eventE);
            em.getTransaction().commit();
            
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("547"))
                throw new EventException("E dhena ekziston");
            else
                throw new EventException("remove : " +tr.getClass()+ " - "+ tr.getMessage());
        }
    }
    
    public List<Event> findAll()
    {
        return em.createNamedQuery("Event.findAll").getResultList();
    }
    
    public Event findById(int EventID) throws EventException
    {
        Query query = em.createNamedQuery("Select e from Event e where e.EventID = :EventID");
        query.setParameter("EventID", EventID);
        try
        {
            return (Event)query.getSingleResult();
        }catch(NoResultException no)
        {
            throw new EventException("E dhena nuk ekziston");
        }
    }
    
}

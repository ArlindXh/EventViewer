/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EventCategory;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class EventCategoryRepository extends EntMngClass implements EventCategoryInterface {
    
    public EventCategoryRepository()
    {   
    }
    
    
    public void create (EventCategory eventCategoryE) throws EventCategoryException 
    {
        
        try {
            em.getTransaction().begin();
            em.persist(eventCategoryE);
            em.getTransaction().commit();
        }catch (Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new EventCategoryException("E dhena ekziston");
            else
                throw new EventCategoryException("Create : " +tr.getClass()+ " - " +tr.getMessage());
        }
        
        
        
    }
    
    public void edit (EventCategory eventCategoryE) throws EventCategoryException
    {
        try
        {
            em.getTransaction().begin();
            em.merge(eventCategoryE);
            em.getTransaction().commit();
            
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new EventCategoryException("E dhena ekziston");
            else
                throw new EventCategoryException("Update : " + tr.getClass()+ " - "+tr.getMessage());
        }
          
    }
    public void remove (EventCategory eventCategoryE) throws EventCategoryException
    {
        try
        {
            em.getTransaction().begin();
            em.remove(eventCategoryE);
            em.getTransaction().commit();
            
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("547"))
                throw new EventCategoryException("E dhena ekziston");
            else
                throw new EventCategoryException("remove : " +tr.getClass()+ " - "+ tr.getMessage());
        }
    }
    
    public List<EventCategory> findAll()
    {
        return em.createQuery("Select c from EventCategory c order by c.categoryName").getResultList();
    }
    
    public EventCategory findById(int EventCategoryID) throws EventCategoryException
    {
        Query query = em.createNamedQuery("Select eC from EventCategory eC where eC.EventCategoryID = :EventCategoryID");
        query.setParameter("EventCategoryID", EventCategoryID);
        try
        {
            return (EventCategory)query.getSingleResult();
        }catch(NoResultException no)
        {
            throw new EventCategoryException("E dhena nuk ekziston");
        }
    }
    
    public EventCategory findByName(String EventCategoryID) throws EventCategoryException
    {
        Query query = em.createNamedQuery("EventCategory.findByCategoryName");
        query.setParameter("EventCategoryID", EventCategoryID);
        try
        {
            return (EventCategory)query.getSingleResult();
        }catch(NoResultException no)
        {
            throw new EventCategoryException("E dhena nuk ekziston");
        }
    }
    
}

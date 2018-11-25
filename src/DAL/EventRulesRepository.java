/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BL.EventEntryType;
import BL.EventRules;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author darda
 */
public class EventRulesRepository extends EntMngClass implements EventRulesInterface
{
    public EventRulesRepository()
    {
    }
    
    @Override
    public void create(EventRules country) throws EventRulesException 
    {
        try
        {
            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new EventRulesException ("E dhena egziston");
            else
                throw new EventRulesException ("Create : "+tr.getClass()+" - "+tr.getMessage());
        }
        
    }  

    @Override
    public void edit(EventRules country) throws EventRulesException 
    {
        try
        {
            em.getTransaction().begin();
            em.merge(country);
            em.getTransaction().commit();
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new EventRulesException ("E dhena egziston");
            else
                throw new EventRulesException ("Update : "+tr.getClass()+" - "+tr.getMessage());
        }
    }

    @Override
    public void remove(EventRules country) throws EventRulesException 
    {
        try
        {
            em.getTransaction().begin();
            em.remove(country);
            em.getTransaction().commit();
            
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("547"))
                throw new EventRulesException ("E dhena egziston");
            else
                throw new EventRulesException ("remove : "+tr.getClass()+" - "+tr.getMessage());
        }
    }

    @Override
    public List<EventRules> findAll()
    {
        return em.createNamedQuery("EventRules.findAll").getResultList();
    }
    
    @Override
    public EventRules findById(int id) throws EventRulesException 
    {
        Query query = em.createNamedQuery("EventRules.findByEventRuleID");
        query.setParameter("eventRule", id);
        try
        {
            return (EventRules)query.getSingleResult();
            
        }catch(NoResultException no)
        {
            throw new EventRulesException ("E dhëna nuk egziston!");
        }   
    }
    
    public EventRules findEventEntry(EventEntryType categoryID)
    {
        Query query = em.createQuery("select c from EventRules e where e.eventEntryTypeID = :categoryID");
        query.setParameter("categoryID", categoryID);
        return (EventRules)query.getSingleResult();
        
    }

    
}

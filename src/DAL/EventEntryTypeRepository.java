/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BL.EventEntryType;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
public class EventEntryTypeRepository extends EntMngClass implements EventEntryTypeInterface{
    
    
    
    public EventEntryTypeRepository()
    {
    }
    
    public void create(EventEntryType eventType) throws EventEntryTypeException {
        try{
            em.getTransaction().begin();
            em.persist(eventType);
            em.getTransaction().commit();
        }
         catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new EventEntryTypeException("E dhëna egziston !");
            }
        else{
                throw new EventEntryTypeException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
    }
    public void edit(EventEntryType eventType) throws EventEntryTypeException {
        try{
            em.getTransaction().begin();
            em.merge(eventType);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new EventEntryTypeException("E dhëna egziston");
            }
            else{
                throw new EventEntryTypeException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(EventEntryType eventType) throws EventEntryTypeException {
        try{
            em.getTransaction().begin();
            em.remove(eventType);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new EventEntryTypeException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new EventEntryTypeException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <EventEntryType> findAll() {
        return em.createNamedQuery("EventEntryType.findAll").getResultList();
    }
      
    public EventEntryType findById(int eventTypeID) throws EventEntryTypeException
    {
        Query query = em.createQuery("SELECT p FROM EventEntryType p WHERE p.eventTypeID = :eventTypeID");
        query.setParameter("eventTypeID", eventTypeID);
        try
        {
            return (EventEntryType)query.getSingleResult();
        } 
        catch (NoResultException nre) 
        {
              throw new EventEntryTypeException("E dhëna nuk egziston!");
        }
    }
       
    
    }

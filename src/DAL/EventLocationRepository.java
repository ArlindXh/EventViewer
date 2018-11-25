/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.ContactUser;
import BL.EventLocation;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
public class EventLocationRepository extends EntMngClass implements EventLocationInterface{
    
    public void create(EventLocation eventLocation) throws EventLocationException {
        try{
            em.getTransaction().begin();
            em.persist(eventLocation);
            em.getTransaction().commit();
        }
         catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new EventLocationException("E dhëna egziston !");
            }
        else{
                throw new EventLocationException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
    }
    public void edit(EventLocation eventLocation) throws EventLocationException {
        try{
            em.getTransaction().begin();
            em.merge(eventLocation);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new EventLocationException("E dhëna egziston");
            }
            else{
                throw new EventLocationException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(EventLocation eventLocation) throws EventLocationException {
        try{
            em.getTransaction().begin();
            em.remove(eventLocation);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new EventLocationException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new EventLocationException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <EventLocation> findAll() {
        return em.createNamedQuery("EventLocation.findAll").getResultList();
    }
      
    public EventLocation findById(int eventLocationID) throws EventLocationException
    {
        Query query = em.createQuery("SELECT p FROM EventLocation p WHERE p.eventLocationID = :eventLocationID");
        query.setParameter("eventLocationID", eventLocationID);
        try
        {
            return (EventLocation)query.getSingleResult();
        } 
        catch (NoResultException nre) 
        {
              throw new EventLocationException("E dhëna nuk egziston!");
        }
    }
       
    
    }
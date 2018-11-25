/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EventImages;
import BL.EventLocation;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
public class EventImagesRepository extends EntMngClass implements EventImagesInterface{
    
    public void create(EventImages eventImages) throws EventImagesException {
        try{
            em.getTransaction().begin();
            em.persist(eventImages);
            em.getTransaction().commit();
        }
         catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new EventImagesException("E dhëna egziston !");
            }
        else{
                throw new EventImagesException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
    }
    public void edit(EventImages eventImages) throws EventImagesException {
        try{
            em.getTransaction().begin();
            em.merge(eventImages);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new EventImagesException("E dhëna egziston");
            }
            else{
                throw new EventImagesException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(EventImages eventImages) throws EventImagesException {
        try{
            em.getTransaction().begin();
            em.remove(eventImages);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new EventImagesException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new EventImagesException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <EventImages> findAll() {
        return em.createNamedQuery("EventImages.findAll").getResultList();
    }
      
    public EventImages findById(int imageID) throws EventImagesException
    {
        Query query = em.createQuery("SELECT p FROM EventImages p WHERE p.imageID = :imageID");
        query.setParameter("imageID", imageID);
        try
        {
            return (EventImages)query.getSingleResult();
        } 
        catch (NoResultException nre) 
        {
              throw new EventImagesException("E dhëna nuk egziston!");
        }
    }
       
    
    }

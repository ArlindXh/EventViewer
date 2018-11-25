/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EventLocation;
import BL.EventPayment;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
public class EventPaymentRepository extends EntMngClass implements EventPaymentInterface{
    
    public void create(EventPayment eventPayment) throws EventPaymentException {
        try{
            em.getTransaction().begin();
            em.persist(eventPayment);
            em.getTransaction().commit();
        }
         catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new EventPaymentException("E dhëna egziston !");
            }
        else{
                throw new EventPaymentException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
    }
    public void edit(EventPayment eventPayment) throws EventPaymentException {
        try{
            em.getTransaction().begin();
            em.merge(eventPayment);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new EventPaymentException("E dhëna egziston");
            }
            else{
                throw new EventPaymentException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(EventPayment eventPayment) throws EventPaymentException {
        try{
            em.getTransaction().begin();
            em.remove(eventPayment);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new EventPaymentException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new EventPaymentException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <EventPayment> findAll() {
        return em.createNamedQuery("EventPayment.findAll").getResultList();
    }
      
    public EventPayment findById(int paymentID) throws EventPaymentException
    {
        Query query = em.createQuery("SELECT p FROM EventPayment p WHERE p.paymentID = :paymentID");
        query.setParameter("paymentID", paymentID);
        try
        {
            return (EventPayment)query.getSingleResult();
        } 
        catch (NoResultException nre) 
        {
              throw new EventPaymentException("E dhëna nuk egziston!");
        }
    }
       
    
    }

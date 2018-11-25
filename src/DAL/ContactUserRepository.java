/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.ContactUser;
import BL.Users;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
public class ContactUserRepository extends EntMngClass implements ContactUserInterface{
    
    public void create(ContactUser contactUser) throws ContactUserException {
        try{
            em.getTransaction().begin();
            em.persist(contactUser);
            em.getTransaction().commit();
        }
         catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new ContactUserException("E dhëna egziston !");
            }
        else{
                throw new ContactUserException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
    }
    public void edit(ContactUser contactUser) throws ContactUserException {
        try{
            em.getTransaction().begin();
            em.merge(contactUser);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new ContactUserException("E dhëna egziston");
            }
            else{
                throw new ContactUserException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(ContactUser contactUser) throws ContactUserException {
        try{
            em.getTransaction().begin();
            em.remove(contactUser);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new ContactUserException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new ContactUserException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <ContactUser> findAll() {
        return em.createNamedQuery("ContactUser.findAll").getResultList();
    }
      
    public ContactUser findById(int contactUserID) throws ContactUserException
    {
        Query query = em.createQuery("SELECT p FROM ContactUser p WHERE p.contactUserID = :contactUserID");
        query.setParameter("contactUserID", contactUserID);
        try
        {
            return (ContactUser)query.getSingleResult();
        } 
        catch (NoResultException nre) 
        {
              throw new ContactUserException("E dhëna nuk egziston!");
        }
    }
    
    public ContactUser finnByUserID(Users userID)
    {
        Query query = em.createQuery("SELECT p FROM ContactUser p WHERE p.userID = :userID");
        query.setParameter("userID", userID);
         return (ContactUser)query.getSingleResult();
        
        
    }
       
    
}
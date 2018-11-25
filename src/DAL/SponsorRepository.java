/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BL.Sponsor;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Genci
 */
public class SponsorRepository extends EntMngClass implements SponsorInterface{
    
    public void create(Sponsor sponsor) throws SponsorException {
        try{
            em.getTransaction().begin();
            em.persist(sponsor);
            em.getTransaction().commit();
        }
         catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new SponsorException("E dhëna egziston !");
            }
        else{
                throw new SponsorException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
    }
    public void edit(Sponsor sponsor) throws SponsorException {
        try{
            em.getTransaction().begin();
            em.merge(sponsor);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new SponsorException("E dhëna egziston");
            }
            else{
                throw new SponsorException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Sponsor sponsor) throws SponsorException {
        try{
            em.getTransaction().begin();
            em.remove(sponsor);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new SponsorException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new SponsorException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Sponsor> findAll() {
        return em.createNamedQuery("Sponsor.findAll").getResultList();
    }
      
    public Sponsor findById(int sponsorID) throws SponsorException
    {
        Query query = em.createQuery("SELECT p FROM Sponsor p WHERE p.sponsorID = :sponsorID");
        query.setParameter("sponsorID", sponsorID);
        try
        {
            return (Sponsor)query.getSingleResult();
        } 
        catch (NoResultException nre) 
        {
              throw new SponsorException("E dhëna nuk egziston!");
        }
    }
       
    
    }


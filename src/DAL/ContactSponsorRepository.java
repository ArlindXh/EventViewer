/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.ContactSponsor;
import BL.Sponsor;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ContactSponsorRepository extends EntMngClass implements ContactSponsorInterface {
    
    public ContactSponsorRepository(){}
    
public void create(ContactSponsor contactSponsor) throws ContactSponsorException {
        try{
            em.getTransaction().begin();
            em.persist(contactSponsor);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new ContactSponsorException("E dhëna egziston !");
            }
        else{
                throw new ContactSponsorException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(ContactSponsor contactSponsor) throws  ContactSponsorException {
        try{
            em.getTransaction().begin();
            em.merge(contactSponsor);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new ContactSponsorException("E dhëna egziston");
            }
            else{
                throw new ContactSponsorException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(ContactSponsor contactSponsor) throws ContactSponsorException {
        try{
            em.getTransaction().begin();
            em.remove(contactSponsor);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new ContactSponsorException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new ContactSponsorException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <ContactSponsor> findAll() {
        return em.createNamedQuery("ContactSponsor.findAll").getResultList();
    }
    public ContactSponsor findById(int ContactSponsorID) throws ContactSponsorException {
        Query query = em.createQuery("SELECT p FROM ContactSponsor d WHERE d.ContactSponsorID = :ContactSponsorID");
        query.setParameter("ContactSponsorID", ContactSponsorID);
        try{
            return (ContactSponsor)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ContactSponsorException("E dhëna nuk egziston!");
        }
    }
    public ContactSponsor findBySponsorID(Sponsor s)
    {
        Query query  = em.createQuery("Select s from ContactSponsor s where s.sponsorID = :sponsorID");
        query.setParameter("sponsorID", s);
        return (ContactSponsor)query.getSingleResult();
    }
}
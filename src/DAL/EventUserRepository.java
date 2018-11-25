/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Event;
import BL.EventUsers;
import BL.Role;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author darda
 */
public class EventUserRepository extends EntMngClass implements EventUserInterface
{
    public EventUserRepository(){}
    
    public void create(EventUsers eu) throws RoleException {
        try{
            em.getTransaction().begin();
            em.persist(eu);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new RoleException("E dhëna egziston !");
            }
        else{
                throw new RoleException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(EventUsers eu) throws  RoleException {
        try{
            em.getTransaction().begin();
            em.merge(eu);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new RoleException("E dhëna egziston");
            }
            else{
                throw new RoleException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(EventUsers eu) throws RoleException {
        try{
            em.getTransaction().begin();
            em.remove(eu);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new RoleException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new RoleException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <EventUsers> findAll() {
        return em.createNamedQuery("EventUsers.findAll").getResultList();
    }
    public EventUsers findById(int euID) throws RoleException {
        Query query = em.createQuery("SELECT r FROM EventUsers r WHERE r.euID = :euID");
        query.setParameter("euID", euID);
        try{
            return (EventUsers)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new RoleException("E dhëna nuk egziston!");
        }
    }
    
    public List<EventUsers> findAllByUserRole(Role roleID,Event e)
    {
        Query query = em.createQuery("SELECT eu FROM EventUsers eu WHERE eu.eventID = :eventID and eu.usersID.roleID = :roleID ");
        query.setParameter("roleID", roleID);
        query.setParameter("eventID", e);
        return query.getResultList();
        
    }
    


    
    
}

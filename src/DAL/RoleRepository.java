/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Role;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class RoleRepository extends EntMngClass implements RoleInterface {
    public RoleRepository(){}
    
    public void create(Role role) throws RoleException {
        try{
            em.getTransaction().begin();
            em.persist(role);
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
    public void edit(Role role) throws  RoleException {
        try{
            em.getTransaction().begin();
            em.merge(role);
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
    public void remove(Role role) throws RoleException {
        try{
            em.getTransaction().begin();
            em.remove(role);
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
    public List <Role> findAll() {
        return em.createNamedQuery("Role.findAll").getResultList();
    }
    public Role findById(int roleID) throws RoleException {
        Query query = em.createQuery("SELECT r FROM Role r WHERE r.roleID = :roleID");
        query.setParameter("roleID", roleID);
        try{
            return (Role)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new RoleException("E dhëna nuk egziston!");
        }
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Users;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
public class UserRepository extends EntMngClass implements UserInterface{
    
    public void create(Users users) throws UserException {
        try{
            em.getTransaction().begin();
            em.persist(users);
            em.getTransaction().commit();
        }
         catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new UserException("E dhëna egziston !");
            }
        else{
                throw new UserException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
    }
    public void edit(Users users) throws UserException {
        try{
            em.getTransaction().begin();
            em.merge(users);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new UserException("E dhëna egziston");
            }
            else{
                throw new UserException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Users users) throws UserException {
        try{
            em.getTransaction().begin();
            em.remove(users);
            em.getTransaction().commit();
            
            
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new UserException("E dhëna është përdorur, nuk mund ta fshini!");
            }
            else{
                 throw new UserException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Users> findAll() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }
       public Users findById(int userID) throws UserException {
        Query query = em.createQuery("SELECT p FROM Users p WHERE p.userID = :userID");
        query.setParameter("userID", userID);
        try{
            return (Users)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UserException("E dhëna nuk egziston!");
        }
       }
       
    public Users findByUserPass(String userN,String pass)throws UserException
    {
        Query query = em.createQuery("Select u from Users u where u.userName = :userName and u.password = :pass");
        query.setParameter("userName", userN);
        query.setParameter("pass", pass);
        try
        {
            return (Users)query.getSingleResult();
        }
        catch(NoResultException ue)
        {
            throw new UserException("E dhëna nuk egziston!");
        }
    }
    
    public Users findByFirstName(String userN)throws UserException
    {
        Query query = em.createNamedQuery("Users.findByFirstName");
        query.setParameter("firstName", userN);
        try
        {
            return (Users)query.getSingleResult();
        }
        catch(NoResultException ue)
        {
            throw new UserException("E dhëna nuk egziston!");
        }
    }
    
} 

    


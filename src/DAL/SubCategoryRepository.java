/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EventCategory;
import BL.SubCategory;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author darda
 */
public class SubCategoryRepository extends EntMngClass implements SubCategoryInterface
{
    public SubCategoryRepository()
    {
        
    }
    
    @Override
    public void create(SubCategory sc)throws SubCategoryException
    {
        try
        {
            em.getTransaction().begin();
            em.persist(sc);
            em.getTransaction().commit();
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new SubCategoryException("E dhena egziston");
            else
                throw new SubCategoryException("Create : "+tr.getClass()+" - "+tr.getMessage());
        }
        
    }  

    @Override
    public void edit(SubCategory sc)throws SubCategoryException
    {
        try
        {
            em.getTransaction().begin();
            em.merge(sc);
            em.getTransaction().commit();
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new SubCategoryException("E dhena egziston");
            else
                throw new SubCategoryException("Update : "+tr.getClass()+" - "+tr.getMessage());
        }
    }

    @Override
    public void remove(SubCategory sc)throws SubCategoryException {
        try
        {
            em.getTransaction().begin();
            em.remove(sc);
            em.getTransaction().commit();
            
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("547"))
                throw new SubCategoryException("E dhena egziston");
            else
                throw new SubCategoryException("remove : "+tr.getClass()+" - "+tr.getMessage());
        }
    }

    @Override
    public List<SubCategory> findAll()
    {
        return em.createNamedQuery("SubCategory.findAll").getResultList();
    }

    @Override
    public SubCategory findByID(int co)throws SubCategoryException
    {
        Query query = em.createNamedQuery("Select p from SubCategory p where p.subCategoryID = :countryID");
        query.setParameter("subCategoryID", co);
        try
        {
            return (SubCategory)query.getSingleResult();
            
        }catch(NoResultException no)
        {
            throw new SubCategoryException("E dhëna nuk egziston!");
        }   
    }
    
    public SubCategory findByCategoryID(EventCategory c)
    {
        Query query = em.createQuery("Select s from SubCategory s where s.eventCategoryID = :eventCategory");
        query.setParameter("eventCategory", c);
        return (SubCategory)query.getSingleResult();
    }
    
}

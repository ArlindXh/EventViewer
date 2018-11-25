/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.City;
import BL.Country;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author darda
 */
public class CityRepository extends EntMngClass implements CityInterface
{
    public CityRepository()
    {
    }
    
    public void create(City city) throws CityException 
    {
        try 
        {
            em.getTransaction().begin();
            em.persist(city);
            em.getTransaction().commit();
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new CityException("E dhena egziston");
            else
                throw new CityException("Create : "+tr.getClass()+" - "+tr.getMessage());
        }
        
    }  

    @Override
    public void edit(City city) throws CityException
    {
        try
        {
            em.getTransaction().begin();
            em.merge(city);
            em.getTransaction().commit();
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new CityException("E dhena egziston");
            else
                throw new CityException("Update : "+tr.getClass()+" - "+tr.getMessage());
        }
    }

    @Override
    public void remove(City city) throws CityException
    {
        try
        {
            em.getTransaction().begin();
            em.remove(city);
            em.getTransaction().commit();
            
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("547"))
                throw new CityException("E dhena egziston");
            else
                throw new CityException("remove : "+tr.getClass()+" - "+tr.getMessage());
        }
    }

    @Override
    public List<City> findAll()
    {
        return em.createNamedQuery("City.findAll").getResultList();
    }

    @Override
    public City findByID(int cityID) throws CityException
    {
        Query query = em.createNamedQuery("Select p from City p where p.cityID = :cityID");
        query.setParameter("cityID", cityID);
        try
        {
            return (City)query.getSingleResult();
            
        }catch(NoResultException no)
        {
            throw new CityException("E dhëna nuk ekziston!");
        }   
    }
    
    public City findByName(String cityID) throws CityException
    {
        Query query = em.createNamedQuery("City.findByCityName");
        query.setParameter("cityName", cityID);
        try
        {
            return (City)query.getSingleResult();
            
        }catch(NoResultException no)
        {
            throw new CityException("E dhëna nuk ekziston!");
        }   
    }
    

    public List<City> findCitys(Country countryID)
    {
        Query query = em.createQuery("select c from City c  where c.countryID = :countryID order by c.cityName");
        query.setParameter("countryID", countryID);
        return query.getResultList();
        
    }
}

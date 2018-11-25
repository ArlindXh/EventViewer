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
public class CountryRepository extends EntMngClass implements CountryInterface
{
    public CountryRepository()
    {
    }
    
    @Override
    public void create(Country country) throws CountryException 
    {
        try
        {
            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new CountryException("E dhena egziston");
            else
                throw new CountryException("Create : "+tr.getClass()+" - "+tr.getMessage());
        }
        
    }  

    @Override
    public void edit(Country country) throws CountryException 
    {
        try
        {
            em.getTransaction().begin();
            em.merge(country);
            em.getTransaction().commit();
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("2627"))
                throw new CountryException ("E dhena egziston");
            else
                throw new CountryException ("Update : "+tr.getClass()+" - "+tr.getMessage());
        }
    }

    @Override
    public void remove(Country country) throws CountryException  {
        try
        {
            em.getTransaction().begin();
            em.remove(country);
            em.getTransaction().commit();
            
        }catch(Throwable tr)
        {
            if(tr.getMessage().contains("547"))
                throw new CountryException ("E dhena egziston");
            else
                throw new CountryException ("remove : "+tr.getClass()+" - "+tr.getMessage());
        }
    }

    @Override
    public List<Country> findAll()
    {
        return em.createNamedQuery("Country.findAll").getResultList();
    }
    
    public List<Country> findAllOrdered()
    {
        return em.createQuery("Select c "
                                 + "from Country c "
                                 + "order by c.countryName").getResultList();
    }
           
    public Country findByCountryName(String countryName) throws CountryException 
    {
        Query query = em.createNamedQuery("Country.findByCountryName");
        query.setParameter("countryName", countryName);
        try
        {
            return (Country)query.getSingleResult();
            
        }catch(NoResultException no)
        {
            throw new CountryException ("E dhëna nuk egziston!");
        }   
    }

    @Override
    public Country findByID(int countryID) throws CountryException 
    {
        Query query = em.createNamedQuery("Select p from Country p where p.countryID = :countryID");
        query.setParameter("personiID", countryID);
        try
        {
            return (Country)query.getSingleResult();
            
        }catch(NoResultException no)
        {
            throw new CountryException ("E dhëna nuk egziston!");
        }   
    }
    
    public List<City> findCitys()
    {
        return em.createQuery("select c " +
                               "from Country c " +
                                "inner join c. co on c.countryID = co.countryID").getResultList();
    }
}

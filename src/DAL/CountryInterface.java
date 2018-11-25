/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BL.City;
import BL.Country;
import java.util.List;

/**
 *
 * @author darda
 */
public interface CountryInterface 
{
    void create(Country a)throws CountryException;
    void edit(Country a)throws CountryException;
    void remove(Country a)throws CountryException;
    List<Country> findAll();
    Country findByID(int adminId)throws CountryException;
    List<Country> findAllOrdered();
    Country findByCountryName(String countryName) throws CountryException;
    List<City> findCitys();
            
}

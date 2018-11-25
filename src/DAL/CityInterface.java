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
public interface CityInterface
{
    void create(City city)throws CityException;
    void edit(City city)throws CityException;
    void remove(City city)throws CityException;
    List<City> findAll();
    City findByID(int cityID)throws CityException;

    public City findByName(String cityID) throws CityException;
    public List<City> findCitys(Country countryID);
}

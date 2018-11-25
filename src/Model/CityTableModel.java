/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.City;
import BL.Country;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darda
 */
public class CityTableModel extends AbstractTableModel
{
    private final String [] columnNames = {"City","ZipCode","Country","Country Code"};
    
    public List<City> data;
    public CityTableModel()
    {
    }
    
    public CityTableModel(List<City>data){
        this.data = data;
    }

    public void add(List<City>data){
        this.data = data;
    }

    public int getRowCount()
    {
       return data.size();
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
    
    public String getColumnName(int col)
    {
        return columnNames[col];
    }
    
    public City getCity(int index)
    {
        return data.get(index);
    }
    public void remove(int index)
    {
        data.remove(index);
    }
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        City p = (City)data.get(rowIndex);
        Country country = p.getCountryID();
        switch(columnIndex)
        {
            case 0:
                return p.getCityName();
            case 1:
                return p.getZipCode();
            case 2:
                return country.getCountryName();
            case 3:
                return country.getCountryCode();
                
            default:
                return null;
          
        }
          
    }
}

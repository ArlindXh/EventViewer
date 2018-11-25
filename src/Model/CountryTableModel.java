/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import BL.Country;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darda
 */
public class CountryTableModel extends AbstractTableModel
{
    private final String [] columnNames = {"CountryName","Country Code"};
    
    private List<Country> data;
    
    public CountryTableModel(List<Country>data)
    {
        this.data = data;
    }
    
    public CountryTableModel()
    {
        
    }
    
    public void add(List<Country>data)
    {
        this.data = data;
    }
    
    public int getRowCount() 
    {
        return data.size();
    }
    
      @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        data.remove(row);
    }

    public Country getCountry(int index){
        return data.get(index);
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Country co = (Country)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return co.getCountryName();
            case 1:
                return co.getCountryCode();
            
                 
            default:
                return null;
        }
    }
}

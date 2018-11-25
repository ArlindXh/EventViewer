/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.City;
import BL.Country;
import BL.Event;
import BL.EventLocation;
import DAL.CityInterface;
import DAL.CityRepository;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dell
 */
public class EventLocationModel extends AbstractTableModel
{
    
    private final String [] columnNames = {"Country Name" , "City Name","ZipCode","Street","Description" , "Event Name"};
    
    CityInterface coR = new CityRepository();
    
    
    public List<EventLocation> data;
    
    public EventLocationModel()
    {
    }
    
    public EventLocationModel(List<EventLocation>data){
        this.data = data;
    }

    public void add(List<EventLocation>data){
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
    
    public EventLocation getEventLocation(int index)
    {
        return data.get(index);
    }
    public void remove(int index)
    {
        data.remove(index);
    }
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        EventLocation eventLocation = getEventLocation(rowIndex);
        City co = eventLocation.getCityID();
        Country cc = co.getCountryID();
        Event event =eventLocation.getEventID();
        
        
        
        switch(columnIndex)
         {   
            
            case 0 :
                return cc.getCountryName();
            
            case 1:
                return co.getCityName();
            case 2:
                return co.getZipCode();
            case 3:
                return eventLocation.getStreet();
            case 4:
                return eventLocation.getDescription();
            case 5 :
                return event.getEventName();
          
                    
                
            default:
                return null;
        
        }
          
    }
}

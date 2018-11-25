/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Event;
import BL.EventImages;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class EventImageModel extends AbstractTableModel
{
    private final String [] columnNames = {"Event Name","Event Image"};
    
    public List<EventImages> data;
    public EventImageModel()
    {
    }
    
    public EventImageModel(List<EventImages>data){
        this.data = data;
    }

    public void add(List<EventImages>data){
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
    
    public EventImages getEventImages(int index)
    {
        return data.get(index);
    }
    public void remove(int index)
    {
        data.remove(index);
    }
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        EventImages ei = (EventImages)data.get(rowIndex);
        Event e = ei.getEventID();
        
        switch(columnIndex)
        {
            case 0:
                return e.getEventName();
            case 1:
                return ei.getEventImage();
           
                
            default:
                return null;
          
        }
          
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import BL.EventCategory;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class EventCategoryTableModel extends AbstractTableModel 
{
    
    private final String [] columnNames = {"Kategoria","Pershkrimi"};
    
    private List<EventCategory> data;
    
    public EventCategoryTableModel(List<EventCategory>data)
    {
        this.data = data;
    }
    
    public EventCategoryTableModel()
    {
        
    }
    
    public void add(List<EventCategory>data)
    {
        this.data = data;
    }
    
    public int getRowCount()
    {
        return data.size();
    }
    
    public int getColumnCount()
    {
        return columnNames.length;
    }
    public String getColumnName(int col)
    {
    return columnNames[col];    
    }
    public void remove (int row){
        data.remove(row);
    }
    public EventCategory getEventCategory(int index)
    {
        return data.get(index);
    }
    
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        EventCategory ec = (EventCategory)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return ec.getCategoryName();
            case 1:
                return ec.getDescription();
                
            default:
                return null;
        }
    }
    
    
}

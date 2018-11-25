/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.EventEntryType;
import BL.EventPayment;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darda
 */
public class EventEntryTypeTableModel extends AbstractTableModel
{
    private final String [] columnNames = {"Entry Name","Price","Payment Type","Description"};
    
    public List<EventEntryType> data;
    
    public EventEntryTypeTableModel()
    {
    }
    
    public EventEntryTypeTableModel(List<EventEntryType>data){
        this.data = data;
    }

    public void add(List<EventEntryType>data){
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
    
    public EventEntryType getEventEntryType(int index)
    {
        return data.get(index);
    }
    public void remove(int index)
    {
        data.remove(index);
    }
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        EventEntryType p = (EventEntryType)data.get(rowIndex);
        EventPayment ep = p.getEventPaymentID();
        switch(columnIndex)
        {
            case 0:
                return p.getEventTypeName();
            case 1:
                return ep.getPrice();
            case 2:
                return ep.getPaymentType();
            case 3:
                return p.getDescription();
                
            default:
                return null;
          
        }
          
    }
}

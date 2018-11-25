/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Event;
import BL.EventSchedule;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darda
 */
public class EventScheduleTableModel extends AbstractTableModel
{
    private final String [] columnNames = {"Event Name","Start Date","End Date"};
    
    private List<EventSchedule> data;
    
    public EventScheduleTableModel(List<EventSchedule>data)
    {
        this.data = data;
    }
    
    public EventScheduleTableModel()
    {
        
    }
    
    public void add(List<EventSchedule>data)
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

    public EventSchedule getEventSchedule(int index){
        return data.get(index);
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EventSchedule co = (EventSchedule)data.get(rowIndex);
        Event e = co.getEventID();
        switch(columnIndex){
            
            case 0:
                return e.getEventName();
            case 1:
                return co.getStartDate();
            case 2:
                return co.getEndDate();
            
                 
            default:
                return null;
        }
    }
}

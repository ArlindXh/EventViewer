/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Event;
import BL.EventCategory;
import BL.EventEntryType;
import BL.EventPayment;
import BL.EventRules;
import BL.EventSchedule;
import BL.Sponsor;
import BL.SubCategory;
import DAL.EventRulesInterface;
import DAL.EventRulesRepository;
import DAL.EventScheduleInterface;
import DAL.EventScheduleRepository;
import DAL.SubCategoryInterface;
import DAL.SubCategoryRepository;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darda
 */
public class EventTableModel extends AbstractTableModel
{
    private final String [] columnNames = {"Event Name","Event Capacity","Event Entry","Event Payment" , "Event Rule",
                                            "Event Price","Event Category","Sub Category","Entry Description"
                                            ,"Sponsor Name","Sponsor Company","Start Date","End Date"};
    
    EventRulesInterface  evRep = new EventRulesRepository();
    EventScheduleInterface  evSchR = new EventScheduleRepository();
    SubCategoryInterface subR = new SubCategoryRepository();
    
    public List<Event> data;
    
    public EventTableModel()
    {
    }
    
    public EventTableModel(List<Event>data){
        this.data = data;
    }

    public void add(List<Event>data){
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
    
    public Event getEvent(int index)
    {
        return data.get(index);
    }
    public void remove(int index)
    {
        data.remove(index);
    }
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Event event = (Event)data.get(rowIndex);
        EventCategory evCa = event.getEventCategoryID();
        SubCategory evSub = subR.findByCategoryID(evCa);
        EventEntryType evE= event.getEventEntryType();
        EventPayment evP = evE.getEventPaymentID();
        EventRules evR = evRep.findEventEntry(evE);
        Sponsor evS = event.getSponsorID();
        EventSchedule evSch = evSchR.findByEvent(event);
        switch(columnIndex)
        {
            case 0:                                       
                return event.getEventName();
            case 1:
                return  event.getEventCapacity() + "";
            case 2:
                return evE.getEventTypeName();
            case 3:
                return evP.getPaymentType();
            case 4:
                return evR.getDescription();
            case 5:
                return evP.getPrice() + "";
            case 6:
                return evCa.getCategoryName();
            case 7:
                return evSub.getSubCategryName();
            case 8:
                return evE.getDescription();  
            case 9:
                return evS.getSponsorName();
            case 10:
                return evS.getSponsorCompany();
            case 11:
                return evSch.getStartDate();
            case 12:
                return evSch.getEndDate();    
            
             
                
                
                
                
            default:
                return null;
          
        }
          
//        {"Event Name","Event Capacity","Event Entry","Event Payment" , "Event Rule",
//                                            "Event Price","Event Category","Sub Category","Event Description"
//                                            ,"Sponsor Name","Sponsor Company","Start Date","End Date"};
    }
}

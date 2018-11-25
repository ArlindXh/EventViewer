/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import BL.Event;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author dell
 */
public class EventComboBoxModel extends AbstractListModel<Event> implements ComboBoxModel<Event>
{
     private Event sItem;
    private List<Event> data;
    
    public EventComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Event getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (Event)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }
}

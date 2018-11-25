/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.EventCategory;
import GUI.*;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author darda
 */
public class CategoryComboBoxModel extends AbstractListModel<EventCategory> implements ComboBoxModel<EventCategory>
{
     private EventCategory sItem;
    private List<EventCategory> data;
    
    public CategoryComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public EventCategory getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (EventCategory)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }

}

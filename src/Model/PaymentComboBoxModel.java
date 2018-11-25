/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.EventPayment;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author darda
 */
public class PaymentComboBoxModel  extends AbstractListModel<EventPayment> implements ComboBoxModel<EventPayment>
{
    private EventPayment sItem;
    private List<EventPayment> data;
    
    public PaymentComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public EventPayment getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (EventPayment)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }
}

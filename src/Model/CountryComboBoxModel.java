/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Country;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author darda
 */
public class CountryComboBoxModel extends AbstractListModel<Country> implements ComboBoxModel<Country>
{
    private Country sItem;
    private List<Country> data;
    
    public CountryComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Country getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (Country)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }
    
}

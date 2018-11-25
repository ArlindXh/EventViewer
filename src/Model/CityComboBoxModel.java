/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import BL.City;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author darda
 */
public class CityComboBoxModel extends AbstractListModel<City> implements ComboBoxModel<City>
{
     private City sItem;
    private List<City> data;
    
    public CityComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public City getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (City)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }
}

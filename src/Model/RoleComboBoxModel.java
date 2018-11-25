/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import BL.Role;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author darda
 */
public class RoleComboBoxModel extends AbstractListModel<Role> implements ComboBoxModel<Role>
{
    private Role sItem;
    private List<Role> data;
    
    public RoleComboBoxModel(List arrayList){
        data = arrayList;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Role getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        sItem = (Role)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return sItem;
    }
    
}

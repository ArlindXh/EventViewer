/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Role;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darda
 */
public class RoleTableModel extends AbstractTableModel
{
    private final String [] columnNames = {"Role ID","Role Type"};
    
    public List<Role> data;
    
    public RoleTableModel()
    {
    }
    
    public RoleTableModel(List<Role>data){
        this.data = data;
    }

    public void add(List<Role>data){
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
    
    public Role getRole(int index)
    {
        return data.get(index);
    }
    public void remove(int index)
    {
        data.remove(index);
    }
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Role p = (Role)data.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return p.getRoleID();
            case 1:
                return p.getType();
            
            default:
                return null;
          
        }
          
    }
}

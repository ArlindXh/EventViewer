/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import BL.EventCategory;
import BL.SubCategory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale.Category;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darda
 */
public class SubCategoryTableModel extends AbstractTableModel
{
    private final String [] columnNames = {"Sub Category","Category Name","Category Description"};
    
    private List<SubCategory> data;
    
    public SubCategoryTableModel(List<SubCategory>data)
    {
        this.data = data;
    }
    
    public SubCategoryTableModel()
    {
        
    }
    
    public void add(List<SubCategory>data)
    {
        this.data = data;
    }
    
    public int getRowCount() 
    {
        return data.size();
    }
    

    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        data.remove(row);
    }

    public SubCategory getSubCategory(int index){
        return data.get(index);
    }
    
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        SubCategory admin = getSubCategory(rowIndex);
        EventCategory c = admin.getEventCategoryID();
        switch(columnIndex){
            
            case 0:
                return admin.getSubCategryName();
            case 1:
                return  c.getCategoryName();
            case 2:
                return c.getDescription();
            
                  
            default:
                return null;
        }
    }
}

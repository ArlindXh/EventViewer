/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import BL.Report;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ReportTableForm extends AbstractTableModel
{
    private final String [] columnNames = {"EventName","Report Description"};
    
    public List<Report> data;
    public ReportTableForm()
    {
    }
    
    public ReportTableForm(List<Report>data){
        this.data = data;
    }

    public void add(List<Report>data){
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
    
    public Report getReport(int index)
    {
        return data.get(index);
    }
    public void remove(int index)
    {
        data.remove(index);
    }
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Report r = (Report)data.get(rowIndex);
        
        switch(columnIndex)
        {
            case 0:
                return r.getReportID();
            case 1:
                return r.getDescription();
           
                
            default:
                return null;
          
        }
          
    }
}
    



package Model;

import BL.Sponsor;
import BL.ContactSponsor;
import DAL.ContactSponsorInterface;
import DAL.ContactSponsorRepository;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class SponsorTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Emri i Sponzorit", "Kompania e Sponzorit","Phone1","Phone2","Email1","Email2"};
    
    ContactSponsorInterface  cRep = new ContactSponsorRepository();
    
    public List<Sponsor> data;
    
    public SponsorTableModel()
    {
        
    }
    
    public SponsorTableModel(List<Sponsor> data){
        this.data = data;
    }
    
    public void add (List<Sponsor> data){
        this.data = data;
        
    }
    public int getRowCount(){
        return data.size();  
    }
    public int getColumnCount(){
        return columnNames.length;
    }
    public String getColumnName(int col) {
        return columnNames[col];
        
    }
    public Sponsor getSponsor(int index){
        return data.get(index);
        
    }
    public void remove (int index){
        data.remove(index);
    }
 
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Sponsor sponzori  = getSponsor(rowIndex);
        ContactSponsor co = cRep.findBySponsorID(sponzori);
        switch(columnIndex)
        {
            case 0:
                return sponzori.getSponsorName();
            case 1:
                return sponzori.getSponsorCompany();
            case 2:
                return co.getPhone1();
            case 3:
                return co.getPhone2();
            case 4:
                return co.getEMail1();
            case 5:
                return co.getEMail2();
                
            default:
                return null;
          
                
                
        }
     
    }
    
    
}

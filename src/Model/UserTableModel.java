/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.City;
import BL.ContactUser;
import BL.Country;
import BL.Users;
import DAL.ContactUserInterface;
import DAL.ContactUserRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author darda
 */
public class UserTableModel extends AbstractTableModel
{
    
    private final String [] columnNames = {"First Name","LastName","UserName","Email","PhoneNo","BirthDate","Gender"
                                            ,"City","Country","Email2","Phone2","Role"};
    
    ContactUserInterface coR = new ContactUserRepository();
    
    public List<Users> data;
    
    public UserTableModel()
    {
    }
    
    public UserTableModel(List<Users>data){
        this.data = data;
    }

    public void add(List<Users>data){
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
    
    public Users getUser(int index)
    {
        return data.get(index);
    }
    public void remove(int index)
    {
        data.remove(index);
    }
    public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd-MM-yyyy");
        return da.format(date);
    }
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Users user = getUser(rowIndex);
        ContactUser co = coR.finnByUserID(user);
        City city = user.getCityID();
        Country cu = city.getCountryID();
        String dateF = getDate(user.getBirthDate());
        
        switch(columnIndex)
        {
            case 0:
                return user.getFirstName();
            case 1:
                return user.getLastName();
            case 2:
                return user.getUserName();
            case 3:
                return co.getEmail1();
            case 4:
                return co.getPhoneNo1();
            case 5:
                return getDate(user.getBirthDate());
            case 6:
                return user.getGender() + "";
            case 7:
                return city.getCityName();
            case 8:
                return cu.getCountryName();
            case 9:
                return dateF;
            case 10:
                return co.getPhoneNo2();   
            case 11:
                return user.getRoleID().getType();
                    
                
            default:
                return null;
        
        }
          
    }
}

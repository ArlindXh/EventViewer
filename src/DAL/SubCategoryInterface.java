/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EventCategory;
import BL.SubCategory;
import java.util.List;

/**
 *
 * @author darda
 */
public interface SubCategoryInterface
{
    void create(SubCategory a)throws SubCategoryException;
    void edit(SubCategory a)throws SubCategoryException;
    void remove(SubCategory a)throws SubCategoryException;
    List<SubCategory> findAll();
    SubCategory findByID(int subCategoryId)throws SubCategoryException;
    SubCategory findByCategoryID(EventCategory c);
            
}

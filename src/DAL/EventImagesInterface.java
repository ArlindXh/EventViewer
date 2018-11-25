/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EventImages;

import java.util.List;

/**
 *
 * @author dell
 */
public interface EventImagesInterface {
    
    
    void create(EventImages  eventImages) throws EventImagesException;
    void edit (EventImages eventImages) throws EventImagesException;
    void remove(EventImages eventImages) throws EventImagesException;
    List<EventImages> findAll();
    EventImages findById(int imageID) throws EventImagesException;
}

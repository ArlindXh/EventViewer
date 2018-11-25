/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author darda
 */
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class EntMngClass {
    EntityManager em = Persistence.createEntityManagerFactory("EventViewerPU").createEntityManager();
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Report;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ReportRepository extends EntMngClass implements ReportInterface {
    
    public ReportRepository(){}
    
    public void create(Report report) throws ReportException {
        try{
            em.getTransaction().begin();
            em.persist(report);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new ReportException("E dhëna egziston !");
            }
        else{
                throw new ReportException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Report report) throws  ReportException {
        try{
            em.getTransaction().begin();
            em.merge(report);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new ReportException("E dhëna egziston");
            }
            else{
                throw new ReportException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Report report) throws ReportException {
        try{
            em.getTransaction().begin();
            em.remove(report);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new ReportException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new ReportException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Report> findAll() {
        return em.createNamedQuery("Report.findAll").getResultList();
    }
    public Report findById(int ReportID) throws ReportException {
        Query query = em.createQuery("SELECT p FROM Report d WHERE d.ReportID = :ReportID");
        query.setParameter("ReportID", ReportID);
        try{
            return (Report)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ReportException("E dhëna nuk egziston!");
        }
    }

    
    
    
    
}

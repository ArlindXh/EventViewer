/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
 import BL.Report;
import DAL.ReportException;
import java.util.List;

public interface ReportInterface {
    
     void create(Report report) throws ReportException;
    void edit (Report report) throws ReportException;
    void remove(Report report) throws ReportException;
    List<Report> findAll();
    Report findById(int ReportID) throws ReportException;
    
    
}

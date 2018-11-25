/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BL.Sponsor;
import java.util.List;

/**
 *
 * @author dell
 */
public interface SponsorInterface {
    
    void create(Sponsor  sponsor) throws SponsorException;
    void edit (Sponsor sponsor) throws SponsorException;
    void remove(Sponsor sponsor) throws SponsorException;
    List<Sponsor> findAll();
    Sponsor findById(int sponsorID) throws SponsorException;
    
}

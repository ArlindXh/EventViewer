/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

 import BL.ContactSponsor;
import BL.Sponsor;
import DAL.ContactSponsorException;
import java.util.List;

public interface ContactSponsorInterface {
    
    void create(ContactSponsor contactSponsor) throws ContactSponsorException;
    void edit (ContactSponsor contactSponsor) throws ContactSponsorException;
    void remove(ContactSponsor contactSponsor) throws ContactSponsorException;
    List<ContactSponsor> findAll();
    ContactSponsor findById(int ContactSponsorID) throws ContactSponsorException;
    ContactSponsor findBySponsorID(Sponsor s);
}

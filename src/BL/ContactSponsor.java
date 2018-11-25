/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author darda
 */
@Entity
@Table(name = "ContactSponsor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactSponsor.findAll", query = "SELECT c FROM ContactSponsor c")
    , @NamedQuery(name = "ContactSponsor.findByContactSponsorID", query = "SELECT c FROM ContactSponsor c WHERE c.contactSponsorID = :contactSponsorID")
    , @NamedQuery(name = "ContactSponsor.findByPhone1", query = "SELECT c FROM ContactSponsor c WHERE c.phone1 = :phone1")
    , @NamedQuery(name = "ContactSponsor.findByPhone2", query = "SELECT c FROM ContactSponsor c WHERE c.phone2 = :phone2")
    , @NamedQuery(name = "ContactSponsor.findByEMail1", query = "SELECT c FROM ContactSponsor c WHERE c.eMail1 = :eMail1")
    , @NamedQuery(name = "ContactSponsor.findByEMail2", query = "SELECT c FROM ContactSponsor c WHERE c.eMail2 = :eMail2")})
public class ContactSponsor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "contactSponsorID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer contactSponsorID;
    @Basic(optional = false)
    @Column(name = "phone1")
    private String phone1;
    @Column(name = "phone2")
    private String phone2;
    @Basic(optional = false)
    @Column(name = "e_mail1")
    private String eMail1;
    @Column(name = "e_mail2")
    private String eMail2;
    @JoinColumn(name = "sponsorID", referencedColumnName = "sponsorID")
    @ManyToOne
    private Sponsor sponsorID;

    public ContactSponsor() {
    }

    public ContactSponsor(Integer contactSponsorID) {
        this.contactSponsorID = contactSponsorID;
    }

    public ContactSponsor(Integer contactSponsorID, String phone1, String eMail1) {
        this.contactSponsorID = contactSponsorID;
        this.phone1 = phone1;
        this.eMail1 = eMail1;
    }

    public Integer getContactSponsorID() {
        return contactSponsorID;
    }

    public void setContactSponsorID(Integer contactSponsorID) {
        this.contactSponsorID = contactSponsorID;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEMail1() {
        return eMail1;
    }

    public void setEMail1(String eMail1) {
        this.eMail1 = eMail1;
    }

    public String getEMail2() {
        return eMail2;
    }

    public void setEMail2(String eMail2) {
        this.eMail2 = eMail2;
    }

    public Sponsor getSponsorID() {
        return sponsorID;
    }

    public void setSponsorID(Sponsor sponsorID) {
        this.sponsorID = sponsorID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactSponsorID != null ? contactSponsorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactSponsor)) {
            return false;
        }
        ContactSponsor other = (ContactSponsor) object;
        if ((this.contactSponsorID == null && other.contactSponsorID != null) || (this.contactSponsorID != null && !this.contactSponsorID.equals(other.contactSponsorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.ContactSponsor[ contactSponsorID=" + contactSponsorID + " ]";
    }
    
}

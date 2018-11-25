/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author darda
 */
@Entity
@Table(name = "Sponsor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sponsor.findAll", query = "SELECT s FROM Sponsor s")
    , @NamedQuery(name = "Sponsor.findBySponsorID", query = "SELECT s FROM Sponsor s WHERE s.sponsorID = :sponsorID")
    , @NamedQuery(name = "Sponsor.findBySponsorName", query = "SELECT s FROM Sponsor s WHERE s.sponsorName = :sponsorName")
    , @NamedQuery(name = "Sponsor.findBySponsorCompany", query = "SELECT s FROM Sponsor s WHERE s.sponsorCompany = :sponsorCompany")})
public class Sponsor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sponsorID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer sponsorID;
    @Basic(optional = false)
    @Column(name = "sponsorName")
    private String sponsorName;
    @Basic(optional = false)
    @Column(name = "sponsorCompany")
    private String sponsorCompany;
    @OneToMany(mappedBy = "sponsorID")
    private Collection<ContactSponsor> contactSponsorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sponsorID")
    private Collection<Event> eventCollection;

    public Sponsor() {
    }

    public Sponsor(Integer sponsorID) {
        this.sponsorID = sponsorID;
    }

    public Sponsor(Integer sponsorID, String sponsorName, String sponsorCompany) {
        this.sponsorID = sponsorID;
        this.sponsorName = sponsorName;
        this.sponsorCompany = sponsorCompany;
    }

    public Integer getSponsorID() {
        return sponsorID;
    }

    public void setSponsorID(Integer sponsorID) {
        this.sponsorID = sponsorID;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getSponsorCompany() {
        return sponsorCompany;
    }

    public void setSponsorCompany(String sponsorCompany) {
        this.sponsorCompany = sponsorCompany;
    }

    @XmlTransient
    public Collection<ContactSponsor> getContactSponsorCollection() {
        return contactSponsorCollection;
    }

    public void setContactSponsorCollection(Collection<ContactSponsor> contactSponsorCollection) {
        this.contactSponsorCollection = contactSponsorCollection;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sponsorID != null ? sponsorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sponsor)) {
            return false;
        }
        Sponsor other = (Sponsor) object;
        if ((this.sponsorID == null && other.sponsorID != null) || (this.sponsorID != null && !this.sponsorID.equals(other.sponsorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Sponsor[ sponsorID=" + sponsorID + " ]";
    }
    
}

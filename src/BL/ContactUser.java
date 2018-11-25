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
@Table(name = "ContactUser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactUser.findAll", query = "SELECT c FROM ContactUser c")
    , @NamedQuery(name = "ContactUser.findByContactUserID", query = "SELECT c FROM ContactUser c WHERE c.contactUserID = :contactUserID")
    , @NamedQuery(name = "ContactUser.findByPhoneNo1", query = "SELECT c FROM ContactUser c WHERE c.phoneNo1 = :phoneNo1")
    , @NamedQuery(name = "ContactUser.findByEmail1", query = "SELECT c FROM ContactUser c WHERE c.email1 = :email1")
    , @NamedQuery(name = "ContactUser.findByPhoneNo2", query = "SELECT c FROM ContactUser c WHERE c.phoneNo2 = :phoneNo2")
    , @NamedQuery(name = "ContactUser.findByEmail2", query = "SELECT c FROM ContactUser c WHERE c.email2 = :email2")})
public class ContactUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "contactUserID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer contactUserID;
    @Column(name = "phoneNo1")
    private String phoneNo1;
    @Basic(optional = false)
    @Column(name = "email1")
    private String email1;
    @Column(name = "phoneNo2")
    private String phoneNo2;
    @Column(name = "email2")
    private String email2;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private Users userID;

    public ContactUser() {
    }

    public ContactUser(Integer contactUserID) {
        this.contactUserID = contactUserID;
    }

    public ContactUser(Integer contactUserID, String email1) {
        this.contactUserID = contactUserID;
        this.email1 = email1;
    }

    public Integer getContactUserID() {
        return contactUserID;
    }

    public void setContactUserID(Integer contactUserID) {
        this.contactUserID = contactUserID;
    }

    public String getPhoneNo1() {
        return phoneNo1;
    }

    public void setPhoneNo1(String phoneNo1) {
        this.phoneNo1 = phoneNo1;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPhoneNo2() {
        return phoneNo2;
    }

    public void setPhoneNo2(String phoneNo2) {
        this.phoneNo2 = phoneNo2;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactUserID != null ? contactUserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactUser)) {
            return false;
        }
        ContactUser other = (ContactUser) object;
        if ((this.contactUserID == null && other.contactUserID != null) || (this.contactUserID != null && !this.contactUserID.equals(other.contactUserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.ContactUser[ contactUserID=" + contactUserID + " ]";
    }
    
}

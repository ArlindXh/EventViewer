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
@Table(name = "SubCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubCategory.findAll", query = "SELECT s FROM SubCategory s")
    , @NamedQuery(name = "SubCategory.findBySubCategoryID", query = "SELECT s FROM SubCategory s WHERE s.subCategoryID = :subCategoryID")
    , @NamedQuery(name = "SubCategory.findBySubCategryName", query = "SELECT s FROM SubCategory s WHERE s.subCategryName = :subCategryName")})
public class SubCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "subCategoryID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer subCategoryID;
    @Basic(optional = false)
    @Column(name = "subCategryName")
    private String subCategryName;
    @JoinColumn(name = "eventCategoryID", referencedColumnName = "eventCategoryID")
    @ManyToOne(optional = false)
    private EventCategory eventCategoryID;

    public SubCategory() {
    }

    public SubCategory(Integer subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public SubCategory(Integer subCategoryID, String subCategryName) {
        this.subCategoryID = subCategoryID;
        this.subCategryName = subCategryName;
    }

    public Integer getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(Integer subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getSubCategryName() {
        return subCategryName;
    }

    public void setSubCategryName(String subCategryName) {
        this.subCategryName = subCategryName;
    }

    public EventCategory getEventCategoryID() {
        return eventCategoryID;
    }

    public void setEventCategoryID(EventCategory eventCategoryID) {
        this.eventCategoryID = eventCategoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subCategoryID != null ? subCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCategory)) {
            return false;
        }
        SubCategory other = (SubCategory) object;
        if ((this.subCategoryID == null && other.subCategoryID != null) || (this.subCategoryID != null && !this.subCategoryID.equals(other.subCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.SubCategory[ subCategoryID=" + subCategoryID + " ]";
    }
    
}

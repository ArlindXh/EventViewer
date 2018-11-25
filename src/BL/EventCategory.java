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
@Table(name = "EventCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventCategory.findAll", query = "SELECT e FROM EventCategory e")
    , @NamedQuery(name = "EventCategory.findByEventCategoryID", query = "SELECT e FROM EventCategory e WHERE e.eventCategoryID = :eventCategoryID")
    , @NamedQuery(name = "EventCategory.findByCategoryName", query = "SELECT e FROM EventCategory e WHERE e.categoryName = :categoryName")
    , @NamedQuery(name = "EventCategory.findByDescription", query = "SELECT e FROM EventCategory e WHERE e.description = :description")})
public class EventCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eventCategoryID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer eventCategoryID;
    @Basic(optional = false)
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventCategoryID")
    private Collection<SubCategory> subCategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventCategoryID")
    private Collection<Event> eventCollection;

    public EventCategory() {
    }

    public EventCategory(Integer eventCategoryID) {
        this.eventCategoryID = eventCategoryID;
    }

    public EventCategory(Integer eventCategoryID, String categoryName) {
        this.eventCategoryID = eventCategoryID;
        this.categoryName = categoryName;
    }

    public Integer getEventCategoryID() {
        return eventCategoryID;
    }

    public void setEventCategoryID(Integer eventCategoryID) {
        this.eventCategoryID = eventCategoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<SubCategory> getSubCategoryCollection() {
        return subCategoryCollection;
    }

    public void setSubCategoryCollection(Collection<SubCategory> subCategoryCollection) {
        this.subCategoryCollection = subCategoryCollection;
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
        hash += (eventCategoryID != null ? eventCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventCategory)) {
            return false;
        }
        EventCategory other = (EventCategory) object;
        if ((this.eventCategoryID == null && other.eventCategoryID != null) || (this.eventCategoryID != null && !this.eventCategoryID.equals(other.eventCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return categoryName;
    }
    
}

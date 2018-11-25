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
@Table(name = "EventLocation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventLocation.findAll", query = "SELECT e FROM EventLocation e")
    , @NamedQuery(name = "EventLocation.findByEventLocationID", query = "SELECT e FROM EventLocation e WHERE e.eventLocationID = :eventLocationID")
    , @NamedQuery(name = "EventLocation.findByStreet", query = "SELECT e FROM EventLocation e WHERE e.street = :street")
    , @NamedQuery(name = "EventLocation.findByDescription", query = "SELECT e FROM EventLocation e WHERE e.description = :description")})
public class EventLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eventLocationID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer eventLocationID;
    @Basic(optional = false)
    @Column(name = "street")
    private String street;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "cityID", referencedColumnName = "CityID")
    @ManyToOne(optional = false)
    private City cityID;
    @JoinColumn(name = "eventID", referencedColumnName = "eventID")
    @ManyToOne(optional = false)
    private Event eventID;

    public EventLocation() {
    }

    public EventLocation(Integer eventLocationID) {
        this.eventLocationID = eventLocationID;
    }

    public EventLocation(Integer eventLocationID, String street) {
        this.eventLocationID = eventLocationID;
        this.street = street;
    }

    public Integer getEventLocationID() {
        return eventLocationID;
    }

    public void setEventLocationID(Integer eventLocationID) {
        this.eventLocationID = eventLocationID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    public Event getEventID() {
        return eventID;
    }

    public void setEventID(Event eventID) {
        this.eventID = eventID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventLocationID != null ? eventLocationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventLocation)) {
            return false;
        }
        EventLocation other = (EventLocation) object;
        if ((this.eventLocationID == null && other.eventLocationID != null) || (this.eventLocationID != null && !this.eventLocationID.equals(other.eventLocationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.EventLocation[ eventLocationID=" + eventLocationID + " ]";
    }
    
}

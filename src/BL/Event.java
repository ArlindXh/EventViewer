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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findByEventID", query = "SELECT e FROM Event e WHERE e.eventID = :eventID")
    , @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName")
    , @NamedQuery(name = "Event.findByEventCapacity", query = "SELECT e FROM Event e WHERE e.eventCapacity = :eventCapacity")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eventID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer eventID;
    @Basic(optional = false)
    @Column(name = "eventName")
    private String eventName;
    @Column(name = "eventCapacity")
    private Integer eventCapacity;
    @OneToMany(mappedBy = "eventID")
    private Collection<EventImages> eventImagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private Collection<Report> reportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private Collection<EventLocation> eventLocationCollection;
    @OneToMany(mappedBy = "eventID")
    private Collection<EventSchedule> eventScheduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private Collection<EventUsers> eventUsersCollection;
    @JoinColumn(name = "eventCategoryID", referencedColumnName = "eventCategoryID")
    @ManyToOne(optional = false)
    private EventCategory eventCategoryID;
    @JoinColumn(name = "eventEntryType", referencedColumnName = "eventTypeID")
    @ManyToOne
    private EventEntryType eventEntryType;
    @JoinColumn(name = "sponsorID", referencedColumnName = "sponsorID")
    @ManyToOne(optional = false)
    private Sponsor sponsorID;

    public Event() {
    }

    public Event(Integer eventID) {
        this.eventID = eventID;
    }

    public Event(Integer eventID, String eventName) {
        this.eventID = eventID;
        this.eventName = eventName;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getEventCapacity() {
        return eventCapacity;
    }

    public void setEventCapacity(Integer eventCapacity) {
        this.eventCapacity = eventCapacity;
    }

    @XmlTransient
    public Collection<EventImages> getEventImagesCollection() {
        return eventImagesCollection;
    }

    public void setEventImagesCollection(Collection<EventImages> eventImagesCollection) {
        this.eventImagesCollection = eventImagesCollection;
    }

    @XmlTransient
    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    @XmlTransient
    public Collection<EventLocation> getEventLocationCollection() {
        return eventLocationCollection;
    }

    public void setEventLocationCollection(Collection<EventLocation> eventLocationCollection) {
        this.eventLocationCollection = eventLocationCollection;
    }

    @XmlTransient
    public Collection<EventSchedule> getEventScheduleCollection() {
        return eventScheduleCollection;
    }

    public void setEventScheduleCollection(Collection<EventSchedule> eventScheduleCollection) {
        this.eventScheduleCollection = eventScheduleCollection;
    }

    @XmlTransient
    public Collection<EventUsers> getEventUsersCollection() {
        return eventUsersCollection;
    }

    public void setEventUsersCollection(Collection<EventUsers> eventUsersCollection) {
        this.eventUsersCollection = eventUsersCollection;
    }

    public EventCategory getEventCategoryID() {
        return eventCategoryID;
    }

    public void setEventCategoryID(EventCategory eventCategoryID) {
        this.eventCategoryID = eventCategoryID;
    }

    public EventEntryType getEventEntryType() {
        return eventEntryType;
    }

    public void setEventEntryType(EventEntryType eventEntryType) {
        this.eventEntryType = eventEntryType;
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
        hash += (eventID != null ? eventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventID == null && other.eventID != null) || (this.eventID != null && !this.eventID.equals(other.eventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Event[ eventID=" + eventID + " ]";
    }
    
}

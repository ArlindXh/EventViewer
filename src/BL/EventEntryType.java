/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "EventEntryType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventEntryType.findAll", query = "SELECT e FROM EventEntryType e")
    , @NamedQuery(name = "EventEntryType.findByEventTypeID", query = "SELECT e FROM EventEntryType e WHERE e.eventTypeID = :eventTypeID")
    , @NamedQuery(name = "EventEntryType.findByEventTypeName", query = "SELECT e FROM EventEntryType e WHERE e.eventTypeName = :eventTypeName")
    , @NamedQuery(name = "EventEntryType.findByDescription", query = "SELECT e FROM EventEntryType e WHERE e.description = :description")})
public class EventEntryType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eventTypeID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer eventTypeID;
    @Basic(optional = false)
    @Column(name = "eventTypeName")
    private String eventTypeName;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "eventEntryType")
    private Collection<Event> eventCollection;
    @OneToMany(mappedBy = "eventEntryTypeID")
    private Collection<EventRules> eventRulesCollection;
    @JoinColumn(name = "eventPaymentID", referencedColumnName = "paymentID")
    @ManyToOne
    private EventPayment eventPaymentID;

    public EventEntryType() {
    }

    public EventEntryType(Integer eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public EventEntryType(Integer eventTypeID, String eventTypeName) {
        this.eventTypeID = eventTypeID;
        this.eventTypeName = eventTypeName;
    }

    public Integer getEventTypeID() {
        return eventTypeID;
    }

    public void setEventTypeID(Integer eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @XmlTransient
    public Collection<EventRules> getEventRulesCollection() {
        return eventRulesCollection;
    }

    public void setEventRulesCollection(Collection<EventRules> eventRulesCollection) {
        this.eventRulesCollection = eventRulesCollection;
    }

    public EventPayment getEventPaymentID() {
        return eventPaymentID;
    }

    public void setEventPaymentID(EventPayment eventPaymentID) {
        this.eventPaymentID = eventPaymentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventTypeID != null ? eventTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventEntryType)) {
            return false;
        }
        EventEntryType other = (EventEntryType) object;
        if ((this.eventTypeID == null && other.eventTypeID != null) || (this.eventTypeID != null && !this.eventTypeID.equals(other.eventTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.EventEntryType[ eventTypeID=" + eventTypeID + " ]";
    }
    
}

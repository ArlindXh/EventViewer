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
@Table(name = "EventRules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventRules.findAll", query = "SELECT e FROM EventRules e")
    , @NamedQuery(name = "EventRules.findByEventRuleID", query = "SELECT e FROM EventRules e WHERE e.eventRuleID = :eventRuleID")
    , @NamedQuery(name = "EventRules.findByDescription", query = "SELECT e FROM EventRules e WHERE e.description = :description")})
public class EventRules implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eventRuleID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer eventRuleID;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "eventEntryTypeID", referencedColumnName = "eventTypeID")
    @ManyToOne
    private EventEntryType eventEntryTypeID;

    public EventRules() {
    }

    public EventRules(Integer eventRuleID) {
        this.eventRuleID = eventRuleID;
    }

    public EventRules(Integer eventRuleID, String description) {
        this.eventRuleID = eventRuleID;
        this.description = description;
    }

    public Integer getEventRuleID() {
        return eventRuleID;
    }

    public void setEventRuleID(Integer eventRuleID) {
        this.eventRuleID = eventRuleID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventEntryType getEventEntryTypeID() {
        return eventEntryTypeID;
    }

    public void setEventEntryTypeID(EventEntryType eventEntryTypeID) {
        this.eventEntryTypeID = eventEntryTypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventRuleID != null ? eventRuleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventRules)) {
            return false;
        }
        EventRules other = (EventRules) object;
        if ((this.eventRuleID == null && other.eventRuleID != null) || (this.eventRuleID != null && !this.eventRuleID.equals(other.eventRuleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.EventRules[ eventRuleID=" + eventRuleID + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author darda
 */
@Entity
@Table(name = "EventSchedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventSchedule.findAll", query = "SELECT e FROM EventSchedule e")
    , @NamedQuery(name = "EventSchedule.findByScheduleID", query = "SELECT e FROM EventSchedule e WHERE e.scheduleID = :scheduleID")
    , @NamedQuery(name = "EventSchedule.findByStartDate", query = "SELECT e FROM EventSchedule e WHERE e.startDate = :startDate")
    , @NamedQuery(name = "EventSchedule.findByEndDate", query = "SELECT e FROM EventSchedule e WHERE e.endDate = :endDate")})
public class EventSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "scheduleID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer scheduleID;
    @Basic(optional = false)
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "eventID", referencedColumnName = "eventID")
    @ManyToOne
    private Event eventID;

    public EventSchedule() {
    }

    public EventSchedule(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

    public EventSchedule(Integer scheduleID, Date startDate, Date endDate) {
        this.scheduleID = scheduleID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        hash += (scheduleID != null ? scheduleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventSchedule)) {
            return false;
        }
        EventSchedule other = (EventSchedule) object;
        if ((this.scheduleID == null && other.scheduleID != null) || (this.scheduleID != null && !this.scheduleID.equals(other.scheduleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.EventSchedule[ scheduleID=" + scheduleID + " ]";
    }
    
}

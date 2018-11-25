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
@Table(name = "Event_Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventUsers.findAll", query = "SELECT e FROM EventUsers e")
    , @NamedQuery(name = "EventUsers.findByEuID", query = "SELECT e FROM EventUsers e WHERE e.euID = :euID")})
public class EventUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "euID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer euID;
    @JoinColumn(name = "eventID", referencedColumnName = "eventID")
    @ManyToOne(optional = false)
    private Event eventID;
    @JoinColumn(name = "usersID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private Users usersID;

    public EventUsers() {
    }

    public EventUsers(Integer euID) {
        this.euID = euID;
    }

    public Integer getEuID() {
        return euID;
    }

    public void setEuID(Integer euID) {
        this.euID = euID;
    }

    public Event getEventID() {
        return eventID;
    }

    public void setEventID(Event eventID) {
        this.eventID = eventID;
    }

    public Users getUsersID() {
        return usersID;
    }

    public void setUsersID(Users usersID) {
        this.usersID = usersID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (euID != null ? euID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventUsers)) {
            return false;
        }
        EventUsers other = (EventUsers) object;
        if ((this.euID == null && other.euID != null) || (this.euID != null && !this.euID.equals(other.euID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.EventUsers[ euID=" + euID + " ]";
    }
    
}

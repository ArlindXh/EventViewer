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
import javax.persistence.Lob;
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
@Table(name = "EventImages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventImages.findAll", query = "SELECT e FROM EventImages e")
    , @NamedQuery(name = "EventImages.findByImageID", query = "SELECT e FROM EventImages e WHERE e.imageID = :imageID")})
public class EventImages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "imageID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer imageID;
    @Basic(optional = false)
    @Lob
    @Column(name = "eventImage")
    private byte[] eventImage;
    @JoinColumn(name = "eventID", referencedColumnName = "eventID")
    @ManyToOne
    private Event eventID;

    public EventImages() {
    }

    public EventImages(Integer imageID) {
        this.imageID = imageID;
    }

    public EventImages(Integer imageID, byte[] eventImage) {
        this.imageID = imageID;
        this.eventImage = eventImage;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public byte[] getEventImage() {
        return eventImage;
    }

    public void setEventImage(byte[] eventImage) {
        this.eventImage = eventImage;
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
        hash += (imageID != null ? imageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventImages)) {
            return false;
        }
        EventImages other = (EventImages) object;
        if ((this.imageID == null && other.imageID != null) || (this.imageID != null && !this.imageID.equals(other.imageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.EventImages[ imageID=" + imageID + " ]";
    }
    
}

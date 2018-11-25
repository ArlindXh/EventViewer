/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "EventPayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventPayment.findAll", query = "SELECT e FROM EventPayment e")
    , @NamedQuery(name = "EventPayment.findByPaymentID", query = "SELECT e FROM EventPayment e WHERE e.paymentID = :paymentID")
    , @NamedQuery(name = "EventPayment.findByPrice", query = "SELECT e FROM EventPayment e WHERE e.price = :price")
    , @NamedQuery(name = "EventPayment.findByPaymentType", query = "SELECT e FROM EventPayment e WHERE e.paymentType = :paymentType")})
public class EventPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "paymentID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer paymentID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "paymentType")
    private String paymentType;
    @OneToMany(mappedBy = "eventPaymentID")
    private Collection<EventEntryType> eventEntryTypeCollection;

    public EventPayment() {
    }

    public EventPayment(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public EventPayment(Integer paymentID, BigDecimal price, String paymentType) {
        this.paymentID = paymentID;
        this.price = price;
        this.paymentType = paymentType;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @XmlTransient
    public Collection<EventEntryType> getEventEntryTypeCollection() {
        return eventEntryTypeCollection;
    }

    public void setEventEntryTypeCollection(Collection<EventEntryType> eventEntryTypeCollection) {
        this.eventEntryTypeCollection = eventEntryTypeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentID != null ? paymentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventPayment)) {
            return false;
        }
        EventPayment other = (EventPayment) object;
        if ((this.paymentID == null && other.paymentID != null) || (this.paymentID != null && !this.paymentID.equals(other.paymentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.EventPayment[ paymentID=" + paymentID + " ]";
    }
    
}

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
@Table(name = "City")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
    , @NamedQuery(name = "City.findByCityID", query = "SELECT c FROM City c WHERE c.cityID = :cityID")
    , @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")
    , @NamedQuery(name = "City.findByZipCode", query = "SELECT c FROM City c WHERE c.zipCode = :zipCode")})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CityID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer cityID;
    @Basic(optional = false)
    @Column(name = "CityName")
    private String cityName;
    @Basic(optional = false)
    @Column(name = "ZipCode")
    private String zipCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<EventLocation> eventLocationCollection;
    @JoinColumn(name = "CountryID", referencedColumnName = "CountryID")
    @ManyToOne(optional = false)
    private Country countryID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<Users> usersCollection;

    public City() {
    }

    public City(Integer cityID) {
        this.cityID = cityID;
    }

    public City(Integer cityID, String cityName, String zipCode) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @XmlTransient
    public Collection<EventLocation> getEventLocationCollection() {
        return eventLocationCollection;
    }

    public void setEventLocationCollection(Collection<EventLocation> eventLocationCollection) {
        this.eventLocationCollection = eventLocationCollection;
    }

    public Country getCountryID() {
        return countryID;
    }

    public void setCountryID(Country countryID) {
        this.countryID = countryID;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityID != null ? cityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityID == null && other.cityID != null) || (this.cityID != null && !this.cityID.equals(other.cityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.City[ cityID=" + cityID + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author darda
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUserID", query = "SELECT u FROM Users u WHERE u.userID = :userID")
    , @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName")
    , @NamedQuery(name = "Users.findByBirthDate", query = "SELECT u FROM Users u WHERE u.birthDate = :birthDate")
    , @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender")
    , @NamedQuery(name = "Users.findByContactUserID", query = "SELECT u FROM Users u WHERE u.contactUserID = :contactUserID")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    @Column(name = "userID")
    private Integer userID;
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @Column(name = "gender")
    private Character gender;
    @Basic(optional = false)
    @Column(name = "contactUserID")
    private int contactUserID;
    @JoinColumn(name = "cityID", referencedColumnName = "CityID")
    @ManyToOne(optional = false)
    private City cityID;
    @JoinColumn(name = "roleID", referencedColumnName = "RoleID")
    @ManyToOne(optional = false)
    private Role roleID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<ContactUser> contactUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersID")
    private Collection<EventUsers> eventUsersCollection;

    public Users() {
    }

    public Users(Integer userID) {
        this.userID = userID;
    }

    public Users(Integer userID, String userName, String password, String firstName, String lastName, Date birthDate, Character gender, int contactUserID) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.contactUserID = contactUserID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public int getContactUserID() {
        return contactUserID;
    }

    public void setContactUserID(int contactUserID) {
        this.contactUserID = contactUserID;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

    @XmlTransient
    public Collection<ContactUser> getContactUserCollection() {
        return contactUserCollection;
    }

    public void setContactUserCollection(Collection<ContactUser> contactUserCollection) {
        this.contactUserCollection = contactUserCollection;
    }

    @XmlTransient
    public Collection<EventUsers> getEventUsersCollection() {
        return eventUsersCollection;
    }

    public void setEventUsersCollection(Collection<EventUsers> eventUsersCollection) {
        this.eventUsersCollection = eventUsersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Users[ userID=" + userID + " ]";
    }
    
}

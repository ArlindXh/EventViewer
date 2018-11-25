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
@Table(name = "Role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByRoleID", query = "SELECT r FROM Role r WHERE r.roleID = :roleID")
    , @NamedQuery(name = "Role.findByType", query = "SELECT r FROM Role r WHERE r.type = :type")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    @Column(name = "RoleID")
    private Integer roleID;
    @Basic(optional = false)
    @Column(name = "Type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID")
    private Collection<Users> usersCollection;

    public Role() {
    }

    public Role(Integer roleID) {
        this.roleID = roleID;
    }

    public Role(Integer roleID, String type) {
        this.roleID = roleID;
        this.type = type;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Role[ roleID=" + roleID + " ]";
    }
    
}

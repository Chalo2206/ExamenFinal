/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMR.Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "User_Registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRegistration.findAll", query = "SELECT u FROM UserRegistration u")
    , @NamedQuery(name = "UserRegistration.findById", query = "SELECT u FROM UserRegistration u WHERE u.id = :id")
    , @NamedQuery(name = "UserRegistration.findByUserID", query = "SELECT u FROM UserRegistration u WHERE u.userID = :userID")
    , @NamedQuery(name = "UserRegistration.findByPassword", query = "SELECT u FROM UserRegistration u WHERE u.password = :password")
    , @NamedQuery(name = "UserRegistration.findByName", query = "SELECT u FROM UserRegistration u WHERE u.name = :name")
    , @NamedQuery(name = "UserRegistration.findByContactNo", query = "SELECT u FROM UserRegistration u WHERE u.contactNo = :contactNo")
    , @NamedQuery(name = "UserRegistration.findByEmail", query = "SELECT u FROM UserRegistration u WHERE u.email = :email")
    , @NamedQuery(name = "UserRegistration.findByDateofjoining", query = "SELECT u FROM UserRegistration u WHERE u.dateofjoining = :dateofjoining")
    , @NamedQuery(name = "UserRegistration.findByUsertype", query = "SELECT u FROM UserRegistration u WHERE u.usertype = :usertype")})
public class UserRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "UserID")
    private String userID;
    @Column(name = "Password")
    private String password;
    @Column(name = "Name")
    private String name;
    @Column(name = "Contact_No")
    private String contactNo;
    @Column(name = "Email")
    private String email;
    @Column(name = "Date_of_joining")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofjoining;
    @Column(name = "usertype")
    private String usertype;

    public UserRegistration() {
    }

    public UserRegistration(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(Date dateofjoining) {
        this.dateofjoining = dateofjoining;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRegistration)) {
            return false;
        }
        UserRegistration other = (UserRegistration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CMR.Modelo.UserRegistration[ id=" + id + " ]";
    }
    
}

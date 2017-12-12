/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMR.Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
    , @NamedQuery(name = "Contact.findById", query = "SELECT c FROM Contact c WHERE c.id = :id")
    , @NamedQuery(name = "Contact.findByContactName", query = "SELECT c FROM Contact c WHERE c.contactName = :contactName")
    , @NamedQuery(name = "Contact.findByMob", query = "SELECT c FROM Contact c WHERE c.mob = :mob")
    , @NamedQuery(name = "Contact.findByPostalcode", query = "SELECT c FROM Contact c WHERE c.postalcode = :postalcode")
    , @NamedQuery(name = "Contact.findByCity", query = "SELECT c FROM Contact c WHERE c.city = :city")
    , @NamedQuery(name = "Contact.findByCountry", query = "SELECT c FROM Contact c WHERE c.country = :country")
    , @NamedQuery(name = "Contact.findByState", query = "SELECT c FROM Contact c WHERE c.state = :state")
    , @NamedQuery(name = "Contact.findByTitle", query = "SELECT c FROM Contact c WHERE c.title = :title")
    , @NamedQuery(name = "Contact.findByRole", query = "SELECT c FROM Contact c WHERE c.role = :role")
    , @NamedQuery(name = "Contact.findByNotes", query = "SELECT c FROM Contact c WHERE c.notes = :notes")
    , @NamedQuery(name = "Contact.findByCompany", query = "SELECT c FROM Contact c WHERE c.company = :company")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "ContactName")
    private String contactName;
    @Column(name = "Mob")
    private String mob;
    @Column(name = "Postalcode")
    private Integer postalcode;
    @Column(name = "City")
    private String city;
    @Column(name = "Country")
    private String country;
    @Column(name = "State")
    private String state;
    @Column(name = "Title")
    private String title;
    @Column(name = "Role")
    private String role;
    @Column(name = "notes")
    private String notes;
    @Column(name = "Company")
    private String company;

    public Contact() {
    }

    public Contact(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CMR.Modelo.Contact[ id=" + id + " ]";
    }
    
}

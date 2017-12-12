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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "Activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a")
    , @NamedQuery(name = "Activity.findById", query = "SELECT a FROM Activity a WHERE a.id = :id")
    , @NamedQuery(name = "Activity.findByDates", query = "SELECT a FROM Activity a WHERE a.dates = :dates")
    , @NamedQuery(name = "Activity.findByTimes", query = "SELECT a FROM Activity a WHERE a.times = :times")
    , @NamedQuery(name = "Activity.findByContactID", query = "SELECT a FROM Activity a WHERE a.contactID = :contactID")
    , @NamedQuery(name = "Activity.findByAssignedTo", query = "SELECT a FROM Activity a WHERE a.assignedTo = :assignedTo")
    , @NamedQuery(name = "Activity.findByActivityType", query = "SELECT a FROM Activity a WHERE a.activityType = :activityType")
    , @NamedQuery(name = "Activity.findByStatus", query = "SELECT a FROM Activity a WHERE a.status = :status")
    , @NamedQuery(name = "Activity.findBySubject", query = "SELECT a FROM Activity a WHERE a.subject = :subject")
    , @NamedQuery(name = "Activity.findByNotes", query = "SELECT a FROM Activity a WHERE a.notes = :notes")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Dates")
    private String dates;
    @Column(name = "Times")
    private String times;
    @Column(name = "ContactID")
    private Integer contactID;
    @Column(name = "AssignedTo")
    private String assignedTo;
    @Column(name = "ActivityType")
    private String activityType;
    @Column(name = "Status")
    private String status;
    @Column(name = "Subject")
    private String subject;
    @Column(name = "Notes")
    private String notes;
    @JoinColumn(name = "StaffID", referencedColumnName = "StaffID")
    @ManyToOne
    private Employee staffID;

    public Activity() {
    }

    public Activity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Integer getContactID() {
        return contactID;
    }

    public void setContactID(Integer contactID) {
        this.contactID = contactID;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee getStaffID() {
        return staffID;
    }

    public void setStaffID(Employee staffID) {
        this.staffID = staffID;
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
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CMR.Modelo.Activity[ id=" + id + " ]";
    }
    
}

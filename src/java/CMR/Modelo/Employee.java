/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMR.Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByStaffID", query = "SELECT e FROM Employee e WHERE e.staffID = :staffID")
    , @NamedQuery(name = "Employee.findByStaffName", query = "SELECT e FROM Employee e WHERE e.staffName = :staffName")
    , @NamedQuery(name = "Employee.findByFatherName", query = "SELECT e FROM Employee e WHERE e.fatherName = :fatherName")
    , @NamedQuery(name = "Employee.findByMotherName", query = "SELECT e FROM Employee e WHERE e.motherName = :motherName")
    , @NamedQuery(name = "Employee.findByDob", query = "SELECT e FROM Employee e WHERE e.dob = :dob")
    , @NamedQuery(name = "Employee.findByPermanentAddress", query = "SELECT e FROM Employee e WHERE e.permanentAddress = :permanentAddress")
    , @NamedQuery(name = "Employee.findByTemporaryAddress", query = "SELECT e FROM Employee e WHERE e.temporaryAddress = :temporaryAddress")
    , @NamedQuery(name = "Employee.findByPhoneNo", query = "SELECT e FROM Employee e WHERE e.phoneNo = :phoneNo")
    , @NamedQuery(name = "Employee.findByMobileNo", query = "SELECT e FROM Employee e WHERE e.mobileNo = :mobileNo")
    , @NamedQuery(name = "Employee.findByDateOfJoining", query = "SELECT e FROM Employee e WHERE e.dateOfJoining = :dateOfJoining")
    , @NamedQuery(name = "Employee.findByQualification", query = "SELECT e FROM Employee e WHERE e.qualification = :qualification")
    , @NamedQuery(name = "Employee.findByYearOfExperience", query = "SELECT e FROM Employee e WHERE e.yearOfExperience = :yearOfExperience")
    , @NamedQuery(name = "Employee.findByDesignation", query = "SELECT e FROM Employee e WHERE e.designation = :designation")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByStatus", query = "SELECT e FROM Employee e WHERE e.status = :status")
    , @NamedQuery(name = "Employee.findByBasicSalary", query = "SELECT e FROM Employee e WHERE e.basicSalary = :basicSalary")
    , @NamedQuery(name = "Employee.findByDepartment", query = "SELECT e FROM Employee e WHERE e.department = :department")
    , @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "StaffID")
    private String staffID;
    @Column(name = "StaffName")
    private String staffName;
    @Column(name = "FatherName")
    private String fatherName;
    @Column(name = "MotherName")
    private String motherName;
    @Column(name = "DOB")
    private String dob;
    @Column(name = "PermanentAddress")
    private String permanentAddress;
    @Column(name = "TemporaryAddress")
    private String temporaryAddress;
    @Column(name = "PhoneNo")
    private String phoneNo;
    @Column(name = "MobileNo")
    private String mobileNo;
    @Column(name = "DateOfJoining")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;
    @Column(name = "Qualification")
    private String qualification;
    @Column(name = "YearOfExperience")
    private String yearOfExperience;
    @Column(name = "Designation")
    private String designation;
    @Column(name = "Email")
    private String email;
    @Lob
    @Column(name = "Picture")
    private byte[] picture;
    @Column(name = "Status")
    private String status;
    @Column(name = "BasicSalary")
    private Integer basicSalary;
    @Column(name = "Department")
    private String department;
    @Column(name = "Gender")
    private String gender;
    @OneToMany(mappedBy = "staffID")
    private List<Activity> activityList;

    public Employee() {
    }

    public Employee(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(String yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @XmlTransient
    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffID != null ? staffID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.staffID == null && other.staffID != null) || (this.staffID != null && !this.staffID.equals(other.staffID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CMR.Modelo.Employee[ staffID=" + staffID + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMR.Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByUserID", query = "SELECT c FROM Client c WHERE c.userID = :userID")
    , @NamedQuery(name = "Client.findByFirstName", query = "SELECT c FROM Client c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "Client.findByLastName", query = "SELECT c FROM Client c WHERE c.lastName = :lastName")
    , @NamedQuery(name = "Client.findByClientType", query = "SELECT c FROM Client c WHERE c.clientType = :clientType")
    , @NamedQuery(name = "Client.findByHStreet", query = "SELECT c FROM Client c WHERE c.hStreet = :hStreet")
    , @NamedQuery(name = "Client.findByHCity", query = "SELECT c FROM Client c WHERE c.hCity = :hCity")
    , @NamedQuery(name = "Client.findByHState", query = "SELECT c FROM Client c WHERE c.hState = :hState")
    , @NamedQuery(name = "Client.findByHZip", query = "SELECT c FROM Client c WHERE c.hZip = :hZip")
    , @NamedQuery(name = "Client.findByHCountry", query = "SELECT c FROM Client c WHERE c.hCountry = :hCountry")
    , @NamedQuery(name = "Client.findByIDType", query = "SELECT c FROM Client c WHERE c.iDType = :iDType")
    , @NamedQuery(name = "Client.findByIDNo", query = "SELECT c FROM Client c WHERE c.iDNo = :iDNo")
    , @NamedQuery(name = "Client.findByExpDate", query = "SELECT c FROM Client c WHERE c.expDate = :expDate")
    , @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone")
    , @NamedQuery(name = "Client.findByMobile", query = "SELECT c FROM Client c WHERE c.mobile = :mobile")
    , @NamedQuery(name = "Client.findByFaxNo", query = "SELECT c FROM Client c WHERE c.faxNo = :faxNo")
    , @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email")
    , @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id")
    , @NamedQuery(name = "Client.findByWStreet", query = "SELECT c FROM Client c WHERE c.wStreet = :wStreet")
    , @NamedQuery(name = "Client.findByWCity", query = "SELECT c FROM Client c WHERE c.wCity = :wCity")
    , @NamedQuery(name = "Client.findByWState", query = "SELECT c FROM Client c WHERE c.wState = :wState")
    , @NamedQuery(name = "Client.findByWZip", query = "SELECT c FROM Client c WHERE c.wZip = :wZip")
    , @NamedQuery(name = "Client.findByWCountry", query = "SELECT c FROM Client c WHERE c.wCountry = :wCountry")
    , @NamedQuery(name = "Client.findByPassword", query = "SELECT c FROM Client c WHERE c.password = :password")
    , @NamedQuery(name = "Client.findByClientOfficers", query = "SELECT c FROM Client c WHERE c.clientOfficers = :clientOfficers")
    , @NamedQuery(name = "Client.findByInterestlevel", query = "SELECT c FROM Client c WHERE c.interestlevel = :interestlevel")
    , @NamedQuery(name = "Client.findByMoneyCommited", query = "SELECT c FROM Client c WHERE c.moneyCommited = :moneyCommited")
    , @NamedQuery(name = "Client.findBySecetory", query = "SELECT c FROM Client c WHERE c.secetory = :secetory")
    , @NamedQuery(name = "Client.findByIcountry", query = "SELECT c FROM Client c WHERE c.icountry = :icountry")
    , @NamedQuery(name = "Client.findByCategorization", query = "SELECT c FROM Client c WHERE c.categorization = :categorization")
    , @NamedQuery(name = "Client.findByBowner", query = "SELECT c FROM Client c WHERE c.bowner = :bowner")
    , @NamedQuery(name = "Client.findByDirectors", query = "SELECT c FROM Client c WHERE c.directors = :directors")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "UserID")
    private String userID;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "ClientType")
    private String clientType;
    @Column(name = "HStreet")
    private String hStreet;
    @Column(name = "HCity")
    private String hCity;
    @Column(name = "HState")
    private String hState;
    @Column(name = "HZip")
    private String hZip;
    @Column(name = "HCountry")
    private String hCountry;
    @Column(name = "IDType")
    private String iDType;
    @Column(name = "IDNo")
    private String iDNo;
    @Column(name = "ExpDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expDate;
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "Mobile")
    private String mobile;
    @Column(name = "FaxNo")
    private String faxNo;
    @Column(name = "Email")
    private String email;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "WStreet")
    private String wStreet;
    @Column(name = "WCity")
    private String wCity;
    @Column(name = "WState")
    private String wState;
    @Column(name = "WZip")
    private String wZip;
    @Column(name = "WCountry")
    private String wCountry;
    @Column(name = "Password")
    private String password;
    @Column(name = "ClientOfficers")
    private String clientOfficers;
    @Column(name = "Interestlevel")
    private String interestlevel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MoneyCommited")
    private BigDecimal moneyCommited;
    @Column(name = "Secetory")
    private String secetory;
    @Lob
    @Column(name = "picture")
    private byte[] picture;
    @Column(name = "Icountry")
    private String icountry;
    @Column(name = "Categorization")
    private String categorization;
    @Column(name = "Bowner")
    private String bowner;
    @Column(name = "Directors")
    private String directors;
    @OneToMany(mappedBy = "clientID")
    private List<Document> documentList;
    @OneToMany(mappedBy = "clientID")
    private List<Complaint> complaintList;
    @OneToMany(mappedBy = "clientID")
    private List<Investment> investmentList;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Client(Integer id, String userID) {
        this.id = id;
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getHStreet() {
        return hStreet;
    }

    public void setHStreet(String hStreet) {
        this.hStreet = hStreet;
    }

    public String getHCity() {
        return hCity;
    }

    public void setHCity(String hCity) {
        this.hCity = hCity;
    }

    public String getHState() {
        return hState;
    }

    public void setHState(String hState) {
        this.hState = hState;
    }

    public String getHZip() {
        return hZip;
    }

    public void setHZip(String hZip) {
        this.hZip = hZip;
    }

    public String getHCountry() {
        return hCountry;
    }

    public void setHCountry(String hCountry) {
        this.hCountry = hCountry;
    }

    public String getIDType() {
        return iDType;
    }

    public void setIDType(String iDType) {
        this.iDType = iDType;
    }

    public String getIDNo() {
        return iDNo;
    }

    public void setIDNo(String iDNo) {
        this.iDNo = iDNo;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWStreet() {
        return wStreet;
    }

    public void setWStreet(String wStreet) {
        this.wStreet = wStreet;
    }

    public String getWCity() {
        return wCity;
    }

    public void setWCity(String wCity) {
        this.wCity = wCity;
    }

    public String getWState() {
        return wState;
    }

    public void setWState(String wState) {
        this.wState = wState;
    }

    public String getWZip() {
        return wZip;
    }

    public void setWZip(String wZip) {
        this.wZip = wZip;
    }

    public String getWCountry() {
        return wCountry;
    }

    public void setWCountry(String wCountry) {
        this.wCountry = wCountry;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientOfficers() {
        return clientOfficers;
    }

    public void setClientOfficers(String clientOfficers) {
        this.clientOfficers = clientOfficers;
    }

    public String getInterestlevel() {
        return interestlevel;
    }

    public void setInterestlevel(String interestlevel) {
        this.interestlevel = interestlevel;
    }

    public BigDecimal getMoneyCommited() {
        return moneyCommited;
    }

    public void setMoneyCommited(BigDecimal moneyCommited) {
        this.moneyCommited = moneyCommited;
    }

    public String getSecetory() {
        return secetory;
    }

    public void setSecetory(String secetory) {
        this.secetory = secetory;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getIcountry() {
        return icountry;
    }

    public void setIcountry(String icountry) {
        this.icountry = icountry;
    }

    public String getCategorization() {
        return categorization;
    }

    public void setCategorization(String categorization) {
        this.categorization = categorization;
    }

    public String getBowner() {
        return bowner;
    }

    public void setBowner(String bowner) {
        this.bowner = bowner;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    @XmlTransient
    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    @XmlTransient
    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    @XmlTransient
    public List<Investment> getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(List<Investment> investmentList) {
        this.investmentList = investmentList;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CMR.Modelo.Client[ id=" + id + " ]";
    }
    
}

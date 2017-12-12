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
@Table(name = "Fund")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fund.findAll", query = "SELECT f FROM Fund f")
    , @NamedQuery(name = "Fund.findById", query = "SELECT f FROM Fund f WHERE f.id = :id")
    , @NamedQuery(name = "Fund.findByFundName", query = "SELECT f FROM Fund f WHERE f.fundName = :fundName")
    , @NamedQuery(name = "Fund.findByAccount", query = "SELECT f FROM Fund f WHERE f.account = :account")
    , @NamedQuery(name = "Fund.findByPlatform", query = "SELECT f FROM Fund f WHERE f.platform = :platform")
    , @NamedQuery(name = "Fund.findByValue", query = "SELECT f FROM Fund f WHERE f.value = :value")
    , @NamedQuery(name = "Fund.findByCountry", query = "SELECT f FROM Fund f WHERE f.country = :country")
    , @NamedQuery(name = "Fund.findByStatus", query = "SELECT f FROM Fund f WHERE f.status = :status")
    , @NamedQuery(name = "Fund.findByAssetClass", query = "SELECT f FROM Fund f WHERE f.assetClass = :assetClass")
    , @NamedQuery(name = "Fund.findByDate", query = "SELECT f FROM Fund f WHERE f.date = :date")
    , @NamedQuery(name = "Fund.findByNotes", query = "SELECT f FROM Fund f WHERE f.notes = :notes")})
public class Fund implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "FundName")
    private String fundName;
    @Column(name = "Account")
    private String account;
    @Column(name = "Platform")
    private String platform;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Value")
    private Double value;
    @Column(name = "Country")
    private String country;
    @Column(name = "Status")
    private String status;
    @Column(name = "AssetClass")
    private String assetClass;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "notes")
    private String notes;

    public Fund() {
    }

    public Fund(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        if (!(object instanceof Fund)) {
            return false;
        }
        Fund other = (Fund) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CMR.Modelo.Fund[ id=" + id + " ]";
    }
    
}

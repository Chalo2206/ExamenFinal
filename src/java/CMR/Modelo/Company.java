/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMR.Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id")
    , @NamedQuery(name = "Company.findByCompanyName", query = "SELECT c FROM Company c WHERE c.companyName = :companyName")
    , @NamedQuery(name = "Company.findByRegNo", query = "SELECT c FROM Company c WHERE c.regNo = :regNo")
    , @NamedQuery(name = "Company.findByRole", query = "SELECT c FROM Company c WHERE c.role = :role")
    , @NamedQuery(name = "Company.findByTelephone", query = "SELECT c FROM Company c WHERE c.telephone = :telephone")
    , @NamedQuery(name = "Company.findByFax", query = "SELECT c FROM Company c WHERE c.fax = :fax")
    , @NamedQuery(name = "Company.findByMobile", query = "SELECT c FROM Company c WHERE c.mobile = :mobile")
    , @NamedQuery(name = "Company.findByCity", query = "SELECT c FROM Company c WHERE c.city = :city")
    , @NamedQuery(name = "Company.findByCountry", query = "SELECT c FROM Company c WHERE c.country = :country")
    , @NamedQuery(name = "Company.findByState", query = "SELECT c FROM Company c WHERE c.state = :state")
    , @NamedQuery(name = "Company.findByObjective", query = "SELECT c FROM Company c WHERE c.objective = :objective")
    , @NamedQuery(name = "Company.findByDate", query = "SELECT c FROM Company c WHERE c.date = :date")
    , @NamedQuery(name = "Company.findByCode", query = "SELECT c FROM Company c WHERE c.code = :code")
    , @NamedQuery(name = "Company.findByMgr", query = "SELECT c FROM Company c WHERE c.mgr = :mgr")
    , @NamedQuery(name = "Company.findByInvestorType", query = "SELECT c FROM Company c WHERE c.investorType = :investorType")
    , @NamedQuery(name = "Company.findByTotalAssets", query = "SELECT c FROM Company c WHERE c.totalAssets = :totalAssets")
    , @NamedQuery(name = "Company.findByPEratio", query = "SELECT c FROM Company c WHERE c.pEratio = :pEratio")
    , @NamedQuery(name = "Company.findByFee", query = "SELECT c FROM Company c WHERE c.fee = :fee")
    , @NamedQuery(name = "Company.findByStaff", query = "SELECT c FROM Company c WHERE c.staff = :staff")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "RegNo")
    private String regNo;
    @Column(name = "Role")
    private String role;
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "Fax")
    private String fax;
    @Column(name = "Mobile")
    private String mobile;
    @Column(name = "City")
    private String city;
    @Column(name = "Country")
    private String country;
    @Column(name = "State")
    private String state;
    @Column(name = "objective")
    private String objective;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "Code")
    private String code;
    @Column(name = "mgr")
    private String mgr;
    @Column(name = "investorType")
    private String investorType;
    @Column(name = "TotalAssets")
    private Integer totalAssets;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PEratio")
    private BigDecimal pEratio;
    @Column(name = "Fee")
    private BigDecimal fee;
    @Column(name = "Staff")
    private Integer staff;

    public Company() {
    }

    public Company(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMgr() {
        return mgr;
    }

    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public String getInvestorType() {
        return investorType;
    }

    public void setInvestorType(String investorType) {
        this.investorType = investorType;
    }

    public Integer getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Integer totalAssets) {
        this.totalAssets = totalAssets;
    }

    public BigDecimal getPEratio() {
        return pEratio;
    }

    public void setPEratio(BigDecimal pEratio) {
        this.pEratio = pEratio;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CMR.Modelo.Company[ id=" + id + " ]";
    }
    
}

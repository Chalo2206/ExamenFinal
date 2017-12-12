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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Investment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investment.findAll", query = "SELECT i FROM Investment i")
    , @NamedQuery(name = "Investment.findByInvID", query = "SELECT i FROM Investment i WHERE i.invID = :invID")
    , @NamedQuery(name = "Investment.findByDate", query = "SELECT i FROM Investment i WHERE i.date = :date")
    , @NamedQuery(name = "Investment.findByInvestmentType", query = "SELECT i FROM Investment i WHERE i.investmentType = :investmentType")
    , @NamedQuery(name = "Investment.findByCusip", query = "SELECT i FROM Investment i WHERE i.cusip = :cusip")
    , @NamedQuery(name = "Investment.findByAssetType", query = "SELECT i FROM Investment i WHERE i.assetType = :assetType")
    , @NamedQuery(name = "Investment.findByGoal", query = "SELECT i FROM Investment i WHERE i.goal = :goal")
    , @NamedQuery(name = "Investment.findBySector", query = "SELECT i FROM Investment i WHERE i.sector = :sector")
    , @NamedQuery(name = "Investment.findByUnitPrice", query = "SELECT i FROM Investment i WHERE i.unitPrice = :unitPrice")
    , @NamedQuery(name = "Investment.findByShares", query = "SELECT i FROM Investment i WHERE i.shares = :shares")
    , @NamedQuery(name = "Investment.findByTotal", query = "SELECT i FROM Investment i WHERE i.total = :total")
    , @NamedQuery(name = "Investment.findByCurrency", query = "SELECT i FROM Investment i WHERE i.currency = :currency")})
public class Investment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Inv_ID")
    private String invID;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "InvestmentType")
    private String investmentType;
    @Column(name = "CUSIP")
    private Integer cusip;
    @Column(name = "AssetType")
    private String assetType;
    @Column(name = "Goal")
    private String goal;
    @Column(name = "Sector")
    private String sector;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    @Column(name = "Shares")
    private BigDecimal shares;
    @Column(name = "Total")
    private BigDecimal total;
    @Column(name = "Currency")
    private String currency;
    @OneToMany(mappedBy = "investmentID")
    private List<Sales> salesList;
    @JoinColumn(name = "ClientID", referencedColumnName = "ID")
    @ManyToOne
    private Client clientID;

    public Investment() {
    }

    public Investment(String invID) {
        this.invID = invID;
    }

    public String getInvID() {
        return invID;
    }

    public void setInvID(String invID) {
        this.invID = invID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public Integer getCusip() {
        return cusip;
    }

    public void setCusip(Integer cusip) {
        this.cusip = cusip;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getShares() {
        return shares;
    }

    public void setShares(BigDecimal shares) {
        this.shares = shares;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @XmlTransient
    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }

    public Client getClientID() {
        return clientID;
    }

    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invID != null ? invID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investment)) {
            return false;
        }
        Investment other = (Investment) object;
        if ((this.invID == null && other.invID != null) || (this.invID != null && !this.invID.equals(other.invID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CMR.Modelo.Investment[ invID=" + invID + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s")
    , @NamedQuery(name = "Sales.findBySId", query = "SELECT s FROM Sales s WHERE s.sId = :sId")
    , @NamedQuery(name = "Sales.findByNewPrice", query = "SELECT s FROM Sales s WHERE s.newPrice = :newPrice")
    , @NamedQuery(name = "Sales.findByProfit", query = "SELECT s FROM Sales s WHERE s.profit = :profit")
    , @NamedQuery(name = "Sales.findByDeduction", query = "SELECT s FROM Sales s WHERE s.deduction = :deduction")
    , @NamedQuery(name = "Sales.findByDue", query = "SELECT s FROM Sales s WHERE s.due = :due")
    , @NamedQuery(name = "Sales.findByDate", query = "SELECT s FROM Sales s WHERE s.date = :date")
    , @NamedQuery(name = "Sales.findByNotes", query = "SELECT s FROM Sales s WHERE s.notes = :notes")
    , @NamedQuery(name = "Sales.findBySellingPrice", query = "SELECT s FROM Sales s WHERE s.sellingPrice = :sellingPrice")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "S_ID")
    private Integer sId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NewPrice")
    private BigDecimal newPrice;
    @Column(name = "Profit")
    private BigDecimal profit;
    @Column(name = "Deduction")
    private BigDecimal deduction;
    @Column(name = "Due")
    private BigDecimal due;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "notes")
    private String notes;
    @Column(name = "SellingPrice")
    private BigDecimal sellingPrice;
    @JoinColumn(name = "InvestmentID", referencedColumnName = "Inv_ID")
    @ManyToOne
    private Investment investmentID;

    public Sales() {
    }

    public Sales(Integer sId) {
        this.sId = sId;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getDeduction() {
        return deduction;
    }

    public void setDeduction(BigDecimal deduction) {
        this.deduction = deduction;
    }

    public BigDecimal getDue() {
        return due;
    }

    public void setDue(BigDecimal due) {
        this.due = due;
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

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Investment getInvestmentID() {
        return investmentID;
    }

    public void setInvestmentID(Investment investmentID) {
        this.investmentID = investmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CMR.Modelo.Sales[ sId=" + sId + " ]";
    }
    
}

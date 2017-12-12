/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMR.Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ProfitPercent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfitPercent.findAll", query = "SELECT p FROM ProfitPercent p")
    , @NamedQuery(name = "ProfitPercent.findById", query = "SELECT p FROM ProfitPercent p WHERE p.id = :id")
    , @NamedQuery(name = "ProfitPercent.findByPercents", query = "SELECT p FROM ProfitPercent p WHERE p.percents = :percents")})
public class ProfitPercent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "percents")
    private BigDecimal percents;

    public ProfitPercent() {
    }

    public ProfitPercent(Integer id) {
        this.id = id;
    }

    public ProfitPercent(Integer id, BigDecimal percents) {
        this.id = id;
        this.percents = percents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPercents() {
        return percents;
    }

    public void setPercents(BigDecimal percents) {
        this.percents = percents;
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
        if (!(object instanceof ProfitPercent)) {
            return false;
        }
        ProfitPercent other = (ProfitPercent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CMR.Modelo.ProfitPercent[ id=" + id + " ]";
    }
    
}

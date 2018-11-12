/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "deal")
@XmlRootElement

public class Deal implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deal_id")
    private Integer dealId;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    
    @Basic(optional = false)
    @Column(name = "deal_exist")
    private Boolean dealExist;
    
    @JoinColumn(name="c_id", referencedColumnName="car_id")
    @ManyToOne(optional=false)
    private Car cId;

    public Deal() {
    }

    public Deal(Integer dealId, Date startDate, Date endDate, Boolean dealExist) {
        this.dealId = dealId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dealExist = dealExist;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getDealExist() {
        return dealExist;
    }

    public void setDealExist(Boolean dealExist) {
        this.dealExist = dealExist;
    }

    public Car getcId() {
        return cId;
    }

    public void setcId(Car cId) {
        this.cId = cId;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dealId != null ? dealId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deal)) {
            return false;
        }
        Deal other = (Deal) object;
        if ((this.dealId == null && other.dealId != null) || (this.dealId != null && !this.dealId.equals(other.dealId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dealId.toString();
    }
    
    
}

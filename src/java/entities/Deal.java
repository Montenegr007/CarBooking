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
    @Column(name = "start_time")
    private String startTime;
    
    @Basic(optional = false)
    @Column(name = "end_time")
    private String endTime;
    
    @Basic(optional = false)
    @Column(name = "pick_up_city")
    private String pickUpCity;
    
    @Basic(optional = false)
    @Column(name = "drop_off_city")
    private String dropOffCity;
    
    @Basic(optional = false)
    @Column(name = "pick_up_place")
    private String pickUpPlace;
    
    @Basic(optional = false)
    @Column(name = "drop_off_place")
    private String dropOffPlace;
    
    @Basic(optional = false)
    @Column(name = "total_amount")
    private Integer totalAmount;
    
    @Basic(optional = false)
    @Column(name = "client_name")
    private String clientName;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "client_dofbirth")
    private Date clientDateBirth;
    
    @Basic(optional = false)
    @Column(name = "client_telephone")
    private String clientTel;
    
    @Basic(optional = false)
    @Column(name = "client_add_telephone")
    private String clientAddTel;
    
    @Basic(optional = false)
    @Column(name = "comment")
    private String comment;
    
    @Basic(optional = false)
    @Column(name = "cdw")
    private Boolean cdw;
    
    @Basic(optional = false)
    @Column(name = "scdw")
    private Boolean scdw;
    
    @Basic(optional = false)
    @Column(name = "pai")
    private Boolean pai;
    
    @Basic(optional = false)
    @Column(name = "theft")
    private Boolean theft;
    
    @Basic(optional = false)
    @Column(name = "green_card")
    private Boolean greenCard;
    
    @Basic(optional = false)
    @Column(name = "no_deposit")
    private Boolean noDeposit;
    
    @Basic(optional = false)
    @Column(name = "no_franchise")
    private Boolean noFranchise;
    
    @Basic(optional = false)
    @Column(name = "no_limit")
    private Boolean noLimit;
    
    @Basic(optional = false)
    @Column(name = "booster")
    private Boolean booster;
    
    @Basic(optional = false)
    @Column(name = "child_seat")
    private Boolean childSeat;
    
    @Basic(optional = false)
    @Column(name = "upto_1_seat")
    private Boolean uptoOneSeat;
    
    @Basic(optional = false)
    @Column(name = "second_driver")
    private Boolean secondDriver;
    
    @Basic(optional = false)
    @Column(name = "gps_navigator")
    private Boolean gpsNavigator;
    
    @Basic(optional = false)
    @Column(name = "wifi")
    private Boolean wifi;
    
    @Basic(optional = false)
    @Column(name = "delivery")
    private Integer delivery;
    
    @Basic(optional = false)
    @Column(name = "deal_exist")
    private Boolean dealExist;
    
    @JoinColumn(name="c_id", referencedColumnName="car_id")
    @ManyToOne(optional=false)
    private Car cId;

    public Deal() {
    }

    public Deal(Integer dealId, Date startDate, Date endDate, String startTime, String endTime, String pickUpCity, String dropOffCity, String pickUpPlace, String dropOffPlace, Integer totalAmount, String clientName, Date clientDateBirth, String clientTel, String clientAddTel, String comment, Boolean cdw, Boolean scdw, Boolean pai, Boolean theft, Boolean greenCard, Boolean noDeposit, Boolean noFranchise, Boolean noLimit, Boolean booster, Boolean childSeat, Boolean uptoOneSeat, Boolean secondDriver, Boolean gpsNavigator, Boolean wifi, Integer delivery, Boolean dealExist, Car cId) {
        this.dealId = dealId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pickUpCity = pickUpCity;
        this.dropOffCity = dropOffCity;
        this.pickUpPlace = pickUpPlace;
        this.dropOffPlace = dropOffPlace;
        this.totalAmount = totalAmount;
        this.clientName = clientName;
        this.clientDateBirth = clientDateBirth;
        this.clientTel = clientTel;
        this.clientAddTel = clientAddTel;
        this.comment = comment;
        this.cdw = cdw;
        this.scdw = scdw;
        this.pai = pai;
        this.theft = theft;
        this.greenCard = greenCard;
        this.noDeposit = noDeposit;
        this.noFranchise = noFranchise;
        this.noLimit = noLimit;
        this.booster = booster;
        this.childSeat = childSeat;
        this.uptoOneSeat = uptoOneSeat;
        this.secondDriver = secondDriver;
        this.gpsNavigator = gpsNavigator;
        this.wifi = wifi;
        this.delivery = delivery;
        this.dealExist = dealExist;
        this.cId = cId;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPickUpCity() {
        return pickUpCity;
    }

    public void setPickUpCity(String pickUpCity) {
        this.pickUpCity = pickUpCity;
    }

    public String getDropOffCity() {
        return dropOffCity;
    }

    public void setDropOffCity(String dropOffCity) {
        this.dropOffCity = dropOffCity;
    }

    public String getPickUpPlace() {
        return pickUpPlace;
    }

    public void setPickUpPlace(String pickUpPlace) {
        this.pickUpPlace = pickUpPlace;
    }

    public String getDropOffPlace() {
        return dropOffPlace;
    }

    public void setDropOffPlace(String dropOffPlace) {
        this.dropOffPlace = dropOffPlace;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getClientDateBirth() {
        return clientDateBirth;
    }

    public void setClientDateBirth(Date clientDateBirth) {
        this.clientDateBirth = clientDateBirth;
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public String getClientAddTel() {
        return clientAddTel;
    }

    public void setClientAddTel(String clientAddTel) {
        this.clientAddTel = clientAddTel;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getCdw() {
        return cdw;
    }

    public void setCdw(Boolean cdw) {
        this.cdw = cdw;
    }

    public Boolean getScdw() {
        return scdw;
    }

    public void setScdw(Boolean scdw) {
        this.scdw = scdw;
    }

    public Boolean getPai() {
        return pai;
    }

    public void setPai(Boolean pai) {
        this.pai = pai;
    }

    public Boolean getTheft() {
        return theft;
    }

    public void setTheft(Boolean theft) {
        this.theft = theft;
    }

    public Boolean getGreenCard() {
        return greenCard;
    }

    public void setGreenCard(Boolean greenCard) {
        this.greenCard = greenCard;
    }

    public Boolean getNoDeposit() {
        return noDeposit;
    }

    public void setNoDeposit(Boolean noDeposit) {
        this.noDeposit = noDeposit;
    }

    public Boolean getNoFranchise() {
        return noFranchise;
    }

    public void setNoFranchise(Boolean noFranchise) {
        this.noFranchise = noFranchise;
    }

    public Boolean getNoLimit() {
        return noLimit;
    }

    public void setNoLimit(Boolean noLimit) {
        this.noLimit = noLimit;
    }

    public Boolean getBooster() {
        return booster;
    }

    public void setBooster(Boolean booster) {
        this.booster = booster;
    }

    public Boolean getChildSeat() {
        return childSeat;
    }

    public void setChildSeat(Boolean childSeat) {
        this.childSeat = childSeat;
    }

    public Boolean getUptoOneSeat() {
        return uptoOneSeat;
    }

    public void setUptoOneSeat(Boolean uptoOneSeat) {
        this.uptoOneSeat = uptoOneSeat;
    }

    public Boolean getSecondDriver() {
        return secondDriver;
    }

    public void setSecondDriver(Boolean secondDriver) {
        this.secondDriver = secondDriver;
    }

    public Boolean getGpsNavigator() {
        return gpsNavigator;
    }

    public void setGpsNavigator(Boolean gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
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

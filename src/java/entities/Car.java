/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Giniyatullin_I
 */
@Entity
@Table(name = "car")
@XmlRootElement

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "car_id")
    private Integer carId;
    
    @Basic(optional = false)
    @Column(name = "brand")
    private String brand;
    
    @Basic(optional = false)
    @Column(name = "car_class")
    private String carClass;
    
    @Basic(optional = false)
    @Column(name = "model")
    private String model;
    
   @Basic(optional = false)
    @Column(name = "plate_no")
    private String plateNo;
    
    @Basic(optional = false)
    @Column(name = "prod_year")
    private int productionYear;
    
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    
    @Basic(optional = false)
    @Column(name = "body_type")
    private String bodyType;
    
    @Basic(optional = false)
    @Column(name = "unlim_free")
    private Boolean unlimitKmFree;
    
    @Column(name = "limit_km")
    private Integer limitKmDay;
    
    @Column(name = "limit_overage")
    private Integer limitOverage;
    
    @Column(name = "unlim_price")
    private Integer unlimitPrice;
    
    @Basic(optional = false)
    @Column(name = "tpl_included")
    private Boolean includedTpl;
    
    @Basic(optional = false)
    @Column(name = "scdw_included")
    private Boolean includedScdw;
    
    @Basic(optional = false)
    @Column(name = "scdw_price")
    private Integer scdwPrice;
    
    @Basic(optional = false)
    @Column(name = "cdw_included")
    private Boolean includedCdw;
    
    @Basic(optional = false)
    @Column(name = "cdw_price")
    private Integer cdwPrice;
    
    @Basic(optional = false)
    @Column(name = "pai_included")
    private Boolean includedPai;
    
    @Basic(optional = false)
    @Column(name = "pai_price")
    private Integer paiPrice;
    
    @Basic(optional = false)
    @Column(name = "franchise_amount")
    private Integer franchiseAmount;
    
    @Basic(optional = false)
    @Column(name = "no_franchise_price")
    private Integer noFranchisePrice;
    
    @Basic(optional = false)
    @Column(name = "theft_included")
    private Boolean includedTheft;
    
    @Basic(optional = false)
    @Column(name = "theft_price")
    private Integer theftPrice;
    
    @Basic(optional = false)
    @Column(name = "deposit_amount")
    private Integer depositAmount;
    
    @Basic(optional = false)
    @Column(name = "no_deposit_price")
    private Integer noDepositPrice;
    
    @Basic(optional = false)
    @Column(name = "green_card_included")
    private Boolean includedGreenCard;
    
    @Basic(optional = false)
    @Column(name = "green_card_price")
    private Integer greenCardPrice;
    
    @Basic(optional = false)
    @Column(name = "engine_type")
    private String engineType;
    
    @Basic(optional = false)
    @Column(name = "transmission")
    private String transmission;
    
    @Basic(optional = false)
    @Column(name = "capacity")
    private String capacity;
    
    @Basic(optional = false)
    @Column(name = "drive")
    private String drive;
    
    @Basic(optional = false)
    @Column(name = "fuel")
    private String fuel;
    
    @Basic(optional = false)
    @Column(name = "tank")
    private String tank;
    
    @Basic(optional = false)
    @Column(name = "fuel_consumption")
    private String fuelConsumption;
    
    @Basic(optional = false)
    @Column(name = "absystem")
    private Boolean absystem;
    
    @Basic(optional = false)
    @Column(name = "ebd")
    private Boolean ebd;
    
    @Basic(optional = false)
    @Column(name = "esp")
    private Boolean esp;
    
    @Basic(optional = false)
    @Column(name = "num_of_seats")
    private String numOfSeats;
    
    @Basic(optional = false)
    @Column(name = "num_of_doors")
    private String numOfDoors;
    
    @Basic(optional = false)
    @Column(name = "air_condition")
    private String airCondition;
    
    @Basic(optional = false)
    @Column(name = "interior")
    private String interior;
    
    @Basic(optional = false)
    @Column(name = "pow_windows")
    private String poweredWindows;
    
    @Basic(optional = false)
    @Column(name = "num_of_airbags")
    private String numOfAirbags;
    
    @Basic(optional = false)
    @Column(name = "side_wheel")
    private String sideWheel;
    
    @Basic(optional = false)
    @Column(name = "cruise_controle")
    private String cruiseControle;
    
    @Basic(optional = false)
    @Column(name = "reverse_camera")
    private String reverseCamera;
    
    @Basic(optional = false)
    @Column(name = "parktronik")
    private String parktronik;
    
    @Basic(optional = false)
    @Column(name = "radio")
    private String radio;
    
    @Basic(optional = false)
    @Column(name = "video")
    private String video;
    
    @Basic(optional = false)
    @Column(name = "audio_cd")
    private String audioCd;
    
    @Basic(optional = false)
    @Column(name = "usb")
    private String usb;
    
    @Basic(optional = false)
    @Column(name = "mp3")
    private String mp3;
    
    @Basic(optional = false)
    @Column(name = "aux")
    private String aux;
    
    @Basic(optional = false)
    @Column(name = "gps_included")
    private Boolean includedGps;
    
    @Basic(optional = false)
    @Column(name = "gps_price")
    private Integer gpsPrice;
    
    @Basic(optional = false)
    @Column(name = "child_booster_price")
    private Integer childBoosterPrice;
    
    @Basic(optional = false)
    @Column(name = "child_seat_price")
    private Integer childSeatPrice;
    
    @Basic(optional = false)
    @Column(name = "child_seat_up1_price")
    private Integer childSeatUp1Price;
    
    @Basic(optional = false)
    @Column(name = "second_driver_price")
    private Integer secondDriverPrice;
    
    @Basic(optional = false)
    @Column(name = "wifi_price")
    private Integer wifiPrice;
    
    @Column(name = "actual_price_list")
    private Integer[] actualPriceList;
    
    @Column(name = "actual_price")
    private Integer actualPrice;
    
    @Column(name = "actual_price_interval")
    private Integer[] actualPriceInterval;
    
    @Column(name = "price_interval")
    private List<Integer[]> priceInterval;
    
    @Column(name = "season_price")
    private List<Integer[]> seasonPrice;
    
    @Column(name = "season_interval")
    private List<Date[]> seasonInterval;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cId")
    private List<Deal> dealList;
    
    public Car() {
    }

    public Car(Integer carId) {
        this.carId = carId;
    }

    public Car(Integer carId, String brand, String carClass, String model, String plateNo, int productionYear, String color, String bodyType, Boolean unlimitKmFree, Integer limitKmDay, Integer limitOverage, Integer unlimitPrice, Boolean includedTpl, Boolean includedScdw, Integer scdwPrice, Boolean includedCdw, Integer cdwPrice, Boolean includedPai, Integer paiPrice, Integer franchiseAmount, Integer noFranchisePrice, Boolean includedTheft, Integer theftPrice, Integer depositAmount, Integer noDepositPrice, Boolean includedGreenCard, Integer greenCardPrice, String engineType, String transmission, String capacity, String drive, String fuel, String tank, String fuelConsumption, Boolean absystem, Boolean ebd, Boolean esp, String numOfSeats, String numOfDoors, String airCondition, String interior, String poweredWindows, String numOfAirbags, String sideWheel, String cruiseControle, String reverseCamera, String parktronik, String radio, String video, String audioCd, String usb, String mp3, String aux, Boolean includedGps, Integer gpsPrice, Integer childBoosterPrice, Integer childSeatPrice, Integer childSeatUp1Price, Integer secondDriverPrice, Integer wifiPrice, Integer[] actualPriceList, Integer actualPrice, Integer[] actualPriceInterval, List<Integer[]> priceInterval, List<Integer[]> seasonPrice, List<Date[]> seasonInterval, List<Deal> dealList) {
        this.carId = carId;
        this.brand = brand;
        this.carClass = carClass;
        this.model = model;
        this.plateNo = plateNo;
        this.productionYear = productionYear;
        this.color = color;
        this.bodyType = bodyType;
        this.unlimitKmFree = unlimitKmFree;
        this.limitKmDay = limitKmDay;
        this.limitOverage = limitOverage;
        this.unlimitPrice = unlimitPrice;
        this.includedTpl = includedTpl;
        this.includedScdw = includedScdw;
        this.scdwPrice = scdwPrice;
        this.includedCdw = includedCdw;
        this.cdwPrice = cdwPrice;
        this.includedPai = includedPai;
        this.paiPrice = paiPrice;
        this.franchiseAmount = franchiseAmount;
        this.noFranchisePrice = noFranchisePrice;
        this.includedTheft = includedTheft;
        this.theftPrice = theftPrice;
        this.depositAmount = depositAmount;
        this.noDepositPrice = noDepositPrice;
        this.includedGreenCard = includedGreenCard;
        this.greenCardPrice = greenCardPrice;
        this.engineType = engineType;
        this.transmission = transmission;
        this.capacity = capacity;
        this.drive = drive;
        this.fuel = fuel;
        this.tank = tank;
        this.fuelConsumption = fuelConsumption;
        this.absystem = absystem;
        this.ebd = ebd;
        this.esp = esp;
        this.numOfSeats = numOfSeats;
        this.numOfDoors = numOfDoors;
        this.airCondition = airCondition;
        this.interior = interior;
        this.poweredWindows = poweredWindows;
        this.numOfAirbags = numOfAirbags;
        this.sideWheel = sideWheel;
        this.cruiseControle = cruiseControle;
        this.reverseCamera = reverseCamera;
        this.parktronik = parktronik;
        this.radio = radio;
        this.video = video;
        this.audioCd = audioCd;
        this.usb = usb;
        this.mp3 = mp3;
        this.aux = aux;
        this.includedGps = includedGps;
        this.gpsPrice = gpsPrice;
        this.childBoosterPrice = childBoosterPrice;
        this.childSeatPrice = childSeatPrice;
        this.childSeatUp1Price = childSeatUp1Price;
        this.secondDriverPrice = secondDriverPrice;
        this.wifiPrice = wifiPrice;
        this.actualPriceList = actualPriceList;
        this.actualPrice = actualPrice;
        this.actualPriceInterval = actualPriceInterval;
        this.priceInterval = priceInterval;
        this.seasonPrice = seasonPrice;
        this.seasonInterval = seasonInterval;
        this.dealList = dealList;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Boolean getUnlimitKmFree() {
        return unlimitKmFree;
    }

    public void setUnlimitKmFree(Boolean unlimitKmFree) {
        this.unlimitKmFree = unlimitKmFree;
    }

    public Integer getLimitKmDay() {
        return limitKmDay;
    }

    public void setLimitKmDay(Integer limitKmDay) {
        this.limitKmDay = limitKmDay;
    }

    public Integer getLimitOverage() {
        return limitOverage;
    }

    public void setLimitOverage(Integer limitOverage) {
        this.limitOverage = limitOverage;
    }

    public Integer getUnlimitPrice() {
        return unlimitPrice;
    }

    public void setUnlimitPrice(Integer unlimitPrice) {
        this.unlimitPrice = unlimitPrice;
    }

    public Boolean getIncludedTpl() {
        return includedTpl;
    }

    public void setIncludedTpl(Boolean includedTpl) {
        this.includedTpl = includedTpl;
    }

    public Boolean getIncludedScdw() {
        return includedScdw;
    }

    public void setIncludedScdw(Boolean includedScdw) {
        this.includedScdw = includedScdw;
    }

    public Integer getScdwPrice() {
        return scdwPrice;
    }

    public void setScdwPrice(Integer scdwPrice) {
        this.scdwPrice = scdwPrice;
    }

    public Boolean getIncludedCdw() {
        return includedCdw;
    }

    public void setIncludedCdw(Boolean includedCdw) {
        this.includedCdw = includedCdw;
    }

    public Integer getCdwPrice() {
        return cdwPrice;
    }

    public void setCdwPrice(Integer cdwPrice) {
        this.cdwPrice = cdwPrice;
    }

    public Boolean getIncludedPai() {
        return includedPai;
    }

    public void setIncludedPai(Boolean includedPai) {
        this.includedPai = includedPai;
    }

    public Integer getPaiPrice() {
        return paiPrice;
    }

    public void setPaiPrice(Integer paiPrice) {
        this.paiPrice = paiPrice;
    }

    public Integer getFranchiseAmount() {
        return franchiseAmount;
    }

    public void setFranchiseAmount(Integer franchiseAmount) {
        this.franchiseAmount = franchiseAmount;
    }

    public Integer getNoFranchisePrice() {
        return noFranchisePrice;
    }

    public void setNoFranchisePrice(Integer noFranchisePrice) {
        this.noFranchisePrice = noFranchisePrice;
    }

    public Boolean getIncludedTheft() {
        return includedTheft;
    }

    public void setIncludedTheft(Boolean includedTheft) {
        this.includedTheft = includedTheft;
    }

    public Integer getTheftPrice() {
        return theftPrice;
    }

    public void setTheftPrice(Integer theftPrice) {
        this.theftPrice = theftPrice;
    }

    public Integer getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Integer depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Integer getNoDepositPrice() {
        return noDepositPrice;
    }

    public void setNoDepositPrice(Integer noDepositPrice) {
        this.noDepositPrice = noDepositPrice;
    }

    public Boolean getIncludedGreenCard() {
        return includedGreenCard;
    }

    public void setIncludedGreenCard(Boolean includedGreenCard) {
        this.includedGreenCard = includedGreenCard;
    }

    public Integer getGreenCardPrice() {
        return greenCardPrice;
    }

    public void setGreenCardPrice(Integer greenCardPrice) {
        this.greenCardPrice = greenCardPrice;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Boolean getAbsystem() {
        return absystem;
    }

    public void setAbsystem(Boolean absystem) {
        this.absystem = absystem;
    }

    public Boolean getEbd() {
        return ebd;
    }

    public void setEbd(Boolean ebd) {
        this.ebd = ebd;
    }

    public Boolean getEsp() {
        return esp;
    }

    public void setEsp(Boolean esp) {
        this.esp = esp;
    }

    public String getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(String numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(String numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public String getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(String airCondition) {
        this.airCondition = airCondition;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getPoweredWindows() {
        return poweredWindows;
    }

    public void setPoweredWindows(String poweredWindows) {
        this.poweredWindows = poweredWindows;
    }

    public String getNumOfAirbags() {
        return numOfAirbags;
    }

    public void setNumOfAirbags(String numOfAirbags) {
        this.numOfAirbags = numOfAirbags;
    }

    public String getSideWheel() {
        return sideWheel;
    }

    public void setSideWheel(String sideWheel) {
        this.sideWheel = sideWheel;
    }

    public String getCruiseControle() {
        return cruiseControle;
    }

    public void setCruiseControle(String cruiseControle) {
        this.cruiseControle = cruiseControle;
    }

    public String getReverseCamera() {
        return reverseCamera;
    }

    public void setReverseCamera(String reverseCamera) {
        this.reverseCamera = reverseCamera;
    }

    public String getParktronik() {
        return parktronik;
    }

    public void setParktronik(String parktronik) {
        this.parktronik = parktronik;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getAudioCd() {
        return audioCd;
    }

    public void setAudioCd(String audioCd) {
        this.audioCd = audioCd;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public Boolean getIncludedGps() {
        return includedGps;
    }

    public void setIncludedGps(Boolean includedGps) {
        this.includedGps = includedGps;
    }

    public Integer getGpsPrice() {
        return gpsPrice;
    }

    public void setGpsPrice(Integer gpsPrice) {
        this.gpsPrice = gpsPrice;
    }

    public Integer getChildBoosterPrice() {
        return childBoosterPrice;
    }

    public void setChildBoosterPrice(Integer childBoosterPrice) {
        this.childBoosterPrice = childBoosterPrice;
    }

    public Integer getChildSeatPrice() {
        return childSeatPrice;
    }

    public void setChildSeatPrice(Integer childSeatPrice) {
        this.childSeatPrice = childSeatPrice;
    }

    public Integer getChildSeatUp1Price() {
        return childSeatUp1Price;
    }

    public void setChildSeatUp1Price(Integer childSeatUp1Price) {
        this.childSeatUp1Price = childSeatUp1Price;
    }

    public Integer getSecondDriverPrice() {
        return secondDriverPrice;
    }

    public void setSecondDriverPrice(Integer secondDriverPrice) {
        this.secondDriverPrice = secondDriverPrice;
    }

    public Integer getWifiPrice() {
        return wifiPrice;
    }

    public void setWifiPrice(Integer wifiPrice) {
        this.wifiPrice = wifiPrice;
    }

    public Integer[] getActualPriceList() {
        return actualPriceList;
    }

    public void setActualPriceList(Integer[] actualPriceList) {
        this.actualPriceList = actualPriceList;
    }

    public Integer getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Integer actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Integer[] getActualPriceInterval() {
        return actualPriceInterval;
    }

    public void setActualPriceInterval(Integer[] actualPriceInterval) {
        this.actualPriceInterval = actualPriceInterval;
    }

    public List<Integer[]> getPriceInterval() {
        return priceInterval;
    }

    public void setPriceInterval(List<Integer[]> priceInterval) {
        this.priceInterval = priceInterval;
    }

    public List<Integer[]> getSeasonPrice() {
        return seasonPrice;
    }

    public void setSeasonPrice(List<Integer[]> seasonPrice) {
        this.seasonPrice = seasonPrice;
    }

    public List<Date[]> getSeasonInterval() {
        return seasonInterval;
    }

    public void setSeasonInterval(List<Date[]> seasonInterval) {
        this.seasonInterval = seasonInterval;
    }

    public List<Deal> getDealList() {
        return dealList;
    }

    public void setDealList(List<Deal> dealList) {
        this.dealList = dealList;
    }

    
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Car[ carId=" + carId + " ]";
    }

   
}

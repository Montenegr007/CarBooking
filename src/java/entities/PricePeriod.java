/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Giniyatullin_I
 */
public class PricePeriod implements Serializable {
    
    private String period;
    private String price;

    public PricePeriod() {
    }

    public PricePeriod(String period, String price) {
        this.period = period;
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.period);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PricePeriod other = (PricePeriod) obj;
        return true;
    }

    @Override
    public String toString() {
        return "PricePeriod{" + "period=" + period + ", price=" + price + '}';
    }
    
    
    
}

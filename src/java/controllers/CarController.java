package controllers;

import entities.Car;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import sessions.CarFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("carController")
@SessionScoped
public class CarController implements Serializable {

    @EJB
    private sessions.CarFacade ejbFacade;
    private List<Car> items = null;
    
    private Car selected;
    
    private final Integer[] priceInterval1 = new Integer[2];
    private final Integer[] priceInterval2 = new Integer[2];
    private final Integer[] priceInterval3 = new Integer[2];
    private final Integer[] priceInterval4 = new Integer[2];
    private final Integer[] priceInterval5 = new Integer[2];
    private final Integer[] priceInterval6 = new Integer[2];
    private final Integer[] priceInterval7 = new Integer[2];
    private List<Integer[]> priceIntervals = null;
    
    private final Integer[] highPrice = new Integer[7];
    private final Integer[] medium1Price = new Integer[7];
    private final Integer[] medium2Price = new Integer[7];
    private final Integer[] lowPrice = new Integer[7];
    private List<Integer[]> prices = null;
    
    private final Date[] highSeason = new Date[2];
    private final Date[] lowSeason = new Date[2];
    private final Date[] medium1Season = new Date[2];
    private final Date[] medium2Season = new Date[2];
    private List<Date[]> seasons = null;
    
    
    
    
    public CarController() {
    }

    public Car getSelected() {
        return selected;
    }

    public void setSelected(Car selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CarFacade getFacade() {
        return ejbFacade;
    }

    public CarFacade getEjbFacade() {
        return ejbFacade;
    }

    public List<Integer[]> getPriceIntervals() {
        return priceIntervals;
    }

    public Integer[] getPriceInterval1() {
        return priceInterval1;
    }

    public Integer[] getPriceInterval2() {
        return priceInterval2;
    }

    public Integer[] getPriceInterval3() {
        return priceInterval3;
    }

    public Integer[] getPriceInterval4() {
        return priceInterval4;
    }

    public Integer[] getPriceInterval5() {
        return priceInterval5;
    }

    public Integer[] getPriceInterval6() {
        return priceInterval6;
    }

    public Integer[] getPriceInterval7() {
        return priceInterval7;
    }
        
    public Integer[] getHighPrice() {
        return highPrice;
    }

    public Integer[] getMedium1Price() {
        return medium1Price;
    }

    public Integer[] getMedium2Price() {
        return medium2Price;
    }

    public Integer[] getLowPrice() {
        return lowPrice;
    }

    public List<Integer[]> getPrices() {
        return prices;
    }

    public Date[] getHighSeason() {
        return highSeason;
    }

    public Date[] getLowSeason() {
        return lowSeason;
    }

    public Date[] getMedium1Season() {
        return medium1Season;
    }

    public Date[] getMedium2Season() {
        return medium2Season;
    }

    public List<Date[]> getSeasons() {
        return seasons;
    }
    
    
     public Car prepareCreate() {    
         
        priceIntervals = new ArrayList();
        priceIntervals.add(priceInterval1);
        priceIntervals.add(priceInterval2);
        priceIntervals.add(priceInterval3);
        priceIntervals.add(priceInterval4);
        priceIntervals.add(priceInterval5);
        priceIntervals.add(priceInterval6);
        priceIntervals.add(priceInterval7);
        
        
        prices = new ArrayList();
        prices.add(highPrice);
        prices.add(medium1Price);
        prices.add(medium2Price);
        prices.add(lowPrice);
        
        seasons = new ArrayList();
        seasons.add(highSeason);
        seasons.add(medium1Season);
        seasons.add(medium2Season);
        seasons.add(lowSeason);
        
        selected = new Car();
        
        selected.setPriceInterval(priceIntervals);
        selected.setSeasonPrice(prices);
        selected.setSeasonInterval(seasons);
        
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CarCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CarUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CarDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Car> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Car getCar(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Car> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Car> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Car.class)
    public static class CarControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CarController controller = (CarController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "carController");
            return controller.getCar(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Car) {
                Car o = (Car) object;
                return getStringKey(o.getCarId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Car.class.getName()});
                return null;
            }
        }

    }

}

package controllers;

import entities.Car;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import entities.PricePeriod;
import sessions.CarFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    private List<Car> freeItems = null;
    
        
    private Car selected;
    private String[] highPrice;
    private String[] lowPrice;
    private String[] medium1Price;
    private String[] medium2Price;
    private String[] pricePeriod;
      
    

    public CarController() {
    }

    
    public Car getSelected() {
        return selected;
    }

    public void setSelected(Car selected) {
        this.selected = selected;
    }

    public String[] getPricePeriod() {
        return pricePeriod;
    }

    public String[] getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String[] highPrice) {
        this.highPrice = highPrice;
    }

    public String[] getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String[] lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String[] getMedium1Price() {
        return medium1Price;
    }

    public void setMedium1Price(String[] medium1Price) {
        this.medium1Price = medium1Price;
    }

    public String[] getMedium2Price() {
        return medium2Price;
    }

    public void setMedium2Price(String[] medium2Price) {
        this.medium2Price = medium2Price;
    }

    public List<Car> getFreeItems() {
        return freeItems;
    }

    public void setFreeItems(List<Car> freeItems) {
        this.freeItems = freeItems;
    }
    
    
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CarFacade getFacade() {
        return ejbFacade;
    }
    
   
    public Car prepareCreate() {
        highPrice = new String[7];
        lowPrice = new String[7];
        medium1Price = new String[7];
        medium2Price = new String[7];
        pricePeriod = new String[7];
        
        for(int i=0; i<7; i++){
            System.out.println(pricePeriod[i]);
        }
            
        selected = new Car();
        selected.setPriceH(highPrice);
        selected.setPriceL(lowPrice);
        selected.setPriceM1(medium1Price);
        selected.setPriceM2(medium2Price);
        selected.setPricePeriod(pricePeriod);

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

package controllers;

import entities.Deal;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import entities.Car;
import java.io.IOException;
import sessions.DealFacade;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import org.primefaces.context.RequestContext;

@Named("dealController")
@SessionScoped
public class DealController implements Serializable {

    @EJB
    private sessions.DealFacade ejbFacade;
    private List<Deal> items = null;
    private Deal selected;
    private Car selectedCar;
    
    private List<Car> freeCars = null;
    private List<String> dates = null;
    
    private Date startDate;
    private Date endDate;
    
    
    public DealController() {
    }

    public List<String> getDates() {
        return dates;
    }

    public Deal getSelected() {
        return selected;
    }

    public void setSelected(Deal selected) {
        this.selected = selected;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
    
    public Car getSelectedCar() {
        return selectedCar;
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

    public DealFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(DealFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<Car> getFreeCars() {
        return freeCars;
    }

    public void setFreeCars(List<Car> freeCars) {
        this.freeCars = freeCars;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DealFacade getFacade() {
        return ejbFacade;
    }

    public void freeCarList() throws IOException{
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String sDate = formatter.format(startDate);
        String eDate = formatter.format(endDate);
        
        long days = (endDate.getTime() - startDate.getTime())/(24*60*60*1000);
        String delta = String.valueOf(days);
        
        System.out.println(sDate);
        System.out.println(eDate); 
        
        dates = new ArrayList<>();
        dates.add(sDate);
        dates.add(eDate);
        dates.add(delta);
        
                  
       try{    
        freeCars = ejbFacade.listOfFreeCars(startDate, endDate);
        
       }catch (Exception e) {
           System.out.println("Что то пошло не так!");
       }
       
       
       for(Car c : freeCars){
            for(int i = 0; i< c.getSeasonInterval().size(); i++){
               if(c.getSeasonInterval().get(i)[0].before(startDate)&& c.getSeasonInterval().get(i)[1].after(endDate)){
                    c.setActualPriceList(c.getSeasonPrice().get(i));
                }
            }
        }
        
        for(Car c : freeCars){
            for(int i = 0; i< c.getPriceInterval().size(); i++){
               if(days >= c.getPriceInterval().get(i)[0] && days <= c.getPriceInterval().get(i)[1]){
                    c.setActualPriceInterval(c.getPriceInterval().get(i));
                    c.setActualPrice(c.getActualPriceList()[i]);
                }
            }
        }
       
       
       
        FacesContext.getCurrentInstance().getExternalContext().redirect("FreeCars.xhtml"); 
    }
    
    public Deal prepareCreate() {
        selected = new Deal();
        initializeEmbeddableKey();
        return selected;
    }
    
    public Car prepareSelectedCar(){
        selectedCar = new Car();
        
        return selectedCar;
    }
    
    public void closeDialog(){
        RequestContext.getCurrentInstance().execute("PF('CarViewDialog').hide();PF('DealViewDialog').show()");
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DealCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DealUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DealDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Deal> getItems() {
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

    public Deal getDeal(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Deal> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Deal> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Deal.class)
    public static class DealControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DealController controller = (DealController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "dealController");
            return controller.getDeal(getKey(value));
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
            if (object instanceof Deal) {
                Deal o = (Deal) object;
                return getStringKey(o.getDealId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Deal.class.getName()});
                return null;
            }
        }

    }

}

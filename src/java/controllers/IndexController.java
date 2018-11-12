/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Giniyatullin_I
 */
@Named(value = "indexController")
@SessionScoped
public class IndexController implements Serializable {
    
  private static final long serialVersionUID = 1L;
  
  private String locale;

   private static Map<String,Object> countries;
      static {
      
      countries = new LinkedHashMap<String, Object>();
      countries.put("English", Locale.ENGLISH);
      countries.put("French", Locale.FRENCH);
      countries.put("Germany", Locale.GERMANY);
   }

   public Map<String, Object> getCountries() {
      return countries;
   }

   public String getLocale() {
      return locale;
   }

   public void setLocale(String locale) {
      this.locale = locale;
   }

   //value change event listener
   public void localeChanged(ValueChangeEvent e) {
      locale = e.getNewValue().toString();
      
      System.out.println(locale);
      
      if(locale.equalsIgnoreCase("English")) {
      
      //for (Map.Entry<String, Object> entry : countries.entrySet()) {
      // if(entry.getValue().toString().equals(locale)) {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);         
         }else if(locale.equalsIgnoreCase("Russian")) {
             FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.GERMANY);
       //  }else if(locale.equalsIgnoreCase("Germany")) {
     //        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.GERMANY);
         }
      }
}
   
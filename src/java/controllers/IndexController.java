package controllers;

import entities.Car;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import lombok.Getter;
import lombok.Setter;


@Named("indexController")
@SessionScoped
public class IndexController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    @Getter @Setter private sessions.DealFacade ejbFacade;

    @Getter @Setter private String locale;
    
    @Getter @Setter private Date pickupDate;
    @Getter @Setter private Date returnDate;
    @Getter @Setter private String pickupPlace;
    @Getter @Setter private String returnPlace;
    
    @Getter @Setter private List<Car> freeCars = null;
    @Getter @Setter private List<Car> freeCompactCars;
    @Getter @Setter private List<Car> freeStandardCars;
    @Getter @Setter private List<Car> freeLuxuryCars;
    @Getter @Setter private List<Car> freeCrossoverCars;
    @Getter @Setter private List<String> listForDates = null; //List for next page dates parameter saving
    @Getter @Setter private List<String> placesList;

    
    
    //Change locale//
    public void changeLocale(ValueChangeEvent e) {
        locale = e.getNewValue().toString();

        System.out.println(locale);

        if (locale.equalsIgnoreCase("English")) {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);

        } else if (locale.equalsIgnoreCase("Russian")) {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.GERMANY);

        }
    }
    
    //Get free cars//
    public void getFreeCarList() throws IOException{
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy"); //Formatting for next page
        String pDate = formatter.format(pickupDate); //Formatting for next page
        String rDate = formatter.format(returnDate); //Formatting for next page
        
        long numOfDays = (returnDate.getTime() - pickupDate.getTime())/(24*60*60*1000);
        String numOfDaysAsString = String.valueOf(numOfDays);
        
        System.out.println(pDate); //убрать - для тестирования
        System.out.println(rDate); //убрать - для тестирования
        
        listForDates = new ArrayList<>();
        listForDates.add(pDate);
        listForDates.add(rDate);
        listForDates.add(numOfDaysAsString);
        
        freeCompactCars = new ArrayList();
        freeStandardCars = new ArrayList();
        freeLuxuryCars = new ArrayList();
        freeCrossoverCars = new ArrayList();
                  
       try{    
        freeCars = ejbFacade.getListOfFreeCars(pickupDate, returnDate);
        
       }catch (Exception e) {
           System.out.println("Что то пошло не так!");
       }
       
       freeCars.forEach((c) -> {
           for(int i = 0; i< c.getSeasonInterval().size(); i++){
               if(c.getSeasonInterval().get(i)[0].before(pickupDate)&& c.getSeasonInterval().get(i)[1].after(returnDate)){
                   c.setActualPriceList(c.getSeasonPrice().get(i));
               }
           }
        });
        
       freeCars.forEach((c) -> {
           for(int i = 0; i< c.getPriceInterval().size(); i++){
               if(numOfDays >= c.getPriceInterval().get(i)[0] && numOfDays <= c.getPriceInterval().get(i)[1]){
                   c.setActualPriceInterval(c.getPriceInterval().get(i));
                   c.setActualPrice(c.getActualPriceList()[i]);
               }
           }
        });
       
        
       
       freeCars.forEach((c) -> {
           if(c.getCarClass().equals("Economy")){
               freeCompactCars.add(c);
               System.out.println(freeCompactCars.size());
           }else if(c.getCarClass().equals("Standard")){
               freeStandardCars.add(c);
           }else if(c.getCarClass().equals("Luxury")){
               freeLuxuryCars.add(c);
           }else if(c.getCarClass().equals("Crossover")){
               freeCrossoverCars.add(c);
           }
        });
       
        FacesContext.getCurrentInstance().getExternalContext().redirect("FreeCars.xhtml"); 
    }
    
    public List<String> completePlaceList(String query){
        
        List<String> placeList = new ArrayList();
        placeList.add("Budva");
        placeList.add("Tivat");
        placeList.add("Bar");
        placeList.add("Kotor");
        placeList.add("Herceg Novi");
        placeList.add("Podgorica");
        placeList.add("Petrovac");
        
        placesList = new ArrayList();
        for(int i = 0; i < placeList.size(); i++){
            if(placeList.get(i).contains(query)){
                placesList.add(placeList.get(i));
            }
        }
        
        System.out.println(placesList.size());
        
        return placesList;
    }
    
    
    
  }

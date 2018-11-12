/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Car;
import entities.Deal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Giniyatullin_I
 */
@Stateless
public class DealFacade extends AbstractFacade<Deal> {

    @PersistenceContext(unitName = "CarBookingPU2")
    private EntityManager em;
    
    private List<Car> freeCars;
   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DealFacade() {
        super(Deal.class);
    }
    
    public List<Car> listOfFreeCars(Date date1, Date date2){
        
        freeCars = new ArrayList();
        
              
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = formatter.format(date1);
        String eDate = formatter.format(date2);
        
        System.out.println(date1);
        System.out.println(date2);
        
       
    //    Query query;
    //            query = em.createNativeQuery(
    //            "SELECT DISTINCT c_id FROM deal WHERE NOT c_id = ANY (SELECT c_id FROM deal WHERE (start_date, end_date) OVERLAPS (DATE '" + sDate + "', DATE '" + eDate + "')) AND deal_exist;");
           
        Query query = em.createNativeQuery("SELECT car_id FROM car WHERE NOT car_id = ANY (SELECT DISTINCT c_id FROM deal WHERE (start_date, end_date) OVERLAPS (DATE '" + sDate + "', DATE '" + eDate + "') AND deal_exist);");
    
        List<Long> list = query.getResultList();
        
        for(Long l : list) {
            System.out.println(l);
            TypedQuery<Car> query1 = em.createQuery("SELECT c FROM Car c WHERE c.carId = :carId", Car.class);
            query1.setParameter("carId", l);
            
           // System.out.println(query1.getSingleResult().getCarId());
            
            try{
                Car c = query1.getSingleResult();
                freeCars.add(c);
            } catch(Exception e){
                System.out.println("Car with ID = " + l + " не добавилась в коллекцию!");
            }
            
          //  freeCars = query1.getResultList();
            
            
           
          //  freeCars.add(query1.getResultList().get(0));
            
        }
        
        System.out.println(freeCars.size());
        
        return freeCars;
       
    }
    
    
}

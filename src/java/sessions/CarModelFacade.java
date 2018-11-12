/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.CarModel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Giniyatullin_I
 */
@Stateless
public class CarModelFacade extends AbstractFacade<CarModel> {

    @PersistenceContext(unitName = "CarBookingPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarModelFacade() {
        super(CarModel.class);
    }
    
}

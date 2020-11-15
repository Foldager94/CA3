/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.FlowerDTO;
import entities.Flowers;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ckfol
 */
public class FlowerFacade {
    
    private static EntityManagerFactory emf;
    private static FlowerFacade instance;

    private FlowerFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static FlowerFacade getFlowerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FlowerFacade();
        }
        return instance;
    }
    
    public FlowerDTO getUserFlower(String username){
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, username);
        System.out.print(user.getFlower());
        return new FlowerDTO(user.getFlower());
        
    }
    
    
}

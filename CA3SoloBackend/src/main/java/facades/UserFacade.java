package facades;

import entities.Role;
import dtos.UserDTO;
import entities.Flowers;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import security.errorhandling.AuthenticationException;

public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }
   
    public void createUser(UserDTO user){
        EntityManager em = emf.createEntityManager();
        try{
            User newUser = new User(user.getUsername(), user.getPassword());
            newUser.setZodiacSign(user.getZodiacsign());
            Flowers flower = em.find(Flowers.class, user.getFlower());
            flower.addUser(newUser);
            Role userRole = new Role("user");
            newUser.addRole(userRole);
            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }
    
    public List<UserDTO>UserDTOList(List<User> personEntities) {
    List<UserDTO> all = new ArrayList();
    personEntities.forEach((u) -> {
        all.add(new UserDTO(u));
    });
    return all;
    }
    
    public List<UserDTO> getAllUsers(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            
            return UserDTOList(query.getResultList());
        } finally {
        em.close();
    }
    }

}

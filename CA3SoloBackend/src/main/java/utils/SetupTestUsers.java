package utils;


import entities.Flowers;
import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    

    User user = new User("user", "userPW");
    User admin = new User("admin", "adminPW");
    User both = new User("user_admin", "user_adminPW");
    
    user.setZodiacSign("gemini");
    admin.setZodiacSign("cancer");
    both.setZodiacSign("leo");
    
    

    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");

    
    
    Flowers primula = new Flowers ("Primula");
    Flowers rose = new Flowers ("Rose");
    Flowers tulip = new Flowers ("Tulip");
            

    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    

    tulip.addUser(user);
    tulip.addUser(admin);
    tulip.addUser(both);
    
    
    em.persist(primula);
    em.persist(rose);
    em.persist(tulip);
    
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
   
  }

}

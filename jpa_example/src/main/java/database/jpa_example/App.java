package database.jpa_example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Person p = new Person(1, 19, "Noah", "Siegele");
//        Person p = new Person();
//        p.setAge(19);
//        p.setFirstName("Noah");
//        p.setLastName("Siegele");
//        p.setId(1);
        EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit");
        EntityManager manager = f.createEntityManager();
//        manager.getTransaction().begin();
//        manager.persist(p);
//        manager.getTransaction().commit();
    	
//        Person x = manager.find(Person.class, 1L);
//    	manager.getTransaction().begin();
//    	x.setAge(100);
//    	manager.getTransaction().commit();
//    	System.out.println(x);
        
//        Person p = manager.find(Person.class, 1L);
//        manager.getTransaction().begin();
//        manager.remove(p);
//        manager.getTransaction().commit();
        
    	Person p = new Person(1, 19, "Noah", "Siegele");
        Hobby h = new Hobby("Keine", 40, 12.40);
       
        
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        
        p.setHobby(h);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        
        Person x = manager.find(Person.class, 1L);
        System.out.println(x);
        
    }
}

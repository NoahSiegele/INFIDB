package database.bestellung_jpa;

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
    	EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit");
        EntityManager manager = f.createEntityManager();
    }
}

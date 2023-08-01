package pi.com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    public static EntityManager getManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TremBom");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}

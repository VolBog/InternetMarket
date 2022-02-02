package Util;






import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class HibernateUtil {
    private static final String PERSISTENT_UNIT_NAME = "Market";

    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);

        }
    }
    private static EntityManager entityManager = emf.createEntityManager();

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void getEntityTransactionBegin() {
        entityManager.getTransaction().begin();
    }

    public static void getEntityTransactionCommit() {
        entityManager.getTransaction().commit();
    }


    public static void close(){emf.close();}
}

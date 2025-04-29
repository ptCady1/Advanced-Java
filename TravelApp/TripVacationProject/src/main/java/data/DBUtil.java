package data;

/**
 *
 * @author Paul
 */
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("travelLogPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}

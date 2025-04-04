package data;

/**
 *
 * @author Paul
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("travelLogPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}

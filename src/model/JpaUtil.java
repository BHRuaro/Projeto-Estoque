package model;

import java.util.logging.Logger;
import jakarta.persistence.*;

public class JpaUtil {

    private static final Logger LOGGER = Logger.getLogger(JpaUtil.class.getName());

    public static EntityManager getEmPostgres() {
        EntityManager result = null;
        try {
            final EntityManagerFactory entityManagerFactory = Persistence
                    .createEntityManagerFactory("ProjetoEstoquePU");
            result = entityManagerFactory.createEntityManager();
        } catch (Exception ex) {

        }
        return result;
    }
}

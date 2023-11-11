package model;

import jakarta.persistence.*;

public class JpaUtil {

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

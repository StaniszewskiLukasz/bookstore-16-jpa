package conncetion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookstoreEMF {
    //z pliku persistance ikopiujemy poniżej wartość z persitance-unit
    public static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("bookstore16jpa");

    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }

}

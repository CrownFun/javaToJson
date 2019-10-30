package pl.filewicz.warehouse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class WarehouseDao {

    private EntityManager entityManager;

    WarehouseDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    void save(Product product) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(product);
        tx.commit();
    }


    Product getProduct(int id) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Product product = entityManager.find(Product.class, id);
        tx.commit();
        return product;
    }

}

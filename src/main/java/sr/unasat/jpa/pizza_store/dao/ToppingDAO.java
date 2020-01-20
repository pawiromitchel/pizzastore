package sr.unasat.jpa.pizza_store.dao;

import sr.unasat.jpa.pizza_store.entities.Topping;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ToppingDAO {
    private EntityManager entityManager;

    public ToppingDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Topping> selectAll() {
        entityManager.getTransaction().begin();
        String jpql = "select e from Topping e";
        TypedQuery<Topping> query = entityManager.createQuery(jpql, Topping.class);
        List<Topping> listRecords = query.getResultList();
        entityManager.getTransaction().commit();
        return listRecords;
    }

    public void insert(Topping topping){
        entityManager.getTransaction().begin();
        entityManager.persist(topping);
        entityManager.getTransaction().commit();
    }

    public void update(Topping topping) {
        entityManager.getTransaction().begin();
        entityManager.merge(topping);
        entityManager.getTransaction().commit();
    }

    public void delete(Topping topping) {
        entityManager.getTransaction().begin();
        entityManager.remove(topping);
        entityManager.getTransaction().commit();
    }
}

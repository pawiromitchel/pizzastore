package sr.unasat.jpa.pizza_store.dao;

import sr.unasat.jpa.pizza_store.entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderDAO {
    private EntityManager entityManager;

    public OrderDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Order> selectAll() {
        entityManager.getTransaction().begin();
        String jpql = "select e from Order e";
        TypedQuery<Order> query = entityManager.createQuery(jpql, Order.class);
        List<Order> listRecords = query.getResultList();
        entityManager.getTransaction().commit();
        return listRecords;
    }

    public void insert(Order order){
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
    }

    public void update(Order order) {
        entityManager.getTransaction().begin();
        entityManager.merge(order);
        entityManager.getTransaction().commit();
    }

    public void delete(Order order) {
        entityManager.getTransaction().begin();
        entityManager.remove(order);
        entityManager.getTransaction().commit();
    }
}

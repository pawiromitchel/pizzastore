package sr.unasat.jpa.pizza_store.dao;

import sr.unasat.jpa.pizza_store.entities.Type;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TypeDAO {
    private EntityManager entityManager;

    public TypeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Type> selectAll() {
        entityManager.getTransaction().begin();
        String jpql = "select e from Type e";
        TypedQuery<Type> query = entityManager.createQuery(jpql, Type.class);
        List<Type> listRecords = query.getResultList();
        entityManager.getTransaction().commit();
        return listRecords;
    }

    public void insert(Type type){
        entityManager.getTransaction().begin();
        entityManager.persist(type);
        entityManager.getTransaction().commit();
    }

    public void update(Type type) {
        entityManager.getTransaction().begin();
        entityManager.merge(type);
        entityManager.getTransaction().commit();
    }

    public void delete(Type type) {
        entityManager.getTransaction().begin();
        entityManager.remove(type);
        entityManager.getTransaction().commit();
    }
}

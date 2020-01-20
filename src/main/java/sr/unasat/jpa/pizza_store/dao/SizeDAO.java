package sr.unasat.jpa.pizza_store.dao;

import sr.unasat.jpa.pizza_store.entities.Size;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SizeDAO {
    private EntityManager entityManager;

    public SizeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Size> selectAll() {
        entityManager.getTransaction().begin();
        String jpql = "select e from Size e";
        TypedQuery<Size> query = entityManager.createQuery(jpql, Size.class);
        List<Size> listRecords = query.getResultList();
        entityManager.getTransaction().commit();
        return listRecords;
    }

    public void insert(Size size){
        entityManager.getTransaction().begin();
        entityManager.persist(size);
        entityManager.getTransaction().commit();
    }

    public void update(Size size) {
        entityManager.getTransaction().begin();
        entityManager.merge(size);
        entityManager.getTransaction().commit();
    }

    public void delete(Size size) {
        entityManager.getTransaction().begin();
        entityManager.remove(size);
        entityManager.getTransaction().commit();
    }
}

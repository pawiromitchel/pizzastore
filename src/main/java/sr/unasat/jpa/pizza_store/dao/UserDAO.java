package sr.unasat.jpa.pizza_store.dao;

import sr.unasat.jpa.pizza_store.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    private EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> selectAll() {
        entityManager.getTransaction().begin();
        String jpql = "select e from User e";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        List<User> listRecords = query.getResultList();
        entityManager.getTransaction().commit();
        return listRecords;
    }

    public User authUser(String username, String password) {
        entityManager.getTransaction().begin();
        String jpql = "select e from User e where e.username = :username and e.password = :password";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = query.getSingleResult();
        entityManager.getTransaction().commit();
        return user;
    }

    public void insert(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public void update(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public void delete(User user) {
        if (user.getRole() == null) {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        }
    }
}

package ma.ensa.biblio.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ma.ensa.biblio.model.User;

import java.util.List;

public class UserDAO {
    private EntityManager em;

    public UserDAO() {
        em = Persistence.createEntityManagerFactory("BibliothequePU").createEntityManager();
    }

    public void addUser(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
    }

    public User findUser(Long id) {
        return em.find(User.class, id);
    }

    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}


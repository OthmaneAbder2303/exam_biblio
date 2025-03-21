package ma.ensa.biblio.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ma.ensa.biblio.model.Borrow;

import java.util.List;

public class BorrowDAO {
    private EntityManager em;

    public BorrowDAO() {
        em = Persistence.createEntityManagerFactory("BibliothequePU").createEntityManager();
    }

    public void borrowDocument(Borrow borrow) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(borrow);
        transaction.commit();
    }

    public List<Borrow> getAllBorrows() {
        return em.createQuery("SELECT b FROM Borrow b", Borrow.class).getResultList();
    }

    public void updateBorrow(Borrow borrow) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(borrow);
        transaction.commit();
    }



}


package ma.ensa.biblio.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ma.ensa.biblio.model.Document;

import java.util.List;

public class DocumentDAO {

    private EntityManager em;

    public DocumentDAO() {
        em = Persistence.createEntityManagerFactory("BibliothequePU").createEntityManager();
    }

    public void addDocument(Document doc) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(doc);
        transaction.commit();
    }

    public Document findDocument(Long id) {
        return em.find(Document.class, id);
    }

    public List<Document> getAllDocuments() {
        return em.createQuery("SELECT d FROM Document d", Document.class).getResultList();
    }

}

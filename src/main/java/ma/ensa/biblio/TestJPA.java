package ma.ensa.biblio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;

import ma.ensa.biblio.dao.*;
import ma.ensa.biblio.model.*;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliothequePU");
        EntityManager em = emf.createEntityManager();

        UserDAO userDAO = new UserDAO();
        DocumentDAO documentDAO = new DocumentDAO();
        BorrowDAO borrowDAO = new BorrowDAO();

        try {
            em.getTransaction().begin();

            User user1 = new User("atlas", "atl@example.com");
            User user2 = new User("othmane", "oth@example.com");
            userDAO.addUser(user1);
            userDAO.addUser(user2);

            Book book = new Book("JEE", new Date(), "Atlas", "978-23", new Date());
            Magazine mag = new Magazine("le matin", new Date(), "Media", "N°42", new Date());
            documentDAO.addDocument(book);
            documentDAO.addDocument(mag);

            Borrow borrow1 = new Borrow(user1, book, new Date(), null);
            Borrow borrow2 = new Borrow(user2, mag, new Date(), null);
            borrowDAO.borrowDocument(borrow1);
            borrowDAO.borrowDocument(borrow2);

            borrow1.setReturnDate(new Date());
            borrowDAO.updateBorrow(borrow1);

            em.getTransaction().commit();

            System.out.println("\n📌 USERS:");
            for (User u : userDAO.getAllUsers()) {
                System.out.println("→ " + u.getId() + " - " + u.getName() + " - " + u.getMail());
            }

            System.out.println("\n📌 DOCUMENTS:");
            for (Document d : documentDAO.getAllDocuments()) {
                System.out.println("→ " + d.getId() + " - " + d.getTitle());
            }

            System.out.println("\n📌 BORROWS:");
            for (Borrow b : borrowDAO.getAllBorrows()) {
                String status = (b.getReturnDate() == null) ? "📖 en cours" : "✅ retourné";
                System.out.println("→ " + b.getUser().getName() + " emprunte " + b.getDocument().getTitle() + " | " + status);
            }

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

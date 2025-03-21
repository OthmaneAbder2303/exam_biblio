package ma.ensa.biblio.model;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Book extends Document {
    private String author;
    private String isbn;
    private Date datePublication;

    public Book() {}

    public Book(String title, Date dateCreate, String author, String isbn, Date datePublication) {
        super(title, dateCreate);
        this.author = author;
        this.isbn = isbn;
        this.datePublication = datePublication;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }
}


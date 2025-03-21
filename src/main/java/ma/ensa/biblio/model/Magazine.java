package ma.ensa.biblio.model;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Magazine extends Document {
    private String publisher;
    private String issueNumber;
    private Date dateIssue;

    public Magazine() {}

    public Magazine(String title, Date dateCreate, String publisher, String issueNumber, Date dateIssue) {
        super(title, dateCreate);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
        this.dateIssue = dateIssue;
    }
}


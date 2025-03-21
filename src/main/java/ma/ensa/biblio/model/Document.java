package ma.ensa.biblio.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
//    private List<Borrow> borrows = new ArrayList<>();

//    @ManyToMany(mappedBy = "documents", cascade = CascadeType.PERSIST)
//    private List<User> users;

    private String title;
    private Date dateCreate;

    public Document() {}

    public Document(String title, Date dateCreate) {
        this.title = title;
        this.dateCreate = dateCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}


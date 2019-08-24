package entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book extends BasicEntity {


    @Column(name = "title", length = 50, nullable = false)
    private String title;
    @Column(name = "pages_number")
    private int pagesNumber;
    @Column(name = "isbn")
    private long isbn;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "books_authors",
                joinColumns = @JoinColumn(name = "book_id"),
                inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @OneToMany(mappedBy = "book")
    private List<Copy> copies;

    public Book(long id) {
        this.id=id;
    }

    public Book() {
    }

}

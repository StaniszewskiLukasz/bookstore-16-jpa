package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "code", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryCode code;

    @OneToMany(mappedBy = "category")
    private List<Book> books;
}

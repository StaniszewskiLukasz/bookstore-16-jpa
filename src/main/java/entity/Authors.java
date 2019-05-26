package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Authors extends BasicEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}

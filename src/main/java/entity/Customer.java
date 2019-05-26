package entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends BasicEntity {
    @Column(name = "first_name",length = 50)
    private String firstName;

    @Column(name = "last_name",length = 50)
    private String lastName;

    @Column(name = "create_date",nullable = false)
    private LocalDateTime createDate;

    @ElementCollection
    @CollectionTable(name = "customers_phones",
            joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "phone_number",nullable = false)
    private List<Integer> phoneNumbers;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}

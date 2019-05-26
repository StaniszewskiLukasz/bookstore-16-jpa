package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "zip_code", length = 6)
    private String zipCode;
    @Column(name = "street", length = 50)
    private String street;
    @Column(name = "street_no", length = 4)
    private String streetNo;
    @Column(name = "home_no", length = 4)
    private String homeNo;

    @OneToMany(mappedBy = "address")
    private List<Publisher> publishers;

}

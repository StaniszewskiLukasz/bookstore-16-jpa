package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;


/**
 * The type Type.
 */
@Getter
@Setter
@Entity
 @Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "age",nullable = false)
    private int age;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "active",nullable = false)
    private boolean active;

    @Column(name = "bytes")
    private byte[] bytes;

    @Column(name = "big_integer")
    private BigInteger bigInteger;
}

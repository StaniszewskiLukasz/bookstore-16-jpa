package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@Getter
@Setter
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne // to jest jawne stworzenie many to many poprzez zrobienie tabeli pośredniczącej i dwóch relacji jeden do wielu
    @JoinColumn(name = "copy_id",unique = true,nullable = false)
    private Copy copy;

    @ManyToOne // to jest jawne stworzenie many to many poprzez zrobienie tabeli pośredniczącej i dwóch relacji jeden do wielu
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
}

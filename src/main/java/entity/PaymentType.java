package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payments_type")
@Getter
@Setter
public class PaymentType extends BasicEntity{

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "code",unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentTypeCode code;

    @OneToMany(mappedBy = "paymentType")
    private List<Order> orders;

}

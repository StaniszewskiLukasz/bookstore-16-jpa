package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "copies")
@Getter
@Setter
public class Copy extends BasicEntity {
    @Column(name = "cost")
    private double cost;

    @ManyToOne
    @JoinColumn(name = "format_id",nullable = false)
    private Format format;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;
}

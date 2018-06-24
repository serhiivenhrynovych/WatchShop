package ua.com.serhii.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String productName;
    @NotNull
    private Integer price;
    @NotNull
    private String image;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Brand brand;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Size size;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Shape shape;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Style style;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Movement movement;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Features features;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Dial dial;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Band band;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Country country ;

    public Product(String productName, Integer price, String image) {
        this.productName = productName;
        this.price = price;
        this.image = image;
    }
}

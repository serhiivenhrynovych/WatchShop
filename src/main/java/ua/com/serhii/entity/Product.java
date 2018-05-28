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

    public Product(String productName, Integer price, String image) {
        this.productName = productName;
        this.price = price;
        this.image = image;
    }
}

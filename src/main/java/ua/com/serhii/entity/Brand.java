package ua.com.serhii.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;

    @OneToMany(cascade = CascadeType.MERGE, fetch =FetchType.LAZY,mappedBy = "brand")
    private List<Product> products = new ArrayList<Product>();

}

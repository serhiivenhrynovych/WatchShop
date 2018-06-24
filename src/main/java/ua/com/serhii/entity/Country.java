package ua.com.serhii.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;

    @OneToMany(cascade = CascadeType.MERGE, fetch =FetchType.LAZY,mappedBy = "country")
    private List<Product> products = new ArrayList<Product>();
}

package ua.com.serhii.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Dial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dialType;

    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY, mappedBy = "dial")
    private List<Product> products = new ArrayList<Product>();

}

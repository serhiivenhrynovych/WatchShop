package ua.com.serhii.service;

import ua.com.serhii.entity.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    Product findOneProduct(Long id);

    void removeProduct(Product product);

    Product findByName(String productName);

    List<Product> findAllProducts();

}

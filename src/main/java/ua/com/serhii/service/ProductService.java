package ua.com.serhii.service;

import org.springframework.web.multipart.MultipartFile;
import ua.com.serhii.entity.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(String productName, Integer price, MultipartFile image);

    Product findOneProduct(Long id);

    void removeProduct(Product product);

    Product findByName(String productName);

    List<Product> findAllProducts();

}

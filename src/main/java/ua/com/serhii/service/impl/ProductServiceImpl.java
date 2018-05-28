package ua.com.serhii.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.serhii.dao.ProductDAO;
import ua.com.serhii.entity.Product;
import ua.com.serhii.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public void saveProduct(String productName, Integer price, MultipartFile image) {
        String imageName = "/imgprod/" + image.getOriginalFilename();
        try {
            image.transferTo(new File(System.getProperty("user.home") + File.separator + imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product(productName, price, imageName);
        productDAO.save(product);
    }

    public Product findOneProduct(Long id) {
        return productDAO.findOne(id);
    }

    public void removeProduct(Product product) {
        productDAO.delete(product);
    }

    public Product findByName(String productName) {
        return productDAO.findByName(productName);
    }

    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }
}

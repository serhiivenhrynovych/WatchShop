package ua.com.serhii.service;

import ua.com.serhii.entity.Product;

import java.util.List;

public interface BasketService {

    List<Product> getProduct();

    void emptyBasket();

    void addProduct(Long id);

    double calculateFinalPrice();

}

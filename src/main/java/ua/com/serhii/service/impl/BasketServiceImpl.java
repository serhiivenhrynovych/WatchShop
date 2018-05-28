package ua.com.serhii.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.serhii.dao.ProductDAO;
import ua.com.serhii.dao.UserDAO;
import ua.com.serhii.entity.Basket;
import ua.com.serhii.entity.Product;
import ua.com.serhii.entity.User;
import ua.com.serhii.service.BasketService;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<Product> getProduct() {
        User user = new User();
        Basket basket = user.getBasket();
        return basket.getProducts();

    }

    @Override
    public void emptyBasket() {
        User user = new User();
        Basket basket = user.getBasket();
        basket.getProducts().clear();
    }

    @Override
    public void addProduct(Long id) {
        //TODO find current user
        User user = new User();
        Basket basket = user.getBasket();
        Product product = productDAO.findOne(id);
        basket.getProducts().add(product);
    }

    @Override
    public double calculateFinalPrice() {
        Integer finalPrice = 0;
        User user = new User();
        Basket basket = user.getBasket();
        List<Product> productList = basket.getProducts();
        for (Product pr : productList) {
            finalPrice += pr.getPrice();
        }
        return finalPrice;
    }
}

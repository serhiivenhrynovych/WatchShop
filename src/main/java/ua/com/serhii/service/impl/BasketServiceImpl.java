package ua.com.serhii.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.serhii.dao.BasketDAO;
import ua.com.serhii.dao.ProductDAO;
import ua.com.serhii.dao.UserDAO;
import ua.com.serhii.entity.Basket;
import ua.com.serhii.entity.Product;
import ua.com.serhii.entity.User;
import ua.com.serhii.service.BasketService;
import ua.com.serhii.service.UserService;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private BasketDAO basketDAO;

    @Override
    public List<Product> getProduct() {
        User user = userService.getCurrentUser();
        Basket basket = user.getBasket();
        return basket.getProducts();

    }

    @Override
    public void emptyBasket() {
        User user = userService.getCurrentUser();
        Basket basket = user.getBasket();
        basket.getProducts().clear();
    }

    @Override
    public void addProduct(Long id) {
        User user = userService.getCurrentUser();
        Basket basket = user.getBasket();
        Product product = productDAO.findOne(id);
        basket.getProducts().add(product);
        basketDAO.save(basket);
    }

    @Override
    public double calculateFinalPrice() {
        Integer finalPrice = 0;
        User user = userService.getCurrentUser();
        Basket basket = user.getBasket();
        List<Product> productList = basket.getProducts();
        for (Product pr : productList) {
            finalPrice += pr.getPrice();
        }
        return finalPrice;
    }
}

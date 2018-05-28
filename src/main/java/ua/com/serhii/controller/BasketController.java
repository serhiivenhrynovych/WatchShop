package ua.com.serhii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.com.serhii.service.BasketService;

@Controller
public class BasketController {

    @Autowired
    private BasketService basketService;

    @PostMapping("addToBasket")
    public String addToBasket(@RequestParam Long id) {
        basketService.addProduct(id);
        return "redirect:/product{id}";
    }

}

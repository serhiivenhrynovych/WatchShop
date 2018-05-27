package ua.com.serhii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.serhii.entity.Product;
import ua.com.serhii.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping({"/", "/main"})
    public String main(Model model, Principal principal) {
        List<Product> allProducts = productService.findAllProducts();
        model.addAttribute("productList", allProducts);
        return "main";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/basket")
    public String basketPage() {
        return "basket";
    }

    @PostMapping("saveProduct")
    public String saveProduct(@RequestParam String productName, @RequestParam Integer price, @RequestParam MultipartFile image) {
        String imageName = "/imgprod/" + image.getOriginalFilename();

        try {
            image.transferTo(new File(System.getProperty("user.home") + File.separator + imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product(productName, price, imageName);
        productService.saveProduct(product);
        return "redirect:/admin";
    }

    @PostMapping("removeProduct")
    public String removeProduct(@RequestParam Long id) {
        Product product = productService.findOneProduct(id);
        productService.removeProduct(product);
        return "redirect:/admin";
    }

    @GetMapping("product{id}")
    public String showProduct(Model model, @PathVariable Long id) {
        Product product = productService.findOneProduct(id);
        model.addAttribute("product", product);
        return "productPage";
    }


}

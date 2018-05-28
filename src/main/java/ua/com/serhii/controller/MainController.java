package ua.com.serhii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.serhii.entity.Product;
import ua.com.serhii.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String adminPage(ModelMap model, Principal principal) {
        model.addAttribute("principal", principal);
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @GetMapping("/Access_Denied")
    public String accessDeniedPage(ModelMap model){
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @GetMapping("/basket")
    public String basketPage() {
        return "basket";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";

    }

    @PostMapping("saveProduct")
    public String saveProduct(@RequestParam String productName, @RequestParam Integer price, @RequestParam MultipartFile image) {
        productService.saveProduct(productName, price, image);
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

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails){
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


}

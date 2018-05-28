package ua.com.serhii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.serhii.entity.User;
import ua.com.serhii.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("createUser")
    public String createUser(@RequestParam String username, @RequestParam String email,
                             @RequestParam String password, @RequestParam String address, @RequestParam String phone) {
         userService.createUser(username,  email, password, address, phone);
         return "main";
    }

    @PostMapping("removeUser")
    public String removeUser(@RequestParam Long id) {
        User user = userService.findOneUser(id);
        userService.removeUser(user);
        return "redirect:/admin";
    }

}

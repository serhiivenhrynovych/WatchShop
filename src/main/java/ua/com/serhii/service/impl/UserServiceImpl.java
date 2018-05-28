package ua.com.serhii.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.serhii.dao.UserDAO;
import ua.com.serhii.entity.User;
import ua.com.serhii.entity.enumeration.Role;
import ua.com.serhii.service.UserService;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public void createUser(String username, String email, String password, String address, String phone) {
        final String hashedPassword = passwordEncoder.encode(password);
        User user = new User(username, email, hashedPassword, LocalDate.now(), address, phone);
        saveUser(user);
    }

    @Override
    public void removeUser(User user) {
        userDAO.delete(user);
    }

    @Override
    public User findOneUser(Long id) {
        return userDAO.findOne(id);
    }

}

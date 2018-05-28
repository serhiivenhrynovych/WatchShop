package ua.com.serhii.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.serhii.dao.TemporalLinkDAO;
import ua.com.serhii.dao.UserDAO;
import ua.com.serhii.entity.Basket;
import ua.com.serhii.entity.TemporalLink;
import ua.com.serhii.entity.User;
import ua.com.serhii.entity.enumeration.TemporalLinkType;
import ua.com.serhii.service.EmailService;
import ua.com.serhii.service.UserService;
import ua.com.serhii.util.RandomUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private int linkExpiryHour = 24;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TemporalLinkDAO temporalLinkDAO;

    @Autowired
    private EmailService emailService;

    @Override
    public User saveUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public void createUser(String username, String email, String password, String address, String phone) {
        final String hashedPassword = passwordEncoder.encode(password);
        Basket basket = new Basket();
        User user = new User(username, email, hashedPassword, LocalDate.now(), address, phone, basket);
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByName(username);
    }

    @Transactional
    public void sendForgotPasswordEmail(String email) {
        User user = userDAO.findOneByEmail(email);
        TemporalLink temporalLink = new TemporalLink(RandomUtil.generateToken(), TemporalLinkType.FORGOT_PASSWORD_CONFIRMATION,
                LocalDateTime.now().plusHours(linkExpiryHour), user);
        temporalLinkDAO.save(temporalLink);
        emailService.sendConfirmForgotPasswordEmail(user, temporalLink.getToken());
    }

    @Transactional
    @Override
    public void checkAndChangePassword(String token, String password, String confirmPassword) {

        TemporalLink temporalLink = temporalLinkDAO.findByTokenAndTypeAndActiveIsTrueAndExpiryDateIsAfter(
                token, TemporalLinkType.FORGOT_PASSWORD_CONFIRMATION, LocalDateTime.now());

        User user = temporalLink.getUsers();
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(password));
        userDAO.save(user);
        temporalLinkDAO.updateActiveTemporalLinkByToken(token, false);
    }

}

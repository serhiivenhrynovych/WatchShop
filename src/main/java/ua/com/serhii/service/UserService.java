package ua.com.serhii.service;

import ua.com.serhii.entity.User;

public interface UserService {

    User saveUser(User user);

    void createUser(String username, String email, String password, String address, String phone);

    void removeUser(User user);

    User findOneUser(Long id);

    void sendForgotPasswordEmail(String email);

    void checkAndChangePassword(String token, String password, String confirmPassword);

    User getCurrentUser();

}

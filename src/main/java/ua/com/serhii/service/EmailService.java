package ua.com.serhii.service;

import ua.com.serhii.entity.User;

public interface EmailService {

    void sendConfirmForgotPasswordEmail(final User user, final String link);

}

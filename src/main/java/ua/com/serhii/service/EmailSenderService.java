package ua.com.serhii.service;

import ua.com.serhii.entity.User;

public interface EmailSenderService {

    void sendMail(final String to, final String subject, final String content);

}

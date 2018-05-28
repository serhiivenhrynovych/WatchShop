package ua.com.serhii.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.com.serhii.entity.User;
import ua.com.serhii.service.EmailSenderService;
import ua.com.serhii.service.EmailService;
import ua.com.serhii.util.EmailGenerator;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${mail.base.url}")
    private String rootPath;

    @Value("${mail.change-password.template}")
    private String changePasswordLocation;

    private static final String MAIL_URL = "%schange-password/%s";

    @Autowired
    private EmailSenderService emailSenderService;

    @Override
    public void sendConfirmForgotPasswordEmail(final User user, final String link) {
        String url = String.format(MAIL_URL, this.rootPath, link);
        String mail = EmailGenerator.generateConfirmationMail(user.getUsername(), url, rootPath, changePasswordLocation, "Confirm");
        emailSenderService.sendMail(user.getEmail(), user.getUsername() + ", please go to link to reset password.", mail);
    }

}

package ua.com.serhii.service.impl;

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.com.serhii.service.EmailSenderService;

import java.io.IOException;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    @Value("${mail.smtp.host}")
    private String smtpHost;

    @Value("${mail.smtp.port}")
    private String smtpPort;

    @Value("${mail.smtp.username}")
    private String username;

    @Value("${mail.smtp.password}")
    private String password;

    @Value("${mail.smtp.starttls.enable}")
    private String mailSmtpStarttlsEnable;

    @Value("${mail.smtp.auth}")
    private String mailSmtpAuth;

    @Value("${sendgrid.api.key}")
    private String sendGridKey;

    @Override
    public void sendMail(final String to, final String subject, final String content) {
        Email from = new Email(username);
        Email toUser = new Email(to);
        Content cont = new Content("text/html", content);
        Mail mail = new Mail(from, subject, toUser, cont);

        SendGrid sendGrid = new SendGrid(sendGridKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ua.com.serhii.util;

import java.io.*;

public class EmailGenerator {

    private static final String ENCODING = "UTF-8";
    private static final String BASE_URL = "$baseURL$";
    private static final String USER = "$username$";
    private static final String LINK = "$link$";
    private static final String BUTTON_TEXT = "$button_text$";

    public EmailGenerator() {
    }

    private static Reader getFileReader(final String fileName) {
        try {
            return new InputStreamReader(EmailGenerator.class.getResourceAsStream(fileName), ENCODING);
        } catch (final UnsupportedEncodingException e) {
            throw new RuntimeException("Wrong encoding " + fileName, e);
        }
    }

    public static String generateConfirmationMail(final String name, final String link, final String baseURL, String emailType,
                                                  String buttonText) {
        try {
            return getMailTemplate(emailType)
                    .toString()
                    .replace(BASE_URL, baseURL)
                    .replace(USER, name)
                    .replace(LINK, link)
                    .replace(BUTTON_TEXT, buttonText);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse template.", e);
        }
    }

    private static StringBuilder getMailTemplate(String emailType) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(getFileReader(emailType));
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        return stringBuilder;
    }

}

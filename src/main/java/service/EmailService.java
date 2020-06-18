package service;

import java.util.ArrayList;

import model.ValidInvalidFiles;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

    public static void sendEmail(ValidInvalidFiles validInvalidFiles) {
        ArrayList<String> validFiles = validInvalidFiles.validFiles;
        ArrayList<String> invalidFiles = validInvalidFiles.invalidFiles;

        String validFilesEmail = "Valid Files are ";
        String invalidFilesEmail = "Invalid Files are ";
        for (int i = 0; i < validFiles.size(); i++) {
            validFilesEmail = validFilesEmail + validFiles.get(i) + " ";
        }

        for (int i = 0; i < invalidFiles.size(); i++) {
            invalidFilesEmail = invalidFilesEmail + invalidFiles.get(i) + " ";
        }

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.post", "465");
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("learningtest97@gmail.com", "Testtest123");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("learningtest97@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("sankalpjain1997@gmail.com"));
            message.setSubject("Mail Subject");

            String msg = "This is my first email using JavaMailer";
            message.setText(validFilesEmail);

            Message message1 = new MimeMessage(session);
            message1.setFrom(new InternetAddress("learningtest97@gmail.com"));
            message1.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("sankalpjain1997@gmail.com"));
            message1.setSubject("Mail Subject");

            message1.setText(invalidFilesEmail);

            Transport.send(message);
            Transport.send(message1);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}   
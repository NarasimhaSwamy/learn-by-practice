package service;

import java.util.ArrayList;

import model.ValidInvalidFiles;
import model.Email;

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

    private static Session session;

    public static Email createEmail(ArrayList<String> fileList, String subject) {
        String body = "";
        for (int i = 0; i < fileList.size(); i++) {
            body = body + fileList.get(i) + "\n";
        }
        Email email = new Email();
        email.subject = subject;
        email.body = body;
        return email;
    }

    public static void sendEmailToUsers(Email email) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("learningtest97@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sankalpjain1997@gmail.com"));
            message.setSubject(email.subject);
            message.setText(email.body);
            Transport.send(message);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendEmail(ValidInvalidFiles validInvalidFiles) {
        Properties prop = new Properties();

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("learningtest97@gmail.com", "Testtest123");
            }
        });

        ArrayList<String> validFiles = validInvalidFiles.validFiles;
        ArrayList<String> invalidFiles = validInvalidFiles.invalidFiles;

        Email validEmail = createEmail(validFiles, "Valid Files are ");
        Email invalidEmail = createEmail(invalidFiles, "Invalid Files are ");

        sendEmailToUsers(validEmail);
        sendEmailToUsers(invalidEmail);
    }
}   
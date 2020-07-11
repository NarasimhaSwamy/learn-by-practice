package com.lbp.series;

import com.lbp.series.model.Email;
import com.lbp.series.model.FileAttributes;
import com.lbp.series.service.EmailService;
import com.lbp.series.service.impl.EmailServiceImpl;
import com.lbp.series.validation.FileValidation;

import java.io.File;
import java.util.Scanner;

import static com.lbp.series.validation.FileValidation.FILE_EXISTENCE_PREDICATE;
import static com.lbp.series.validation.FileValidation.FILE_EXTENSION_PREDICATE;
import static com.lbp.series.validation.FileValidation.MAX_FILE_SIZE_PREDICATE;

public class LearnByPacticeApplication {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input file path");
        String fileName = sc.nextLine();
        File file = new File(fileName);
        FileAttributes fAttributes = new FileAttributes(file);

        boolean truthValue =
                FILE_EXISTENCE_PREDICATE.and(FILE_EXTENSION_PREDICATE).and(MAX_FILE_SIZE_PREDICATE).test(fAttributes);
        if(truthValue) {
            System.out.println("Files are valid");
        } else {
            System.out.println("Not valid");
        }


        // Opening doors for mutating the email content
//        Email email = new Email();
//        email.setBody("body");
//        email.setFrom("from");
//        email.setSubject("subject");
//        email.setTo("to");
//        email.setHeaders(null);

//        Email emailWithAllConst = new Email("to", "from", "body", "subject", null);

        // Builder Pattern
        Email.EmailBuilder builder = new Email.EmailBuilder();
        Email email =  builder.addFrom("from").addTo("to").addHeaders(null).build();
//        EmailService emailService =


        EmailService emailService = new EmailServiceImpl();
        emailService.send(email);

    }
}

package com.lbp.service;

import com.lbp.utils.FileValidation;

import java.util.Scanner;
import java.io.File;

public class FileValidationService {
    public static void displayFileValidations() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input file path");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        boolean checkFileValidity = FileValidation.isValidFile(file);
        if(checkFileValidity) {
            System.out.println("Valid File");
        }
        else {
            System.out.println("Not a Valid file");
        }
    }
}

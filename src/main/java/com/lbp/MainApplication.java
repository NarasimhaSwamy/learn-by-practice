package com.lbp;

import com.lbp.model.ValidInvalidFiles;
import com.lbp.service.EmailService;
import com.lbp.service.FolderValidationService;

import java.util.Scanner;

import java.io.File;

public class MainApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input folder path");
        String folderPath = sc.nextLine();
        File folder = new File(folderPath);
        ValidInvalidFiles validInvalidFiles = FolderValidationService.validateFolder(folder);
        EmailService.sendEmail(validInvalidFiles);
    }
}

import utils.FileValidation;
import java.util.Scanner;

import model.ValidInvalidFiles;

import java.io.File;
import service.FolderValidationService;
import service.EmailService;

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

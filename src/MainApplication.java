import validations.FileValidation;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input file path");
        String fileName = sc.nextLine();

        boolean fileValidity = FileValidation.isValidFile(fileName);
        if(fileValidity) {
            System.out.println("Valid File");
        }
        else {
            System.out.println("Not a Valid file");
        }
    }
}

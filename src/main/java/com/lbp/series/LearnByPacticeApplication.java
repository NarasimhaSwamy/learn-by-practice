package com.lbp.series;

import com.lbp.series.model.FileAttributes;
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

    }
}

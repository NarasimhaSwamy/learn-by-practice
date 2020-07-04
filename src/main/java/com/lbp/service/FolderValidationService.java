package com.lbp.service;

import java.io.File;

import com.lbp.model.ValidInvalidFiles;
import com.lbp.utils.FileValidation;

public class FolderValidationService {
    public static ValidInvalidFiles validateFolder(File folder) {
        File[] listOfFiles = folder.listFiles();
        ValidInvalidFiles validInvalidFiles = new ValidInvalidFiles();
        for (File file : listOfFiles) {
            if(FileValidation.isValidFile(file)) {
                validInvalidFiles.validFiles.add(file.getName());
            }
            else {
                validInvalidFiles.invalidFiles.add(file.getName());
            }
        }
        return validInvalidFiles;
    }
}
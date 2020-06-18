package service;

import java.io.File;

import model.ValidInvalidFiles;
import utils.FileValidation;

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
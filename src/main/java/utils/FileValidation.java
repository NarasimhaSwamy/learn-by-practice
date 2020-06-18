package utils;
import java.io.File;

public class FileValidation {
    public static boolean isFileExists(File file) {
        if(file.exists()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isValidSize(File file) {
        long fileSize = file.length();
        if(fileSize > 0 && fileSize < 5 * 1024 * 1024) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isValidExtension(File file) {
        String[] validExtensions = {"pdf", "doc", "txt"};
        String name = file.getName();
        String fileExtension = "";
        if(name.lastIndexOf(".") != -1 && name.lastIndexOf(".") != 0)
            fileExtension = name.substring(name.lastIndexOf(".") + 1);

        for (int i = 0; i < validExtensions.length; i++) {
            if(fileExtension.equals(validExtensions[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidFile(File file) {
        if(isFileExists(file) && isValidSize(file) && isValidExtension(file)) {
            return true;
        }
        else {
            return false;
        }
    }
}

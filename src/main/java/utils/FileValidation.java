package utils;
import java.io.File;

public class FileValidation {
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024;
    private static final String[] VALID_FILE_EXTENSIONS = {"pdf", "doc", "txt"};

    private static final Predicate<File> FILE_EXISTENCE_PREDICATE = File::exists;
    private static final Predicate<File> MAX_FILE_SIZE_PREDICATE = file -> {
        long fileLength = file.length();
        return (fileLength>0 && fileLength< MAX_FILE_SIZE);
    };
    private static final Predicate<File> VALID_FILE_EXTENSION_PREDICATE = file -> {
        String name = file.getName();
        String fileExtension = "";
        if(name.lastIndexOf(".") != -1 && name.lastIndexOf(".") != 0)
            fileExtension = name.substring(name.lastIndexOf(".") + 1);

        for (int i = 0; i < VALID_FILE_EXTENSIONS.length; i++) {
            if(fileExtension.equals(VALID_FILE_EXTENSIONS[i])) {
                return true;
            }
        }
        return false;
    };

    public static boolean isValidFile(File file) {
        return FILE_EXISTENCE_PREDICATE.and(MAX_FILE_SIZE_PREDICATE).and(VALID_FILE_EXTENSION_PREDICATE).test(file);
    }
}

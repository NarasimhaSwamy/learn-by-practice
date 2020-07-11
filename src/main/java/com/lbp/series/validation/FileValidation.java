package com.lbp.series.validation;

import com.lbp.series.model.FileAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FileValidation {
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024;
    private static final List<String> VALID_FILE_EXTENSIONS = Arrays.asList("pdf", "doc", "txt");

    public static final Predicate<FileAttributes> FILE_EXISTENCE_PREDICATE = FileAttributes::exists;
    public static final Predicate<FileAttributes> FILE_EXTENSION_PREDICATE = fileAttributes -> VALID_FILE_EXTENSIONS.contains(fileAttributes.getExtension());
    public static final Predicate<FileAttributes> MAX_FILE_SIZE_PREDICATE  = fileAttributes -> (fileAttributes.getSize() > 0 && fileAttributes.getSize() <= MAX_FILE_SIZE);
}

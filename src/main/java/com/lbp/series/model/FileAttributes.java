package com.lbp.series.model;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.nio.file.attribute.FileAttribute;

public class FileAttributes {
    private String fullName;
    private String name;
    private long size;
    private String extension;
    private boolean exists;

    public FileAttributes(File fIle){
        this.exists = fIle.exists();
        this.fullName = fIle.getName();
        this.size = fIle.length();
        this.name = FilenameUtils.getBaseName(fullName);
        this.extension = FilenameUtils.getExtension(fullName);
    }

    public String getFullName() {
        return fullName;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getExtension() {
        return extension;
    }

    public boolean exists() {
        return exists;
    }
}

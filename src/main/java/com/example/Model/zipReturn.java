package com.example.Model;

import java.util.List;

public class zipReturn {
    private List<String> zipFiles;

    public zipReturn(List<String> zipFiles) {
        this.zipFiles = zipFiles;
    }

    public List<String> getZipFiles() {
        return this.zipFiles;
    }

    public void setFiles(List<String> zipFiles) {
        this.zipFiles = zipFiles;
    }
}

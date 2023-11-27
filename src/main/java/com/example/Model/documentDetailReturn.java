package com.example.Model;

public class documentDetailReturn {
    private String base64; // base64 encoding of the file's data
    private metaReturn metaData; // file's metaData information

    public documentDetailReturn(String base64, metaReturn metaData) {
        this.base64 = base64;
        this.metaData = metaData;
    }

    public String getBase64() {
        return this.base64;
    }

    public void setBase64(String base) {
        this.base64 = base;
    }

    public metaReturn getMetaData() {
        return this.metaData;
    }

    public void setMetaData(metaReturn meta) {
        this.metaData = meta;
    }
}
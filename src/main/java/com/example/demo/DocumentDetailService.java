package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Model.attachmentFile;
import com.example.Model.metaReturn;

@Component
public class DocumentDetailService {

    public String encodeFileToBase64(File file) {
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            throw new IllegalStateException("could not read file " + file, e);
        }
    }
<<<<<<< HEAD

    public metaReturn meta(String documentName, String projectName, String projectType, String periodStart, String periodEnd, String periodType, String customer, String resource, String resourceType, String auctionType, String proposalLabel, String attachmentType, String aucBeginDate, String aucEndDate, long fileSize) { // return file's metaData information
=======
    
    public String encode(Long attachment_id, String filePath, String fileName) {
        String newFilePath = prefix + filePath + "/" + fileName;
        return encodeFileToBase64(newFilePath);
    }

    public metaReturn meta(String documentName, String projectName, String projectType, String periodStart, String periodEnd, String periodType, String customer, String resource, String resourceType, String auctionType, String proposalLabel, String attachmentType, String aucBeginDate, String aucEndDate, float fileSize) { // return file's metaData information
>>>>>>> 89f12f5c5e19421e7f607ce0eee2d9114b203bcf
        metaReturn metaData = new metaReturn(documentName, projectName, projectType, periodStart, periodEnd, periodType, customer, resource, resourceType, auctionType, proposalLabel, attachmentType, aucBeginDate, aucEndDate, fileSize);
        return metaData;
    }
}

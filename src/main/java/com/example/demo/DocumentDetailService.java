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
    private String prefix = "data/"; // for testing

    private String encodeFileToBase64(String filename) {
        File file = new File(filename);
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            throw new IllegalStateException("could not read file " + file, e);
        }
    }
    
    public String encode(Long attachment_id, String filePath, String fileName) {
        String newFilePath = prefix + filePath + "/" + fileName;
        return encodeFileToBase64(newFilePath);
    }

    public metaReturn meta(String documentName, String projectName, String projectType, String periodStart, String periodEnd, String periodType, String customer, String resource, String resourceType, String auctionType, String proposalLabel, String attachmentType, String aucBeginDate, String aucEndDate, float fileSize) { // return file's metaData information
        metaReturn metaData = new metaReturn(documentName, projectName, projectType, periodStart, periodEnd, periodType, customer, resource, resourceType, auctionType, proposalLabel, attachmentType, aucBeginDate, aucEndDate, 0);
        return metaData;
    }
}

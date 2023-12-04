package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Model.attachmentFile;
import com.example.Model.metaReturn;

@Component
public class DocumentDetailService {
    private String urlPrefix = "C:\\Users\\eting\\CS 320 File Store\\"; // for testing

    public String encode(Long attachment_id, String filePath, String fileName) { // encode file's data in base64
        String newFilePath = urlPrefix + filePath + "/" + fileName;
        File file = new File(newFilePath);
        byte[] fileData;
        try {
            FileInputStream fis = new FileInputStream(file);
            fileData = fis.readAllBytes();
            fis.close();
        } catch(Exception e) {
            return null;
        }
        // byte[] fileData = newFilePath.getBytes(); // turn file path String into byte[]
        String base64EncodedFile = Base64.getEncoder().encodeToString(fileData); // encode in base64
        return base64EncodedFile;
    }

    public metaReturn meta(String documentName, String projectName, String projectType, String periodStart, String periodEnd, String periodType, String customer, String resource, String resourceType, String auctionType, String proposalLabel, String attachmentType, float fileSize) { // return file's metaData information
        metaReturn metaData = new metaReturn(documentName, projectName, projectType, periodStart, periodEnd, periodType, customer, resource, resourceType, auctionType, proposalLabel, attachmentType, 0);
        return metaData;
    }
}

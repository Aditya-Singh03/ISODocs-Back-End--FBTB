package com.example.demo;

import java.math.BigDecimal;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Model.attachmentFile;
import com.example.Model.metaReturn;

@Component
public class DocumentDetailService {
    private BigDecimal attachment_id;
    
    // temp entity
    @Autowired
    private final tempDocDetailRepository temp;
    
    public DocumentDetailService(BigDecimal attachment_id, tempDocDetailRepository temp) {
        this.attachment_id = attachment_id;
        this.temp = temp;
    }
    
    public String encode(BigDecimal attachment_id) { // encode file's data in base64
        attachmentFile file = tempDocDetailRepository.findFilePathsByAttachmentIdIn(attachment_id);
        byte[] fileData = file.getFilePath().getBytes(); // turn file path String into byte[]
        String base64EncodedFile = Base64.getEncoder().encodeToString(fileData); // encode in base64
        return base64EncodedFile;
    }

    public metaReturn meta(BigDecimal attachment_id) { // return file's metaData information
        metaReturn metaData = new metaReturn(null, null, null, null, null, null, null, null, null, null, null, null, 0);
        return metaData;
    }
}

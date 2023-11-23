package com.example.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attachment_file")
public class attachmentFile {
    @Id
    @Column(name = "attachment_id")
    private BigDecimal attachmentId;
    
    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_name")
    private String fileName;

    private attachmentFile() {}

    public attachmentFile(BigDecimal attachmentId, String filePath, String fileName) {
        this.attachmentId = attachmentId;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public BigDecimal getAttachmentId() {
        return this.attachmentId;
    }

    public void setAttachmentId(BigDecimal attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

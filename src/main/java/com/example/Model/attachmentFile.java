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

    private attachmentFile() {}

    public attachmentFile(BigDecimal attachmentId, String filePath) {
        this.attachmentId = attachmentId;
        this.filePath = filePath;
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
}

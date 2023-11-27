package com.example.demo;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.example.Model.attachmentFile;

public interface tempDocDetailRepository extends CrudRepository<attachmentFile, BigDecimal> {
    public static attachmentFile findFilePathsByAttachmentIdIn(BigDecimal attachment_ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFilePathsByAttachmentIdIn'");
    }
}
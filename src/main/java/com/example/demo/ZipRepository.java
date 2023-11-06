package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.Model.attachmentFile;

public interface ZipRepository extends CrudRepository<attachmentFile, BigDecimal> {
    public List<String> findFilePathsByAttachmentIdIn(List<BigDecimal> attachment_ids);
}

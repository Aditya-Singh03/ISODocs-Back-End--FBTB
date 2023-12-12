package com.example.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Model.attachmentFile;
import com.example.repository.ZipRepository;

@Component
public class ZipService {
    private String urlPrefix = "data/"; // for testing

    private List<BigDecimal> attachment_ids;

    @Autowired
    private final ZipRepository zipRepository;

    public ZipService(List<BigDecimal> attachment_ids, ZipRepository zipRepository) {
        this.attachment_ids = attachment_ids;
        this.zipRepository = zipRepository;
    }

    public List<String> zip(List<BigDecimal> attachment_ids) throws IOException {
        List<String> encodedZips = new ArrayList<>();
        List<attachmentFile> files = zipRepository.findFilePathsByAttachmentIdIn(attachment_ids);
        List<String> file_paths = new ArrayList<>();
        for (attachmentFile file : files) {
            file_paths.add(urlPrefix + file.getFilePath() + "/" + file.getFileName());
        }
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        try (ZipOutputStream zipOut = new ZipOutputStream(outStream)) {
            for (String file_path : file_paths) {
                File fileToZip = new File(file_path);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes,  0, length);
                }
                fis.close();
            }
            zipOut.close();
        }
        byte[] zippedData = outStream.toByteArray();
        String base64EncodedZip = Base64.getEncoder().encodeToString(zippedData);
        encodedZips.add(base64EncodedZip);
        return encodedZips;
    }
}

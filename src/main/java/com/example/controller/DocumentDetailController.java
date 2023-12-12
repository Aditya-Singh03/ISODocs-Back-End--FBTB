package com.example.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.documentDetailReturn;
import com.example.Model.metaReturn;
import com.example.demo.AttachmentFileService;
import com.example.service.DocumentDetailService;

@RestController
@CrossOrigin
public class DocumentDetailController {
    private String prefix = "data/"; // for testing

    @Autowired
    private DocumentDetailService documentDetailService;
    private AttachmentFileService attachmentFileService;

    public DocumentDetailController() {
        this.documentDetailService = new DocumentDetailService();
        this.attachmentFileService = new AttachmentFileService();
    }

    @GetMapping("/documentDetail")
    @ResponseBody
    public documentDetailReturn documentDetail(@RequestParam Long attachment_id) {
        // call service to obtain document information
        ArrayList<Map<String, Object>> info = attachmentFileService.queryForDocumentsOptional(attachment_id, null, null, null, null, null, null, null, null, null);
        Map<String, Object> map = info.get(0);
        // call service to encode file's data for previewing
        String newFilePath = prefix + map.get("filePath").toString() + "/" + map.get("file_name");
        File file = new File(newFilePath);
        float fileSize = (float) FileUtils.sizeOf(file);
        String base64 = documentDetailService.encode(attachment_id, map.get("filePath").toString(), map.get("file_name").toString());
        // call service to obtain document preview information
        metaReturn metaData = documentDetailService.meta(map.get("file_name").toString(), map.get("projectName").toString(), map.get("projectType").toString(), map.get("beginDate").toString(), map.get("endDate").toString(), map.get("periodType").toString(), map.get("custName").toString(), map.get("resourceName").toString(), map.get("resourceType").toString(), map.get("aucType").toString(), map.get("proposalLabel").toString(), map.get("attachmentType").toString(), map.get("aucBeginDate").toString(), map.get("aucEndDate").toString(), fileSize);
        return new documentDetailReturn(base64, metaData);
    }
}
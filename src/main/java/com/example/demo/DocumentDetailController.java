package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.documentDetailReturn;
import com.example.Model.metaReturn;

@RestController
public class DocumentDetailController {
    @Autowired
    private DocumentDetailService documentService;

    public DocumentDetailController(DocumentDetailService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/documentDetail")
    @ResponseBody
    public documentDetailReturn documentDetail(@RequestParam BigDecimal attachment_id) {
        // call service to encode file's data for previewing
        String base64 = documentService.encode(attachment_id);
        metaReturn metaData = documentService.meta(attachment_id);
        return new documentDetailReturn(base64, metaData);
    }
}

package com.example.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Model.zipReturn;
import com.example.service.ZipService;

@RestController
@CrossOrigin
public class ZipController {
    @Autowired
    private ZipService zipService;
    
    public ZipController(ZipService zipService) {
        this.zipService = zipService;
    }

    @GetMapping("/zipFiles")
    @ResponseBody
    public zipReturn zipFiles(@RequestParam List<BigDecimal> attachment_ids) throws IOException { // front end must send url parameters with form: http://localhost:8080/zipFiles?attachment_ids=1,2,3 or ?attachment_ids=1&attachment_ids=2
        // call service to encode and zip the files for download
        List<String> zippedFiles = zipService.zip(attachment_ids); 
        return new zipReturn(zippedFiles);   
    }
    
}

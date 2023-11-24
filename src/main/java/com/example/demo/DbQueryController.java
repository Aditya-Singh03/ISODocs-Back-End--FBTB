package com.example.demo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.zipReturn;

@RestController
public class DbQueryController {
    @Autowired
    private ReportRepository dbQueryController;
    
    public DbQueryController(ReportRepository dbQueryController) {
        this.dbQueryController = dbQueryController;
    }

    @CrossOrigin
    @GetMapping("/dbQuery")
    @ResponseBody
    public List<Object[]> documents() throws IOException { // front end must send url parameters with form: http://localhost:8080/zipFiles?attachment_ids=1,2,3 or ?attachment_ids=1&attachment_ids=2
        // call service to encode and zip the files for download
        List<Object[]> docs = dbQueryController.find(); 
        return docs;   
    }

    
    
}

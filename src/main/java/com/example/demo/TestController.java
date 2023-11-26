package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/TestCall")
    public List<Object> testCall() {
        return AttachmentFileService.queryForDocuments(1001L, "Project docs.zip", "Gravity Works", "Lightening Power ", 1L, "Big Generator");
    }

    @GetMapping("/filterDocs")
    public List<Object> filterDocs(@RequestParam(value = "attachment_id", required = true) Long attachment_id,
            @RequestParam(value = "file_name", required = false) String file_name,
            @RequestParam(value = "project_name", required = false) String project_name,
            @RequestParam(value = "customer_name", required = true) String customer_name,
            @RequestParam(value = "commitment_period_id", required = false) Long commitment_period_id,
            @RequestParam(value = "resource_name", required = false) String resource_name) {
        

        return AttachmentFileService.queryForDocuments(attachment_id, file_name, project_name, customer_name, commitment_period_id, resource_name);
    }

}

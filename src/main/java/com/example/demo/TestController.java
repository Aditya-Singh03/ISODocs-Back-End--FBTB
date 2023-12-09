package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {
    @GetMapping("/TestCall")
    public List<Object> testCall() {
        return AttachmentFileService.queryForDocuments(1001L, "Project docs.zip", "Gravity Works", "Lightening Power ", 1L, "Big Generator");
    }

    @GetMapping("/filterDocs")
    public ArrayList<Map<String, Object>> filterDocs(@RequestParam(value = "attachment_id", required = false) Long attachment_id,
            @RequestParam(value = "file_name", required = false) String file_name,
            @RequestParam(value = "project_name", required = false) String project_name,
            @RequestParam(value = "customer_name", required = false) String customer_name,
            @RequestParam(value = "commitment_period_id", required = false) Long commitment_period_id,
            @RequestParam(value = "resource_name", required = false) String resource_name,
            @RequestParam(value = "auc_begin_date", required = false) String auc_begin_date,
            @RequestParam(value = "auc_end_date", required = false) String auc_end_date,
            @RequestParam(value = "proposal_label", required = false) String proposal_label,
            @RequestParam(value = "auction_type", required = false) String auction_type,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        
        int pageSize = 3;
        int startIndex = (page - 1) * pageSize;
        int endIndex = startIndex + pageSize;

        auc_begin_date = "01-01-2017";
        
        ArrayList<Map<String, Object>> documents = AttachmentFileService.queryForDocumentsOptional(attachment_id, file_name, project_name, customer_name, commitment_period_id, resource_name, auc_begin_date, auc_end_date, proposal_label, auction_type);
        
        if (startIndex >= documents.size()) {
            return new ArrayList<>();
        }
        
        if (endIndex > documents.size()) {
            endIndex = documents.size();
        }
        
        return new ArrayList<>(documents.subList(startIndex, endIndex));
    }

}

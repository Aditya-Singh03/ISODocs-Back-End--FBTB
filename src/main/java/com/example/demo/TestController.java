package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ArrayList<Map<String, Object>> filterDocs(@RequestParam(value = "attachment_id", required = false) Long attachment_id,
            @RequestParam(value = "file_name", required = false) String file_name,
            @RequestParam(value = "project_name", required = false) String project_name,
            @RequestParam(value = "customer_name", required = false) String customer_name,
            @RequestParam(value = "commitment_period_id", required = false) Long commitment_period_id,
            @RequestParam(value = "resource_name", required = false) String resource_name) {
        

            List<Object> results = AttachmentFileService.queryForDocumentsOptional(attachment_id, file_name, project_name, customer_name, commitment_period_id, resource_name);
            ArrayList<Map<String, Object>> jsonResults = new ArrayList<>();

            for (Object result : results) {
                Map<String, Object> jsonResult = new HashMap<>();
                // Assuming result is an array of objects where each object corresponds to a column in the result set
                Object[] columns = (Object[]) result;
                jsonResult.put("proposalId","" + columns[0].toString());
                jsonResult.put("attachmentId","" + columns[1].toString());
                jsonResult.put("file_name","" + columns[2].toString());
                jsonResult.put("projectId","" + columns[3].toString());
                jsonResult.put("projectType","" + columns[4].toString());  
                jsonResult.put("customerId","" + columns[5].toString());
                jsonResult.put("resourceId","" + columns[6].toString());
                jsonResult.put("auctionId","" + columns[7].toString());
                jsonResult.put("periodId","" + columns[8].toString());
                jsonResult.put("id","" + columns[9].toString());
                jsonResult.put("comPeriodId","" + columns[10].toString());
                jsonResult.put("aucPeriodId","" + columns[11].toString());
                jsonResults.add(jsonResult);
            }

            return jsonResults;
    }

}

package com.example.demo;


import com.example.Model.attachmentFile;
import com.example.demo.AttachmentFileService;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class AttachmentFileServiceTests {
    @Test
    public void getAttachmentIdTest() {
        attachmentFile attachmentFile = new attachmentFile(BigDecimal.valueOf(1), "path", "name");
        assertEquals(BigDecimal.valueOf(1), attachmentFile.getAttachmentId(), "Attachment ID is 1");


    }


    @Test
    public void getFilePathTest() {
        attachmentFile attachmentFile = new attachmentFile(BigDecimal.valueOf(1), "path", "name");
        assertEquals("path", attachmentFile.getFilePath(), "File path is path");
    }


    @Test
    public void getFileNameTest() {
        attachmentFile attachmentFile = new attachmentFile(BigDecimal.valueOf(1), "path", "name");
        assertEquals("name", attachmentFile.getFileName(), "File name is name");
    }


    @Test
    public void setAttachmentIdTest() {
        attachmentFile attachmentFile = new attachmentFile(BigDecimal.valueOf(1), "path", "name");
        attachmentFile.setAttachmentId(BigDecimal.valueOf(2));
        assertEquals(BigDecimal.valueOf(2), attachmentFile.getAttachmentId(), "Attachment ID is 2");
    }


    @Test
    public void setFilePathTest() {
        attachmentFile attachmentFile = new attachmentFile(BigDecimal.valueOf(1), "path", "name");
        attachmentFile.setFilePath("newPath");
        assertEquals("newPath", attachmentFile.getFilePath(), "File path is newPath");
    }


    @Test
    public void setFileNameTest() {
        attachmentFile attachmentFile = new attachmentFile(BigDecimal.valueOf(1), "path", "name");
        attachmentFile.setFileName("newName");
        assertEquals("newName", attachmentFile.getFileName(), "File name is newName");
    }


    @Test
    public void queryForDocumentsTest() { // Test for queryForDocumentsOptional method for corresponding keys and values for the given parameters
        List<Map<String, Object>> jsonResults = AttachmentFileService.queryForDocumentsOptional(1001L, "Project docs.zip", "Gravity Works", "Lightening Power", 1L, "Big Generator", null, null, null, null);


        // Check if the list is not empty
        assertTrue(!jsonResults.isEmpty(), "The list of results is empty.");


        // Assuming each element is a Map<String, Object>, cast it
        Map<String, Object> resultMap = (Map<String, Object>) jsonResults.get(0);


        // Check if the map contains the keys and correct values
        assertTrue(resultMap.containsKey("periodId"), "Key 'periodId' not found in the map.");
        assertEquals("1", resultMap.get("periodId"), "Value of 'periodId' in the map is not 1.");
        assertTrue(resultMap.containsKey("resourceId"), "Key 'resourceId' not found in the map.");
        assertEquals("100", resultMap.get("resourceId"), "Value of 'resourceId' in the map is not 1.");
        assertTrue(resultMap.containsKey("aucCommitId"), "Key 'aucCommitId' not found in the map.");
        assertEquals("1", resultMap.get("aucCommitId"), "Value of 'aucCommitId' in the map is not 1.");
        assertTrue(resultMap.containsKey("attachmentType"), "Key 'attachmentType' not found in the map.");
        assertEquals("PROPOSAL.OTHERS", resultMap.get("attachmentType"));
        assertTrue(resultMap.containsKey("endDate"), "Key 'endDate' not found in the map.");
        assertEquals("2011-06-01", resultMap.get("endDate"), "Value of 'endDate' in the map is not 2020-01-01.");
        assertTrue(resultMap.containsKey("file_name"), "Key 'file_name' not found in the map.");
        assertEquals("Project docs.zip", resultMap.get("file_name"), "Value of 'file_name' in the map is not Project docs.zip.");
        assertTrue(resultMap.containsKey("projectType"), "Key 'projectType' not found in the map.");
        assertEquals("INCREMENTAL", resultMap.get("projectType"), "Value of 'projectType' in the map is not INCREMENTAL.");
        assertTrue(resultMap.containsKey("aucEndDate"), "Key 'aucEndDate' not found in the map.");
        assertEquals("2011-06-01", resultMap.get("aucEndDate"), "Value of 'aucEndDate' in the map is not 2011-06-01.");
        assertTrue(resultMap.containsKey("resourceName"), "Key 'resourceName' not found in the map.");
        assertEquals("Big Generator", resultMap.get("resourceName"), "Value of 'resourceName' in the map is not Big Generator.");
        assertTrue(resultMap.containsKey("custName"), "Key 'custName' not found in the map.");
        assertEquals("Lightening Power", resultMap.get("custName"), "Value of 'custName' in the map is not Lightening Power.");
        assertTrue(resultMap.containsKey("aucPeriodId"), "Key 'aucPeriodId' not found in the map.");
        assertEquals("1", resultMap.get("aucPeriodId"), "Value of 'aucPeriodId' in the map is not 1.");
        assertTrue(resultMap.containsKey("proposalId"), "Key 'proposalId' not found in the map.");
        assertEquals("111", resultMap.get("proposalId"), "Value of 'proposalId' in the map is not 111.");
        assertTrue(resultMap.containsKey("auctionId"), "Key 'auctionId' not found in the map.");
        assertEquals("1", resultMap.get("auctionId"), "Value of 'auctionId' in the map is not 1.");
        assertTrue(resultMap.containsKey("beginDate"), "Key 'beginDate' not found in the map.");
        assertEquals("2010-06-01", resultMap.get("beginDate"), "Value of 'beginDate' in the map is not 2010-06-01.");
        assertTrue(resultMap.containsKey("proposalLabel"), "Key 'proposalLabel' not found in the map.");
        assertEquals("CP 2010-11-FCA", resultMap.get("proposalLabel"), "Value of 'proposalLabel' in the map is not CP 2010-11-FCA.");
        assertTrue(resultMap.containsKey("periodType"), "Key 'periodType' not found in the map.");
        assertEquals("COMMITMENT", resultMap.get("periodType"), "Value of 'periodType' in the map is not COMMITMENT.");
        assertTrue(resultMap.containsKey("aucType"), "Key 'aucType' not found in the map.");
        assertEquals("FCA", resultMap.get("aucType"), "Value of 'aucType' in the map is not FCA.");
        assertTrue(resultMap.containsKey("customerId"), "Key 'customerId' not found in the map.");
        assertEquals("20", resultMap.get("customerId"), "Value of 'customerId' in the map is not 20.");
        assertTrue(resultMap.containsKey("attachmentId"), "Key 'attachmentId' not found in the map.");
        assertEquals("1001", resultMap.get("attachmentId"), "Value of 'attachmentId' in the map is not 1001.");
        assertTrue(resultMap.containsKey("projectName"), "Key 'projectName' not found in the map.");
        assertEquals("Gravity Works", resultMap.get("projectName"), "Value of 'projectName' in the map is not Gravity Works.");
        assertTrue(resultMap.containsKey("aucBeginDate"), "Key 'aucBeginDate' not found in the map.");
        assertEquals("2010-06-01", resultMap.get("aucBeginDate"), "Value of 'aucBeginDate' in the map is not 2010-06-01.");
        assertTrue(resultMap.containsKey("projectId"), "Key 'projectId' not found in the map.");
        assertEquals("2000", resultMap.get("projectId"), "Value of 'projectId' in the map is not 2000.");
        assertTrue(resultMap.containsKey("resourceType"), "Key 'resourceType' not found in the map.");
        assertEquals("GEN", resultMap.get("resourceType"), "Value of 'resourceType' in the map is not GEN.");
    }

}



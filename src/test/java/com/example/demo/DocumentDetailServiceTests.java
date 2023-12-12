package com.example.demo;


import com.example.Model.documentDetailReturn;
import com.example.Model.metaReturn;
import com.example.demo.DocumentDetailService;


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
public class DocumentDetailServiceTests {
    @Test
    public void getBase64Test() {
        documentDetailReturn documentDetailReturn = new documentDetailReturn("base64", null);
        assertEquals("base64", documentDetailReturn.getBase64(), "Base64 is base64");
    }

    @Test
    public void getMetaDataTest() {
        documentDetailReturn documentDetailReturn = new documentDetailReturn(null, null);
        assertEquals(null, documentDetailReturn.getMetaData(), "MetaData is null");
    }

    @Test
    public void setBase64Test() {
        documentDetailReturn documentDetailReturn = new documentDetailReturn("base64", null);
        documentDetailReturn.setBase64("newBase64");
        assertEquals("newBase64", documentDetailReturn.getBase64(), "Base64 is newBase64");
    }

    @Test
    public void setMetaDataTest() {
        documentDetailReturn documentDetailReturn = new documentDetailReturn(null, null);
        documentDetailReturn.setMetaData(null);
        assertEquals(null, documentDetailReturn.getMetaData(), "MetaData is null");
    }

    @Test
    public void testMeta() {
        DocumentDetailService documentDetailService = new DocumentDetailService();
        metaReturn metaData = documentDetailService.meta("documentName", "projectName", "projectType", "periodStart", "periodEnd", "periodType", "customer", "resource", "resourceType", "auctionType", "proposalLabel", "attachmentType", "aucBeginDate", "aucEndDate", 1.0f);
        assertEquals("documentName", metaData.getDocumentName(), "DocumentName is documentName");
        assertEquals("projectName", metaData.getProjectName(), "ProjectName is projectName");
        assertEquals("projectType", metaData.getProjectType(), "ProjectType is projectType");
        assertEquals("periodStart", metaData.getPeriodStart(), "PeriodStart is periodStart");
        assertEquals("periodEnd", metaData.getPeriodEnd(), "PeriodEnd is periodEnd");
        assertEquals("periodType", metaData.getPeriodType(), "PeriodType is periodType");
        assertEquals("customer", metaData.getCustomer(), "Customer is customer");
        assertEquals("resource", metaData.getResource(), "Resource is resource");
        assertEquals("resourceType", metaData.getResourceType(), "ResourceType is resourceType");
        assertEquals("auctionType", metaData.getAuctionType(), "AuctionType is auctionType");
        assertEquals("proposalLabel", metaData.getProposalLabel(), "ProposalLabel is proposalLabel");
        assertEquals("attachmentType", metaData.getAttachmentType(), "AttachmentType is attachmentType");
        assertEquals(1.0f, metaData.getFileSize(), "FileSize is 1.0f");
    }


}

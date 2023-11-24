package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.example.demo.DocumentComplete;

public public class Document {

    public Document() {
    }

    public Document(Long id, String name, String type, String comPeriodId, String aucPeriodId, String projectId, String projectType, String customerId, String resourceId, String auctionId, String periodId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.comPeriodId = comPeriodId;
        this.aucPeriodId = aucPeriodId;
        this.projectId = projectId;
        this.projectType = projectType;
        this.customerId = customerId;
        this.resourceId = resourceId;
        this.auctionId = auctionId;
        this.periodId = periodId;
    } 

    
}

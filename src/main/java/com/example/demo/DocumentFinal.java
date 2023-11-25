package com.example.demo;

public class DocumentFinal {
    private Long id;
    private String name;
    private String type;
    private String comPeriodId;
    private String aucPeriodId;
    private String projectId;
    private String projectType;
    private String customerId;
    private String resourceId;
    private String auctionId;
    private String periodId;

    public DocumentFinal(Long id, String name, String type, String comPeriodId, String aucPeriodId, String projectId, String projectType, String customerId, String resourceId, String auctionId, String periodId) {
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

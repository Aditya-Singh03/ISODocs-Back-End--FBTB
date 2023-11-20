package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proposal_info")
public class ProposalInfo {
    @Id
    @Column (name = "proposal_id")
    public Long id;

    @Column (name = "project_id")
    public String projectId;

    @Column (name = "project_type")
    public String projectType;

    @Column (name = "customer_id")
    public String customerId;

    @Column (name = "resource_id")
    public String resourceId;

    @Column (name = "auction_id")
    public String auctionId;

    @Column (name = "period_id")
    public String periodId;

    public ProposalInfo(){
    }

    public ProposalInfo(String projectId, String projectType, String customerId, String resourceId, String auctionId, String periodId){
        this.projectId = projectId;
        this.projectType = projectType;
        this.customerId = customerId;
        this.resourceId = resourceId;
        this.auctionId = auctionId;
        this.periodId = periodId;
    }

    public String getProjectId(){
        return this.projectId;
    }

    public String getProjectType(){
        return this.projectType;
    }

    public String getCustomerId(){
        return this.customerId;
    }

    public String getResourceId(){
        return this.resourceId;
    }

    public String getAuctionId(){
        return this.auctionId;
    }

    public String getPeriodId(){
        return this.periodId;
    }

    public void setProjectId(String projectId){
        this.projectId = projectId;
    }

    public void setProjectType(String projectType){
        this.projectType = projectType;
    }

    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }

    public void setResourceId(String resourceId){
        this.resourceId = resourceId;
    }

    public void setAuctionId(String auctionId){
        this.auctionId = auctionId;
    }

    public void setPeriodId(String periodId){
        this.periodId = periodId;
    }
    
}

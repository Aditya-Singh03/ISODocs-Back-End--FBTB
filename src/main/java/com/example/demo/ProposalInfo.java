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
    public Long projectId;

    @Column (name = "project_type")
    public String projectType;

    @Column (name = "customer_id")
    public Long customerId;

    @Column (name = "resource_id")
    public Long resourceId;

    @Column (name = "auction_id")
    public Long auctionId;

    @Column (name = "period_id")
    public Long periodId;

    @Column (name = "proposal_label")
    public String proposalLabel;

    public ProposalInfo(){
    }

    public ProposalInfo(Long projectId, String projectType, Long customerId, Long resourceId, Long auctionId, Long periodId){
        this.projectId = projectId;
        this.projectType = projectType;
        this.customerId = customerId;
        this.resourceId = resourceId;
        this.auctionId = auctionId;
        this.periodId = periodId;
    }

    public Long getProjectId(){
        return this.projectId;
    }

    public String getProjectType(){
        return this.projectType;
    }

    public Long getCustomerId(){
        return this.customerId;
    }

    public Long getResourceId(){
        return this.resourceId;
    }

    public Long getAuctionId(){
        return this.auctionId;
    }

    public Long getPeriodId(){
        return this.periodId;
    }

    public void setProjectId(Long projectId){
        this.projectId = projectId;
    }

    public void setProjectType(String projectType){
        this.projectType = projectType;
    }

    public void setCustomerId(Long customerId){
        this.customerId = customerId;
    }

    public void setResourceId(Long resourceId){
        this.resourceId = resourceId;
    }

    public void setAuctionId(Long auctionId){
        this.auctionId = auctionId;
    }

    public void setPeriodId(Long periodId){
        this.periodId = periodId;
    }

    public String getProposalLabel(){
        return this.proposalLabel;
    }

    public void setProposalLabel(String proposalLabel){
        this.proposalLabel = proposalLabel;
    }
    
}

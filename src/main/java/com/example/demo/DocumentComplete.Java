package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cust_info")
public class Customer {
    
    @Id
    @Column (name = "customer_id")
    public Long id;

    @Column (name = "customer_name")
    public String customer_name;

    public Customer(){
    }

    public Customer(String customer_name){
        this.customer_name = customer_name;
    }

    public String getCustomerName(){
        return this.customer_name;
    }

    public void setCustomerName(String customer_name){
        this.customer_name = customer_name;
    }
}

@Entity
@Table(name = "attachment_file")
public class Attachment {

    @Id
    @Column (name = "attachment_id")
    public Long id;

    @Column (name = "file_name")
    public String name;

    public Attachment(){
    }

    public Attachment(String docName){
        this.name = docName;
    }
    
    public String getDocName(){
        return this.name;
    }

    public void setDocName(String docName){
        this.name = docName;
    }
}

@Entity
@Table(name = "auc_info")
public class AuctionInfo {
    @Id
    @Column (name = "auction_id")
    public Long id;

    @Column (name = "commitment_period_id")
    public String comPeriodId;

    @Column (name = "auction_period_id")
    public String aucPeriodId;

    public AuctionInfo(){
    }

    public AuctionInfo(String comPeriodId, String aucPeriodId){
        this.comPeriodId = comPeriodId;
        this.aucPeriodId = aucPeriodId;
    }

    public String getComPeriodId(){
        return this.comPeriodId;
    }

    public String getAucPeriodId(){
        return this.aucPeriodId;
    }

    public void setComPeriodId(String comPeriodId){
        this.comPeriodId = comPeriodId;
    }

    public void setAucPeriodId(String aucPeriodId){
        this.aucPeriodId = aucPeriodId;
    }
}

@Entity
@Table(name = "auc_type")
public class AuctionType {

    @Id
    @Column (name = "auction_type")
    public String type;

    public AuctionType(){
    }

    public AuctionType(String type){
        this.type = type;
    }

    public String getAuctionType(){
        return this.type;
    }

    public void setAuctionType(String type){
        this.type = type;
    }
    
}

@Entity
@Table(name = "proj_info")
public class ProjectInfo {
    @Id
    @Column (name = "project_id")
    public Long id;

    @Column (name = "project_name")
    public String name;

    public ProjectInfo(){
    }

    public ProjectInfo(String name){
        this.name = name;
    }

    public String getProjectInfoName(){
        return this.name;
    }

    public void setProjectInfoName(String name){
        this.name = name;
    }
}

@Entity
@Table(name = "proj_type")
public class ProjectType {

    @Id
    @Column (name = "project_type")
    public String type;

    public ProjectType(){
    }
    
}

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

@Entity
@Table(name = "res_info")
public class ResourceInfo {
    @Id
    @Column (name = "resource_id")
    public Long id;

    @Column (name = "resource_name")
    public String name;

    public ResourceInfo(){
    }

    public ResourceInfo(String name){
        this.name = name;
    }

    public String getResourceInfoName(){
        return this.name;
    }

    public void setResourceInfoName(String name){
        this.name = name;
    }
    
}

@Entity
public class AttachPropPrimaryKey {
    @Id
    @Column(name = "proposal_id")
    private Long proposalId;

    @Id
    @Column(name = "attachment_id")
    private Long attachmentId;

    @Column (name = "attachment_type")
    public String attachment_type;

    public AttachPropPrimaryKey() {
    }

    public AttachPropPrimaryKey(Long proposalId, Long attachmentId, String attachment_type) {
        this.proposalId = proposalId;
        this.attachmentId = attachmentId;
        this.attachment_type = attachment_type;
    }

    public Long getProposalId() {
        return this.proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public Long getAttachmentId() {
        return this.attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachment_type() {
        return this.attachment_type;
    }

    public void setAttachment_type(String attachment_type) {
        this.attachment_type = attachment_type;
    }
}





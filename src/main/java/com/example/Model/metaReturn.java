package com.example.Model;

public class metaReturn {
    private String documentName;
    private String projectName;
    private String projectType;
    private String periodStart;
    private String periodEnd;
    private String periodType;
    private String customer;
    private String resource;
    private String resourceType;
    private String auctionType;
    private String proposalLabel;
    private String attachmentType;
    private String auctionBeginDate;
    private String auctionEndDate;
    private long fileSize;

    public metaReturn(String documentName, String projectName, String projectType, String periodStart, String periodEnd, String periodType, String customer, String resource, String resourceType, String auctionType, String proposalLabel, String attachmentType, String auctionBeginDate, String auctionEndDate, long fileSize){
        this.documentName=documentName;
        this.projectName=projectName;
        this.projectType=projectType;
        this.periodStart=periodStart;
        this.periodEnd=periodEnd;
        this.periodType=periodType;
        this.customer=customer;
        this.resource=resource;
        this.resourceType=resourceType;
        this.auctionType=auctionType;
        this.proposalLabel=proposalLabel;
        this.attachmentType=attachmentType;
        this.auctionBeginDate=auctionBeginDate;
        this.auctionEndDate=auctionEndDate;
        this.fileSize=fileSize;
    }

    public void setDocumentName(String str){
        documentName=str;
    }

    public String getDocumentName(){
        return documentName;
    }

    public void setProjectName(String str){
        projectName=str;
    }

    public String getProjectName(){
        return projectName;
    }

    public void setProjectType(String str){
        projectType=str;
    }

    public String getProjectType(){
        return projectType;
    }

    public void setPeriodStart(String str){
        periodStart=str;
    }

    public String getPeriodStart(){
        return periodStart;
    }

    public void setPeriodEnd(String str){
        periodEnd=str;
    }

    public String getPeriodEnd(){
        return periodEnd;
    }

    public void setPeriodType(String str){
        periodType=str;
    }

    public String getPeriodType(){
        return periodType;
    }

    public void setCustomer(String str){
        customer=str;
    }

    public String getCustomer(){
        return customer;
    }

    public void setResource(String str){
        resource=str;
    }

    public String getResource(){
        return resource;
    }

    public void setResourceType(String str){
        resourceType=str;
    }

    public String getResourceType(){
        return resourceType;
    }

    public void setAuctionType(String str){
        auctionType=str;
    }

    public String getAuctionType(){
        return auctionType;
    }

    public void setProposalLabel(String str){
        proposalLabel=str;
    }

    public String getProposalLabel(){
        return proposalLabel;
    }

    public void setAttachmentType(String str){
        attachmentType=str;
    }

    public String getAttachmentType(){
        return attachmentType;
    }

    public void setAuctionBeginDate(String aucBeginDate) {
        auctionBeginDate=aucBeginDate;
    }

    public String getAuctionBeginDate() {
        return auctionBeginDate;
    }

    public void setAuctionEndDate(String aucEndDate) {
        auctionEndDate=aucEndDate;
    }

    public String getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setFileSize(long size){
        fileSize=size;
    }

    public long getFileSize(){
        return fileSize;
    }
}

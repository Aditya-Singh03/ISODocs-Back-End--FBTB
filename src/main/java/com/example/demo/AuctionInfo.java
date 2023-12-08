package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "auc_info")
public class AuctionInfo {
    @Id
    @Column (name = "auction_id")
    public Long id;

    @Column (name = "commitment_period_id")
    public Long comPeriodId;

    @Column (name = "auction_period_id")
    public Long aucPeriodId;

    @Column (name = "auction_type")
    public String type;

    @Column (name = "auction_begin_date")
    public String beginDate;

    @Column (name = "auction_end_date")
    public String endDate;   

    public AuctionInfo(){
    }

    public AuctionInfo(Long comPeriodId, Long aucPeriodId){
        this.comPeriodId = comPeriodId;
        this.aucPeriodId = aucPeriodId;
    }

    public Long getComPeriodId(){
        return this.comPeriodId;
    }

    public Long getAucPeriodId(){
        return this.aucPeriodId;
    }

    public String getAuctionType(){
        return this.type;
    }

    public String getAucBeginDate() {
        return this.beginDate;
    }

    public String getAucEndDate() {
        return this.endDate;
    }

    public void setComPeriodId(Long comPeriodId){
        this.comPeriodId = comPeriodId;
    }

    public void setAucPeriodId(Long aucPeriodId){
        this.aucPeriodId = aucPeriodId;
    }

    public void setAuctionType(String type){
        this.type = type;
    }

    public void setAucBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public void setAucEndDate(String endDate) {
        this.endDate = endDate;
    }
}

package com.example.demo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

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

    @Column(name = "auction_begin_date")
    @Temporal(TemporalType.DATE)
    public Date aucBeginDate;

    @Column(name = "auction_end_date")
    @Temporal(TemporalType.DATE)
    public Date aucEndDate;

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

    public Date getAucBeginDate() {
        return this.aucBeginDate;
    }

    public Date getAucEndDate() {
        return this.aucEndDate;
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

    public void setAucBeginDate(Date beginDate) {
        this.aucBeginDate = beginDate;
    }

    public void setAucEndDate(Date endDate) {
        this.aucEndDate = endDate;
    }
}

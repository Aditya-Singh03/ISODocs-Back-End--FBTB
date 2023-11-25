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

    public void setComPeriodId(Long comPeriodId){
        this.comPeriodId = comPeriodId;
    }

    public void setAucPeriodId(Long aucPeriodId){
        this.aucPeriodId = aucPeriodId;
    }

    public void setAuctionType(String type){
        this.type = type;
    }
}

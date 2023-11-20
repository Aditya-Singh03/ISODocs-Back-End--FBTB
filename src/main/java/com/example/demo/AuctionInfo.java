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

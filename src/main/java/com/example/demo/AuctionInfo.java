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

<<<<<<< HEAD
    @Column (name = "auction_begin_date")
    public String beginDate;

    @Column (name = "auction_end_date")
    public String endDate;   
=======
    @Column(name = "auction_begin_date")
    @Temporal(TemporalType.DATE)
    public Date aucBeginDate;

    @Column(name = "auction_end_date")
    @Temporal(TemporalType.DATE)
    public Date aucEndDate;
>>>>>>> 89f12f5c5e19421e7f607ce0eee2d9114b203bcf

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

<<<<<<< HEAD
    public String getAucBeginDate() {
        return this.beginDate;
    }

    public String getAucEndDate() {
        return this.endDate;
=======
    public Date getAucBeginDate() {
        return this.aucBeginDate;
    }

    public Date getAucEndDate() {
        return this.aucEndDate;
>>>>>>> 89f12f5c5e19421e7f607ce0eee2d9114b203bcf
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

<<<<<<< HEAD
    public void setAucBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public void setAucEndDate(String endDate) {
        this.endDate = endDate;
=======
    public void setAucBeginDate(Date beginDate) {
        this.aucBeginDate = beginDate;
    }

    public void setAucEndDate(Date endDate) {
        this.aucEndDate = endDate;
>>>>>>> 89f12f5c5e19421e7f607ce0eee2d9114b203bcf
    }
}

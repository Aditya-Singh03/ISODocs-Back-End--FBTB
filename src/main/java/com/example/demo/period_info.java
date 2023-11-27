package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "period_info")
public class period_info {
    @Id
    @Column (name = "period_id")
    public Long id;

    @Column (name = "begin_date")
    public String beginDate;
    
    @Column (name = "end_date")
    public String endDate;

    @Column (name = "period_type")
    public String periodType;

    public period_info(){
    }

    public period_info(Long id, String beginDate, String endDate){
        this.id = id;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public String getBeginDate(){
        return this.beginDate;
    }

    public void setBeginDate(String beginDate){
        this.beginDate = beginDate;
    }

    public String getEndDate(){
        return this.beginDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    public String getPeriodType(){
        return this.periodType;
    }

    public void setPeriodType(String periodType){
        this.periodType = periodType;
    }
}
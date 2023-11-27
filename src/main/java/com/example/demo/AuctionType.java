package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

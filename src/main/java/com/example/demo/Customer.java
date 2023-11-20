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


package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
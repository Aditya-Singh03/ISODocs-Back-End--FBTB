package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proj_info")
public class ProjectInfo {
    @Id
    @Column (name = "project_id")
    public Long id;

    @Column (name = "project_name")
    public String name;

    public ProjectInfo(){
    }

    public ProjectInfo(String name){
        this.name = name;
    }

    public String getProjectInfoName(){
        return this.name;
    }

    public void setProjectInfoName(String name){
        this.name = name;
    }
}

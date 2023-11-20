package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proj_type")
public class ProjectType {

    @Id
    @Column (name = "project_type")
    public String type;

    public ProjectType(){
    }
    
}

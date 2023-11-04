package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @Column (name = "docName")
    public String name;

    @Column (name = "searchParameters")
    public String[] searchParameters;

    public Document(){
    }

    public Document(String docName, String[] searchParameters){
        this.name = docName;
        this.searchParameters = searchParameters;
    }
    
    public String getDocName(){
        return this.name;
    }

    public String[] getSearchParameters(){
        return this.searchParameters;
    }

    public void setDocName(String docName){
        this.name = docName;
    }

    public void setSearchParameters(String[] searchParameters){
        this.searchParameters = searchParameters;
    }
}

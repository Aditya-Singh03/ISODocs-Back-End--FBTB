package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "attachment_file")
public class Attachment {

    @Id
    @Column (name = "attachment_id")
    public Long id;

    @Column (name = "file_name")
    public String name;

    @Column (name = "file_path")
    public String path;


    public Attachment(){
    }

    public Attachment(String docName){
        this.name = docName;
    }
    
    public String getDocName(){
        return this.name;
    }

    public void setDocName(String docName){
        this.name = docName;
    }

    public String getPath(){
        return this.path;
    }

    public void setPath(String path){
        this.path = path;
    }
}

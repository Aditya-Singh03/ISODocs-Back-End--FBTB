package com.example.demo;


import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, String> {
    public Document findByName(String docName);
}
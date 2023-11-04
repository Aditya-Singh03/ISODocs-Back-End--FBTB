package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jakarta.transaction.Transactional;

@RestController
public class DocumentQuery{
    @Autowired
    private final DocumentRepository documentRepository;

    public DocumentQuery(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping("/documents/all")
    public Iterable<Document> findAllDocs() {
        return this.documentRepository.findAll();
    }

    @GetMapping("/documents/{name}")
    public Document findByName(@PathVariable String docName) {
        System.out.println("SEARCHING");
        return this.documentRepository.findByName(docName);
    }

    //Should we add an endpoint which gets the document/s based on id parameter?

    @GetMapping("/documents/{searchParameters}")
    public ArrayList<Document> findByParameterDocuments(@PathVariable String[] searchParameters){
        java.util.Iterator<Document> docs = this.documentRepository.findAll().iterator();
        ArrayList<Document> docList = new ArrayList<>();
        while(docs.hasNext()){
            Document document = docs.next();
            for(int i = 0; i < searchParameters.length; ++i){
                if (Arrays.asList(document.getSearchParameters()).contains(searchParameters[i])){
                    docList.add(document);
                } 
            }
        }
        return docList;
    }

    @PostMapping("/documents/add")
    public Document addDocument(@RequestBody Document newDocument) {
        String docName = newDocument.getDocName();
        String[] parameters = newDocument.getSearchParameters();
        Document document = new Document(docName, parameters);
        return this.documentRepository.save(document);
    }
}
package com.example.demo;
// package com.example.demo;

// import java.util.ArrayList;
// import java.util.Arrays;

// import javax.swing.text.html.HTMLDocument.Iterator;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

// import jakarta.transaction.Transactional;

// @RestController
// public class AttachmentQuery{
//     @Autowired
//     private final AttachmentRepository documentRepository;

//     public AttachmentQuery(AttachmentRepository documentRepository) {
//         this.documentRepository = documentRepository;
//     }

//     @GetMapping("/documents/all")
//     public Iterable<Attachment> findAllDocs() {
//         return this.documentRepository.findAll();
//     }

//    // @GetMapping("/documents/{name}")
//    // public Attachment findByName(@PathVariable String docName) {
//      //   System.out.println("SEARCHING");
//        // return this.documentRepository.findByName(docName);
//    // }

//     //Should we add an endpoint which gets the document/s based on id parameter?


//     @PostMapping("/documents/add")
//     public Attachment addDocument(@RequestBody Attachment newDocument) {
//         String docName = newDocument.getDocName();
//         Attachment document = new Attachment(docName);
//         return this.documentRepository.save(document);
//     }
// }
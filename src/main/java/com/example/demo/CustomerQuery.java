// package com.example.demo;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import javax.swing.text.html.HTMLDocument.Iterator;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import jakarta.transaction.Transactional;

// @RestController
// @RequestMapping("/customers")
// public class CustomerQuery {
//     private final CustomerRepository customerRepository;
    
//     @Autowired
//     public CustomerQuery(CustomerRepository customerRepository) {
//         this.customerRepository = customerRepository;
//     }

//     @GetMapping("/{customer_name}")
//     public ResponseEntity<List<Customer>> findByName(@PathVariable String customer_name) {
//         System.out.println("SEARCHING");
//         List<Customer> customers = this.customerRepository.findByName(customer_name);
//          if (customers.isEmpty()) {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         } else {
//             return new ResponseEntity<>(customers, HttpStatus.OK);
//         }
//     }
//     }

//     //Should we add an endpoint which gets the customer/s based on id parameter?
    

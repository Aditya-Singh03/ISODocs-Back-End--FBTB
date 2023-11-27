// package com.example.demo;

// import java.util.List;

// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface CustomerRepository extends JpaRepository<Customer, Long> {
//     @Query("SELECT c FROM Customer c WHERE LOWER(c.customer_name) = LOWER(:customer_name)")
//     //List<Customer> findCustomerByName(@Param("customer_name") String customer_name);
//     public List<Customer> findByName(@Param("customer_name") String customer_name);
// }
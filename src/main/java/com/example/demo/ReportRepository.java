// package com.example.demo;
// import java.util.List;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.stereotype.Component;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.Persistence;
// import jakarta.persistence.Query;


// // @Component
// public class ReportRepository {
//     // @Autowired
//     private final EntityManagerFactory emf;

//     public ReportRepository() {
//         // create an instance of entity manager factory
//         this.emf = Persistence.createEntityManagerFactory("PERSISTENCE");
//     }

//     // @Bean
//     public List<Object[]> find() {
//         EntityManager entityManager = emf.createEntityManager();
//         Query query = entityManager.createQuery("select af.file_name as \"documentName\", proj_i.project_name as \"projectName\", pi.project_type as \"projectType\", ci.customer_name as \"customer\", ri.resource_name as \"resource\", ri.resource_type as \"resourceType\", ai.auction_begin_date as \"startDate\", ai.auction_end_date as \"endDate\", period_i.period_type as \"periodType\", ai.auction_type as \"auctionType\", pi.proposal_label as \"proposalLabel\", ap.attachment_type as \"attachmentType\"from attach_proposal as ap join attachment_file as af on ap.attachment_id = af.attachment_id join proposal_info as pi on ap.proposal_id = pi.proposal_id join proj_info as proj_i on pi.project_id = proj_i.project_id join cust_info as ci on pi.customer_id = ci.customer_id join res_info as ri on pi.resource_id = ri.resource_id join auc_info as ai on pi.auction_id = ai.auction_id join period_info as period_i on ai.auction_period_id = period_i.period_id where proj_i.project_name = 'Gravity Works'");

//         return query.getResultList();
//     }



// }
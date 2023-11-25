package com.example.demo;

// import java.util.List;



// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;
// import com.example.demo.DocumentEntities.AttachPropPrimaryKey;


// @Repository
// public interface DocumentCustomRepository extends JpaRepository<AttachPropPrimaryKey, Long> {
//     @Query("SELECT a.proposal_id, a.attachment_id, file.file_name, prop.project_id, prop.project_type, prop.customer_id," +
//             "prop.resource_id, prop.auction_id, prop.period_id, auc.auction_id, auc.commitment_period_id, auc.auction_period_id," +
//             "auc.auction_type, proj.project_name, res.resource_name, cust.customer_name" +
//             "FROM attach_proposal a" +
//             "JOIN attachment_file file ON a.attachment_id = file.attachment_id" +
//             "JOIN proposal_info prop on a.proposal_id = prop.proposal_id" +
//             "JOIN auc_info auc on prop.auction_id = auc.auction_id" +
//             "JOIN proj_info proj on prop.project_id = proj.project_id" +
//             "JOIN res_info res ON prop.resource_id = res.resource_id" +
//             "JOIN cust_info cust ON prop.customer_id = cust.customer_id" +
//             "WHERE LOWER(a.attachment_id) = LOWER(:attachment_id) AND (:file_name IS NULL OR LOWER(file.file_name) = LOWER(:file_name)) AND" +
//             "(:project_name IS NULL OR LOWER(proj.project_name) = LOWER(:project_name))" +
//             "AND (:customer_name IS NULL OR LOWER(cust.customer_name) = LOWER(:customer_name) AND" +
//             "(:commitment_period_id IS NULL OR LOWER(auc.commitment_period_id) = LOWER(:commitment_period_id))" +
//             "AND (:resource_name IS NULL OR LOWER(res.resource_name) = LOWER(:resource_name));")
//     //List<Customer> findCustomerByName(@Param("customer_name") String customer_name);
//     public List<DocumentFinal> findByParameters(@Param("attachment_id") String attachment_id, @Param("file_name") String file_name, @Param("project_name") String project_name, @Param("customer_name") String customer_name, @Param("commitment_period_id") String commitment_period_id, @Param("resource_name") String resource_name);
// }
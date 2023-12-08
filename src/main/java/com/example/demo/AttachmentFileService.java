package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

// import java.text.SimpleDateFormat;
import org.antlr.v4.runtime.atn.SemanticContext.OR;
import org.springframework.stereotype.Service;



import jakarta.persistence.EntityManager;

@Service
public class AttachmentFileService {
    public static List<Object> queryForDocuments(Long attachment_id, String file_name, String project_name, String customer_name, Long commitment_period_id, String resource_name) {
        EntityManager em = EntityService.getEntityManagerFactory();
        List<Object> var = em.createQuery("SELECT a.proposalId, a.attachmentId, file.name, prop.projectId, prop.projectType, prop.customerId, " +
        "prop.resourceId, prop.auctionId, prop.periodId, auc.id, auc.comPeriodId, auc.aucPeriodId, " +
        "auc.type, proj.name, res.name, cust.name,  " +
        "FROM AttachPropPrimaryKey a " +
        "JOIN Attachment file ON a.attachmentId = file.id " +
        "JOIN ProposalInfo prop ON a.proposalId = prop.id " +
        "JOIN AuctionInfo auc ON prop.auctionId = auc.id " +
        "JOIN ProjectInfo proj ON prop.projectId = proj.id " +
        "JOIN ResourceInfo res ON prop.resourceId = res.id " +
        "JOIN Customer cust ON prop.customerId = cust.id " +
        "WHERE (a.attachmentId) = (:attachment_id) AND " +
        "(:file_name IS NULL OR (file.name) = (:file_name)) " +
        "AND (:project_name IS NULL OR proj.name LIKE :project_name) " +
        "AND (:customer_name IS NULL OR (cust.name) LIKE '%' || (:customer_name) || '%') " +
        "AND (:commitment_period_id IS NULL OR auc.comPeriodId = :commitment_period_id) " +
        "AND (:resource_name IS NULL OR (res.name) = (:resource_name))")
        .setParameter("attachment_id", attachment_id)
        .setParameter("file_name", file_name)
        .setParameter("project_name", project_name)
        .setParameter("customer_name", customer_name)
        .setParameter("commitment_period_id", commitment_period_id)
        .setParameter("resource_name", resource_name)
        .getResultList();
        return var;
    }
    
    public static ArrayList<Map<String, Object>> queryForDocumentsOptional(Long attachment_id, String file_name, String project_name, String customer_name, Long commitment_period_id, String resource_name,
                                                                            String auc_begin_date, String auc_end_date, String proposal_label, String auction_type) {
        EntityManager em = EntityService.getEntityManagerFactory();
        // SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy");
        // java.sql.Date aucBeginDate = null;
        // java.sql.Date aucEndDate = null;
        // try {
        //     aucBeginDate = java.sql.Date.valueOf(auc_begin_date);
        //     aucEndDate = java.sql.Date.valueOf(auc_end_date);
        // } catch(Exception e) {
        // }
        List<Object> var = em.createQuery("SELECT a.proposalId, a.attachmentId, file.name, prop.projectId, prop.projectType, prop.customerId, " +
        "prop.resourceId, prop.auctionId, prop.periodId, auc.id, auc.comPeriodId, auc.aucPeriodId, " +
        "auc.type, proj.name, res.name, cust.name, file.path, a.attachment_type, prop.proposalLabel, res.resType, period_info.beginDate, period_info.endDate, period_info.periodType, auc.aucBeginDate, auc.aucEndDate " +
        "FROM AttachPropPrimaryKey a " +
        "JOIN Attachment file ON a.attachmentId = file.id " +
        "JOIN ProposalInfo prop ON a.proposalId = prop.id " +
        "JOIN AuctionInfo auc ON prop.auctionId = auc.id " +
        "JOIN ProjectInfo proj ON prop.projectId = proj.id " +
        "JOIN ResourceInfo res ON prop.resourceId = res.id " +
        "JOIN Customer cust ON prop.customerId = cust.id " +
        "JOIN period_info period_info ON auc.comPeriodId = period_info.id " +
        "WHERE (:attachment_id IS NULL OR a.attachmentId = :attachment_id) AND " +
        "(:file_name IS NULL OR file.name = :file_name) " +
        "AND (:project_name IS NULL OR proj.name LIKE :project_name) " +
        "AND (:customer_name IS NULL OR cust.name = :customer_name) " +
        "AND (:commitment_period_id IS NULL OR auc.comPeriodId = :commitment_period_id) " +
        "AND (:resource_name IS NULL OR res.name = :resource_name) " +
        "AND (:auc_begin_date IS NULL OR auc.aucBeginDate BETWEEN " + auc_begin_date + " AND " + auc_end_date + ") " +
        "AND (:auc_end_date IS NULL OR auc.aucBeginDate BETWEEN " + auc_begin_date + " AND " + auc_end_date + ") " +
        "AND (:proposal_label IS NULL OR prop.proposalLabel = :proposal_label) " +
        "AND (:auction_type IS NULL OR auc.type = :auction_type)")
        .setParameter("attachment_id", attachment_id)
        .setParameter("file_name", file_name)
        .setParameter("project_name", project_name)
        .setParameter("customer_name", customer_name)
        .setParameter("commitment_period_id", commitment_period_id)
        .setParameter("resource_name", resource_name)
        .setParameter("auc_begin_date", auc_begin_date)
        .setParameter("auc_end_date", auc_end_date)
        .setParameter("proposal_label", proposal_label)
        .setParameter("auction_type", auction_type)
        .getResultList();
        
        ArrayList<Map<String, Object>> jsonResults = new ArrayList<>();

            for (Object result : var) {
                Map<String, Object> jsonResult = new HashMap<>();
                // Assuming result is an array of objects where each object corresponds to a column in the result set
                Object[] columns = (Object[]) result;
                jsonResult.put("proposalId","" + columns[0].toString());
                jsonResult.put("attachmentId","" + columns[1].toString());
                jsonResult.put("file_name","" + columns[2].toString());
                jsonResult.put("projectId","" + columns[3].toString());
                jsonResult.put("projectType","" + columns[4].toString());  
                jsonResult.put("customerId","" + columns[5].toString());
                jsonResult.put("resourceId","" + columns[6].toString());
                jsonResult.put("auctionId","" + columns[7].toString());
                jsonResult.put("periodId","" + columns[8].toString());
                jsonResult.put("auctionId","" + columns[9].toString());
                jsonResult.put("aucCommitId","" + columns[10].toString());
                jsonResult.put("aucPeriodId","" + columns[11].toString());
                jsonResult.put("aucType","" + columns[12].toString());
                jsonResult.put("projectName","" + columns[13].toString());
                jsonResult.put("resourceName","" + columns[14].toString());
                jsonResult.put("custName","" + columns[15].toString());
                jsonResult.put("filePath","" + columns[16].toString());
                jsonResult.put("attachmentType","" + columns[17].toString());
                jsonResult.put("proposalLabel","" + columns[18].toString());
                jsonResult.put("resourceType","" + columns[19].toString());
                jsonResult.put("beginDate","" + columns[20].toString());
                jsonResult.put("endDate","" + columns[21].toString());
                jsonResult.put("periodType","" + columns[22].toString());
                jsonResult.put("aucBeginDate","" + columns[23].toString());
                jsonResult.put("aucEndDate","" + columns[24].toString());

                
                jsonResults.add(jsonResult);
            }

            return jsonResults;

    }

}

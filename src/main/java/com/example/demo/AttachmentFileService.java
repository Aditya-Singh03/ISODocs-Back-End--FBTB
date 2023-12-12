package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import java.text.SimpleDateFormat;
import org.antlr.v4.runtime.atn.SemanticContext.OR;
import org.springframework.stereotype.Service;



import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TemporalType;

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
                                                                            String auc_begin_date, String auc_end_date, String proposal_label, String auction_type, int page, int pageSize, String sortBy) {
        EntityManager em = EntityService.getEntityManagerFactory();
        file_name = file_name == null ? null : "%"+file_name+"%";
        customer_name = customer_name == null ? null : "%"+customer_name+"%";
        project_name = project_name == null ? null : "%"+project_name+"%";
        resource_name = resource_name == null ? null : "%"+resource_name+"%";
        proposal_label = proposal_label == null ? null : "%"+proposal_label+"%";
        auction_type = auction_type == null ? null : "%"+auction_type+"%";
        SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy");
        java.sql.Date aucBeginDate = null;
        java.sql.Date aucEndDate = null;
        java.util.Date begin_date = null;
        java.util.Date end_date = null;
        if (auc_begin_date != null) {
            try {
                begin_date = formatter.parse(auc_begin_date);
                aucBeginDate = new java.sql.Date(begin_date.getTime());
            } catch(Exception e) {
                throw new IllegalStateException("Can not parse begin date");
            }
        }
        if (auc_end_date != null) {
            try {
                end_date = formatter.parse(auc_end_date);
                aucEndDate = new java.sql.Date(end_date.getTime());
            } catch(Exception e) {
                throw new IllegalStateException("Can not parse end date");
            }
        }

        String query = "SELECT a.proposalId, a.attachmentId, file.name, prop.projectId, prop.projectType, prop.customerId, " +
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
        "(:file_name IS NULL OR LOWER(file.name) LIKE :file_name) " +
        "AND (:project_name IS NULL OR LOWER(proj.name) LIKE :project_name) " +
        "AND (:customer_name IS NULL OR LOWER(cust.name) LIKE :customer_name) " +
        "AND (:commitment_period_id IS NULL OR auc.comPeriodId = :commitment_period_id) " +
        "AND (:resource_name IS NULL OR LOWER(res.name) LIKE :resource_name) " +
        "AND (CAST(:auc_begin_date AS DATE) IS NULL OR (auc.aucBeginDate >= :auc_begin_date AND auc.aucEndDate >= :auc_begin_date)) " +
        "AND (CAST(:auc_end_date AS DATE) IS NULL OR (auc.aucBeginDate <= :auc_end_date AND auc.aucEndDate <= :auc_end_date)) " +
        "AND (:proposal_label IS NULL OR LOWER(prop.proposalLabel) LIKE :proposal_label) " +
        "AND (:auction_type IS NULL OR auc.type = :auction_type) ";

        if (sortBy.equals("attachment_id")) {
            query += "ORDER BY a.attachmentId ASC";
        } else if (sortBy.equals("file_name")) {
            query += "ORDER BY LOWER(file.name) ASC";
        } else if (sortBy.equals("project_name")) {
            query += "ORDER BY LOWER(proj.name) ASC";
        } else if (sortBy.equals("customer_name")) {
            query += "ORDER BY LOWER(cust.name) ASC";
        } else if (sortBy.equals("commitment_period_id")) {
            query += "ORDER BY auc.comPeriodId ASC";
        } else if (sortBy.equals("resource_name")) {
            query += "ORDER BY LOWER(res.name) ASC";
        } else if (sortBy.equals("auc_begin_date")) {
            query += "ORDER BY auc.aucBeginDate ASC";
        } else if (sortBy.equals("auc_end_date")) {
            query += "ORDER BY auc.aucEndDate ASC";
        } else if (sortBy.equals("proposal_label")) {
            query += "ORDER BY prop.proposalLabel ASC";
        } else if (sortBy.equals("auction_type")) {
            query += "ORDER BY auc.type ASC";
        } else {
            query += "ORDER BY a.attachmentId ASC";
        }

        // query += "ORDER BY a.attachmentId ASC";

        List<Object> var = em.createQuery(query)
        .setParameter("attachment_id", attachment_id)
        .setParameter("file_name", file_name == null ? null : file_name.toLowerCase())
        .setParameter("project_name", project_name == null ? null : project_name.toLowerCase())
        .setParameter("customer_name", customer_name == null ? null : customer_name.toLowerCase())
        .setParameter("commitment_period_id", commitment_period_id)
        .setParameter("resource_name", resource_name == null ? null : resource_name.toLowerCase())
        .setParameter("auc_begin_date", aucBeginDate, TemporalType.DATE)
        .setParameter("auc_end_date", aucEndDate, TemporalType.DATE)
        .setParameter("proposal_label", proposal_label)
        .setParameter("auction_type", auction_type)
        .setFirstResult((page - 1) * pageSize)
        .setMaxResults(pageSize)
        .getResultList();


        String queryCount = "SELECT COUNT(*) " +
        "FROM AttachPropPrimaryKey a " +
        "JOIN Attachment file ON a.attachmentId = file.id " +
        "JOIN ProposalInfo prop ON a.proposalId = prop.id " +
        "JOIN AuctionInfo auc ON prop.auctionId = auc.id " +
        "JOIN ProjectInfo proj ON prop.projectId = proj.id " +
        "JOIN ResourceInfo res ON prop.resourceId = res.id " +
        "JOIN Customer cust ON prop.customerId = cust.id " +
        "JOIN period_info period_info ON auc.comPeriodId = period_info.id " +
        "WHERE (:attachment_id IS NULL OR a.attachmentId = :attachment_id) AND " +
        "(:file_name IS NULL OR LOWER(file.name) LIKE :file_name) " +
        "AND (:project_name IS NULL OR LOWER(proj.name) LIKE :project_name) " +
        "AND (:customer_name IS NULL OR LOWER(cust.name) LIKE :customer_name) " +
        "AND (:commitment_period_id IS NULL OR auc.comPeriodId = :commitment_period_id) " +
        "AND (:resource_name IS NULL OR LOWER(res.name) LIKE :resource_name) " +
        "AND (CAST(:auc_begin_date AS DATE) IS NULL OR (auc.aucBeginDate >= :auc_begin_date AND auc.aucEndDate >= :auc_begin_date)) " +
        "AND (CAST(:auc_end_date AS DATE) IS NULL OR (auc.aucBeginDate <= :auc_end_date AND auc.aucEndDate <= :auc_end_date)) " +
        "AND (:proposal_label IS NULL OR LOWER(prop.proposalLabel) LIKE :proposal_label) " +
        "AND (:auction_type IS NULL OR auc.type = :auction_type) ";

        Query count = em.createQuery(queryCount)
            .setParameter("attachment_id", attachment_id)
            .setParameter("file_name", file_name == null ? null : file_name.toLowerCase())
            .setParameter("project_name", project_name == null ? null : project_name.toLowerCase())
            .setParameter("customer_name", customer_name == null ? null : customer_name.toLowerCase())
            .setParameter("commitment_period_id", commitment_period_id)
            .setParameter("resource_name", resource_name == null ? null : resource_name.toLowerCase())
            .setParameter("auc_begin_date", aucBeginDate, TemporalType.DATE)
            .setParameter("auc_end_date", aucEndDate, TemporalType.DATE)
            .setParameter("proposal_label", proposal_label)
            .setParameter("auction_type", auction_type);

        Long total = (Long) count.getSingleResult();



        
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
                jsonResult.put("itemCount", total);

                
                jsonResults.add(jsonResult);
            }

            return jsonResults;

    }

    public static ArrayList<Map<String, Object>> queryForDocumentsOptional(Long attachment_id, String file_name, String project_name, String customer_name, Long commitment_period_id, String resource_name,
                                                                            String auc_begin_date, String auc_end_date, String proposal_label, String auction_type) {
        EntityManager em = EntityService.getEntityManagerFactory();
        file_name = file_name == null ? null : "%"+file_name+"%";
        customer_name = customer_name == null ? null : "%"+customer_name+"%";
        project_name = project_name == null ? null : "%"+project_name+"%";
        SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy");
        java.sql.Date aucBeginDate = null;
        java.sql.Date aucEndDate = null;
        java.util.Date begin_date = null;
        java.util.Date end_date = null;
        if (auc_begin_date != null) {
            try {
                begin_date = formatter.parse(auc_begin_date);
                aucBeginDate = new java.sql.Date(begin_date.getTime());
            } catch(Exception e) {
                throw new IllegalStateException("Can not parse begin date");
            }
        }
        if (auc_end_date != null) {
            try {
                end_date = formatter.parse(auc_end_date);
                aucEndDate = new java.sql.Date(end_date.getTime());
            } catch(Exception e) {
                throw new IllegalStateException("Can not parse end date");
            }
        }
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
        "(:file_name IS NULL OR file.name LIKE :file_name) " +
        "AND (:project_name IS NULL OR proj.name LIKE :project_name) " +
        "AND (:customer_name IS NULL OR cust.name LIKE :customer_name) " +
        "AND (:commitment_period_id IS NULL OR auc.comPeriodId = :commitment_period_id) " +
        "AND (:resource_name IS NULL OR res.name = :resource_name) " +
        "AND (CAST(:auc_begin_date AS DATE) IS NULL OR (auc.aucBeginDate >= :auc_begin_date AND auc.aucEndDate >= :auc_begin_date)) " +
        "AND (CAST(:auc_end_date AS DATE) IS NULL OR (auc.aucBeginDate <= :auc_end_date AND auc.aucEndDate <= :auc_end_date)) " +
        "AND (:proposal_label IS NULL OR prop.proposalLabel = :proposal_label) " +
        "AND (:auction_type IS NULL OR auc.type = :auction_type) " + 
        "ORDER BY file.name ASC")
        .setParameter("attachment_id", attachment_id)
        .setParameter("file_name", file_name)
        .setParameter("project_name", project_name)
        .setParameter("customer_name", customer_name)
        .setParameter("commitment_period_id", commitment_period_id)
        .setParameter("resource_name", resource_name)
        .setParameter("auc_begin_date", aucBeginDate, TemporalType.DATE)
        .setParameter("auc_end_date", aucEndDate, TemporalType.DATE)
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

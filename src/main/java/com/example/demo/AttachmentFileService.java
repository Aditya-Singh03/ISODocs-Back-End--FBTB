package com.example.demo;

import java.util.List;

import org.antlr.v4.runtime.atn.SemanticContext.OR;
import org.springframework.stereotype.Service;



import jakarta.persistence.EntityManager;

@Service
public class AttachmentFileService {
    public static List<Object> queryForDocuments(Long attachment_id, String file_name, String project_name, String customer_name, Long commitment_period_id, String resource_name) {
        EntityManager em = EntityService.getEntityManagerFactory();
        List<Object> var = em.createQuery("SELECT a.proposalId, a.attachmentId, file.name, prop.projectId, prop.projectType, prop.customerId, " +
        "prop.resourceId, prop.auctionId, prop.periodId, auc.id, auc.comPeriodId, auc.aucPeriodId, " +
        "auc.type, proj.name, res.name, cust.name " +
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
    
    public static List<Object> queryForDocumentsOptional(Long attachment_id, String file_name, String project_name, String customer_name, Long commitment_period_id, String resource_name) {
        EntityManager em = EntityService.getEntityManagerFactory();
        List<Object> var = em.createQuery("SELECT a.proposalId, a.attachmentId, file.name, prop.projectId, prop.projectType, prop.customerId, " +
        "prop.resourceId, prop.auctionId, prop.periodId, auc.id, auc.comPeriodId, auc.aucPeriodId, " +
        "auc.type, proj.name, res.name, cust.name " +
        "FROM AttachPropPrimaryKey a " +
        "JOIN Attachment file ON a.attachmentId = file.id " +
        "JOIN ProposalInfo prop ON a.proposalId = prop.id " +
        "JOIN AuctionInfo auc ON prop.auctionId = auc.id " +
        "JOIN ProjectInfo proj ON prop.projectId = proj.id " +
        "JOIN ResourceInfo res ON prop.resourceId = res.id " +
        "JOIN Customer cust ON prop.customerId = cust.id " +
        "WHERE (:attachment_id IS NULL OR a.attachmentId = :attachment_id) AND " +
        "(:file_name IS NULL OR file.name = :file_name) " +
        "AND (:project_name IS NULL OR proj.name LIKE :project_name) " +
        "AND (:customer_name IS NULL OR cust.name = :customer_name) " +
        "AND (:commitment_period_id IS NULL OR auc.comPeriodId = :commitment_period_id) " +
        "AND (:resource_name IS NULL OR res.name = :resource_name)")
        .setParameter("attachment_id", attachment_id)
        .setParameter("file_name", file_name)
        .setParameter("project_name", project_name)
        .setParameter("customer_name", customer_name)
        .setParameter("commitment_period_id", commitment_period_id)
        .setParameter("resource_name", resource_name)
        .getResultList();
        return var;
    }

}

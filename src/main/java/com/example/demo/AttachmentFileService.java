package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DocumentEntities.AttachPropPrimaryKey;

import jakarta.persistence.EntityManager;

@Service
public class AttachmentFileService {
    public static List<AttachPropPrimaryKey> queryForDocuments() {
        EntityManager em = EntityService.getEntityManagerFactory();
        List<AttachPropPrimaryKey> var = em.createQuery("SELECT a.proposal_id, a.attachment_id, file.file_name, prop.project_id, prop.project_type, prop.customer_id," +
        "prop.resource_id, prop.auction_id, prop.period_id, auc.auction_id, auc.commitment_period_id, auc.auction_period_id," +
        "auc.auction_type, proj.project_name, res.resource_name, cust.customer_name" +
        "FROM attach_proposal a" +
        "JOIN attachment_file file ON a.attachment_id = file.attachment_id" +
        "JOIN proposal_info prop on a.proposal_id = prop.proposal_id" +
        "JOIN auc_info auc on prop.auction_id = auc.auction_id" +
        "JOIN proj_info proj on prop.project_id = proj.project_id" +
        "JOIN res_info res ON prop.resource_id = res.resource_id" +
        "JOIN cust_info cust ON prop.customer_id = cust.customer_id" +
        "WHERE LOWER(a.attachment_id) = LOWER(:attachment_id) AND (:file_name IS NULL OR LOWER(file.file_name) = LOWER(:file_name)) AND" +
        "(:project_name IS NULL OR LOWER(proj.project_name) = LOWER(:project_name))" +
        "AND (:customer_name IS NULL OR LOWER(cust.customer_name) = LOWER(:customer_name) AND" +
        "(:commitment_period_id IS NULL OR LOWER(auc.commitment_period_id) = LOWER(:commitment_period_id))" +
        "AND (:resource_name IS NULL OR LOWER(res.resource_name) = LOWER(:resource_name));").getResultList();
        return var;
    }
    
}

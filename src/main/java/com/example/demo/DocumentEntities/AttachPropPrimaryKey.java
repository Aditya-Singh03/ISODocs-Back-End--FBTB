package com.example.demo.DocumentEntities;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AttachPropPrimaryKey {
    @Id
    @Column(name = "proposal_id")
    private Long proposalId;

    @Id
    @Column(name = "attachment_id")
    private Long attachmentId;

    @Column (name = "attachment_type")
    public String attachment_type;

    public AttachPropPrimaryKey() {
    }

    public AttachPropPrimaryKey(Long proposalId, Long attachmentId, String attachment_type) {
        this.proposalId = proposalId;
        this.attachmentId = attachmentId;
        this.attachment_type = attachment_type;
    }

    public Long getProposalId() {
        return this.proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public Long getAttachmentId() {
        return this.attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachment_type() {
        return this.attachment_type;
    }

    public void setAttachment_type(String attachment_type) {
        this.attachment_type = attachment_type;
    }
}


package com.github.axolotlix.dashboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dashboard")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprojects")
    private long id;
    @NotNull
    @Column(name = "portfolio_name")
    private String portfolio;
    @NotNull
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "description")
    private String projectDesc;
    @Column(name = "rag_status")
    private String ragStatus;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdAt;
    @Column(name = "last_updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getRagStatus() {
        return ragStatus;
    }

    public void setRagStatus(String ragStatus) {
        this.ragStatus = ragStatus;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}

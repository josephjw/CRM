package com.lawyer.crm.crm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    @Column(nullable = false)
    private boolean isDeleted;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        lastUpdatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdatedAt = new Date();
    }
}

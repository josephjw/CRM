package com.lawyer.crm.crm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Complaints extends BaseModel{
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;
    @ManyToOne
    private ClientUser userId;
    private String case_name;
    private String notes;
    private String description;
    private String fileUrl;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Actions action;
//    @Column(nullable = false)
//    private Boolean is_deleted = false; // Set default value

}

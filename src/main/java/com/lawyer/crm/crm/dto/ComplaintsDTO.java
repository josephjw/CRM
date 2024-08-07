package com.lawyer.crm.crm.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintsDTO {
    private String case_name;
    private String notes;
    private String description;
    private String fileUrl;
    private Long categoryId;
    private Long actionId;
    private Boolean is_deleted;

    // Getters and setters
}
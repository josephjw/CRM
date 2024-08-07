package com.lawyer.crm.crm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class ClientUser extends BaseModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private String customer_name;
    private String contact;
    private String email;
    private String notes;
    private String phone;
    private String address;


}

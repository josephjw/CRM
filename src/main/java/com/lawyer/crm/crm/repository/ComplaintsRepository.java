package com.lawyer.crm.crm.repository;


import com.lawyer.crm.crm.model.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintsRepository extends JpaRepository<Complaints,Long> {
    List<Complaints> findByAction_ActionNameNot(String actionname);
}

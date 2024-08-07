package com.lawyer.crm.crm.repository;


import com.lawyer.crm.crm.model.Category;
import com.lawyer.crm.crm.model.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}

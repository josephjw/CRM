package com.lawyer.crm.crm.service;

import com.lawyer.crm.crm.exceptions.ComplaintsNotExistsException;
import com.lawyer.crm.crm.model.Category;
import com.lawyer.crm.crm.model.Complaints;

import java.util.List;



public interface CategoryService {
    Category getSingleCategory(Long id) throws ComplaintsNotExistsException;

    List<Category> getAllCategory();

    Category updateCategory(Long id, Category complaints);

    Category replaceCategory(Long id, Category complaints);

    Category addNewCategory(Category complaints);

    boolean deleteCategory(Long id);
}
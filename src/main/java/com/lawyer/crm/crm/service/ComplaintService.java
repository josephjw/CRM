package com.lawyer.crm.crm.service;

import com.lawyer.crm.crm.exceptions.ComplaintsNotExistsException;
import com.lawyer.crm.crm.model.Complaints;

import java.util.List;

public interface ComplaintService {
    Complaints getSingleItem(Long id) throws ComplaintsNotExistsException;

    List<Complaints> getAllItem();

    Complaints updateItem(Long id, Complaints complaints);

    Complaints replaceItem(Long id, Complaints complaints);

    Complaints addNewItem(Complaints complaints);

    boolean deleteItem(Long id);
}
